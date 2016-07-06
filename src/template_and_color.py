import imutils
import glob
import cv2
import numpy as np
import time



tempoContadorAchou = 30
tempoContadorNaoAchou = 150
caminhoImagem = 'placa_cuidado.jpg'
yellowLower = np.array([91, 227, 213])
yellowUpper = np.array([203, 255, 255])



# Verifica se a placa mudou de posicao
def avalia_placa(startX, startY, startXinicial, startYinicial, contador):
    # TODO: usar como constante
    tolerancia = 10

    if ((startXinicial >= startX - tolerancia and startXinicial <= startX + tolerancia)
        and (startYinicial >= startY - tolerancia and startYinicial <= startY + tolerancia)):
        contador += 1
    else:
        startXinicial = startX
        startYinicial = startY
        contador = 0

    return startXinicial, startYinicial, contador


def escrever_tela(frame, mensagem, startX, endY) :
    cv2.putText(frame, mensagem, (startX, endY), cv2.FONT_HERSHEY_SIMPLEX, 2, (255, 255, 255))


def procura_placa (startX, startY, startXinicial, startYinicial, contador, contadorSaida, frame, endX, endY):
    frameHeigth, frameWidth, channels = frame.shape
    if startX > 0 and startY > 0:
        (startXinicial, startYinicial, contador) = avalia_placa(startX, startY, startXinicial, startYinicial, contador)

        cv2.rectangle(frame, (startX, startY), (endX, endY), (255, 255, 255), 2)

        if contador >= tempoContadorAchou:
            contadorSaida = 0

            if startX > (frameWidth - 50) / 2:
                mensagem = "ACHEI FEMININO"
            else:
                mensagem = "ACHEI MASCULINO"

            escrever_tela(frame,mensagem, startX, endY)
        else:
            contadorSaida += 1

        if contadorSaida >= tempoContadorNaoAchou:
            escrever_tela(frame, "SUMIU", startX, endY)

    return contador, contadorSaida, startXinicial, startYinicial



def desenha_linhas(frame) :
    frameHeigth, frameWidth, channels = frame.shape
    cv2.line(frame, (0,(frameHeigth / 2)),(frameWidth,(frameHeigth / 2)), (255, 255, 0), 5)
    cv2.line(frame, (0, ((frameHeigth + 100) / 2)), (frameWidth, ((frameHeigth + 100) / 2)), (0, 0, 255), 5)
    cv2.line(frame, ((frameWidth / 2), 0), ((frameWidth / 2), frameHeigth), (255, 0, 0), 50)




def trata_imagem() :
    template = cv2.imread(caminhoImagem)
    template = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
    template = cv2.Canny(template, 50, 200)

    (tH, tW) = template.shape[::-1]

    _, template = cv2.threshold(template, 127, 255, cv2.THRESH_BINARY)

    return template, tH, tW


def achou_cor(frame):
    yellow = cv2.inRange(frame, yellowLower, yellowUpper)
    yellow = cv2.GaussianBlur(yellow, (3, 3), 0)

    (_, cnts, _) = cv2.findContours(yellow.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    return len(cnts) > 0


def recuperar_posicoes(frame, scale):
    template, tH, tW = trata_imagem()
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    resized = imutils.resize(gray, width=int(gray.shape[1] * scale))
    r = gray.shape[1] / float(resized.shape[1])

    if resized.shape[0] < tH or resized.shape[1] < tW:
        return 0,0,0,0


    edged = cv2.medianBlur(resized, 5)
    _, edged = cv2.threshold(edged, 127, 255, cv2.THRESH_BINARY)

    cannyEdge = cv2.Canny(edged, 50, 200)

    result = cv2.matchTemplate(cannyEdge, template, cv2.TM_CCOEFF)
    (_, maxVal, _, maxLoc) = cv2.minMaxLoc(result)

    (startX, startY) = (int(maxLoc[0] * r), int(maxLoc[1] * r))
    (endX, endY) = (int((maxLoc[0] + tW) * r), int((maxLoc[1] + tH) * r))

    return startX, startY, endX, endY







def main():
    startXinicial = 0
    startYinicial = 0
    contador = 0
    contadorSaida = 0

    cap = cv2.VideoCapture(0)

    edged = None

    while(1):
        (grabbed, frame) = cap.read()

        if not grabbed:
            break

        found = None

        if achou_cor(frame):
            for scale in np.linspace(0.9, 1.0, 1.5)[::-1]:
                startX, startY, endX, endY = recuperar_posicoes(frame, scale)

                if  (startX + startY + endX + endY) > 0:
                    (contador, contadorSaida, startXinicial, startYinicial) = procura_placa(startX, startY, startXinicial, startYinicial, contador, contadorSaida, frame, endX, endY)
                else:
                    break


        desenha_linhas(frame)
        cv2.imshow("Tracking", frame)

        k = cv2.waitKey(5) & 0xFF
        if k == 27:
            break

    cv2.destroyAllWindows()
    cap.release()


main()
