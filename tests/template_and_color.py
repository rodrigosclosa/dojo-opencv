import imutils
import glob
import cv2
import numpy as np
import time


frameWidth =0
frameHeigth = 0
startXinicial = 0
startYinicial = 0
contador = 0
contadorSaida = 0
tempoContadorAchou = 30
tempoContadorNaoAchou = 150
yellowLower = np.array([91,227,213])
yellowUpper = np.array([203,255,255])

def avalia_placa(startX, startY, startXinicial, startYinicial, contador):
    tolerancia = 10
    if ((startXinicial >= startX - tolerancia and startXinicial <= startX + tolerancia)
        and (startYinicial >= startY - tolerancia and startYinicial <= startY + tolerancia)):
        contador += 1
    else:
        startXinicial = startX
        startYinicial = startY
        contador = 0

    return startXinicial, startYinicial, contador

cap = cv2.VideoCapture(0)
_, imgSize = cap.read()

frameHeigth, frameWidth, channels = imgSize.shape

# Load the image from file, converts it to gray scale and find the image edges (contornos)
template = cv2.imread('placa_cuidado.jpg')
template = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
template = cv2.Canny(template, 50, 200)

# Gets the image height and width
(tH, tW) = template.shape[::-1]

img = cv2.medianBlur(template,5)

ret,th1 = cv2.threshold(template,127,255,cv2.THRESH_BINARY)

template = th1

edged = None


# frameHeigth = cv2.VideoCapture.get(frame,CV_CAP_PROP_FRAME_HEIGHT)
#frameHeigth = cap.get(cv2.CV_CAP_PROP_FRAME_HEIGHT)

while(1):
    #_, image = cap.read()
    #print strftime("%S", gmtime())


    (grabbed, frame) = cap.read()

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    found = None

    # check to see if we have reached the end of the
    # video
    if not grabbed:
        break

    # determine which pixels fall within the blue boundaries
    # and then blur the binary image
    blue = cv2.inRange(frame, yellowLower, yellowUpper)
    blue = cv2.GaussianBlur(blue, (3, 3), 0)

    # find contours in the image
    (_, cnts, _) = cv2.findContours(blue.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # check to see if any contours were found
    if len(cnts) > 0:
        # sort the contours and find the largest one -- we
        # will assume this contour correspondes to the area
        # of my phone
        cnt = sorted(cnts, key=cv2.contourArea, reverse=True)[0]

        # compute the (rotated) bounding box around then
        # contour and then draw it
        rect = np.int32(cv2.boxPoints(cv2.minAreaRect(cnt)))

        # loop over the scales of the image
        for scale in np.linspace(0.9, 1.0, 1.5)[::-1]:
            # resize the image according to the scale, and keep track
            # of the ratio of the resizing
            resized = imutils.resize(gray, width = int(gray.shape[1] * scale))
            r = gray.shape[1] / float(resized.shape[1])

            # if the resized image is smaller than the template, then break
            # from the loop

            if resized.shape[0] < tH or resized.shape[1] < tW:
                break

            # detect edges in the resized, grayscale image and apply template
            # matching to find the template in the image
            # edged = cv2.Canny(resized, 50, 200)

            edged = cv2.medianBlur(resized,5)
            ret,edged = cv2.threshold(edged,127,255,cv2.THRESH_BINARY)


            cannyEdge = cv2.Canny(edged, 50, 200)

            result = cv2.matchTemplate(cannyEdge, template, cv2.TM_CCOEFF)
            (_, maxVal, _, maxLoc) = cv2.minMaxLoc(result)

            # unpack the bookkeeping varaible and compute the (x, y) coordinates
            # of the bounding box based on the resized ratio
            (startX, startY) = (int(maxLoc[0] * r), int(maxLoc[1] * r))
            (endX, endY) = (int((maxLoc[0] + tW) * r), int((maxLoc[1] + tH) * r))

            # draw a bounding box around the detected result and display the image
            if startX > 0 and startY > 0:
                (startXinicial, startYinicial, contador) = avalia_placa(startX, startY, startXinicial, startYinicial, contador)
                cv2.rectangle(frame, (startX, startY), (endX, endY), (255, 255, 255), 2)
                if contador >= tempoContadorAchou:
                    contadorSaida = 0

                    if startX > (frameWidth - 50) / 2:
                        cv2.putText(frame, "ACHEI FEMININO", (startX, endY), cv2.FONT_HERSHEY_SIMPLEX, 2, (255, 255, 255))
                    else:
                        cv2.putText(frame, "ACHEI MASCULINO", (startX, endY), cv2.FONT_HERSHEY_SIMPLEX, 2, (255, 255, 255))

                else:
                    contadorSaida += 1
                if contadorSaida >= tempoContadorNaoAchou:
                    cv2.putText(frame, "SUMIU", (startX, endY), cv2.FONT_HERSHEY_SIMPLEX, 2, (255, 255, 255))

    cv2.line(frame, (0,(frameHeigth / 2)),(frameWidth,(frameHeigth / 2)), (255, 255, 0), 5)
    cv2.line(frame, (0, ((frameHeigth + 100) / 2)), (frameWidth, ((frameHeigth + 100) / 2)), (0, 0, 255), 5)
    cv2.line(frame, ((frameWidth / 2), 0), ((frameWidth / 2), frameHeigth), (255, 0, 0), 50)
    #cv2.line(frame, frameWidth/2, frameWidth, (255), 1, 8, 0)
    cv2.imshow("Tracking", frame)
    #cv2.imshow("Binary", blue)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

    #time.sleep(1)

cv2.destroyAllWindows()
cap.release()
