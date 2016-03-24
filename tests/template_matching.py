import cv2
import numpy as np

cap = cv2.VideoCapture(0)

while(1):
    _, frame = cap.read()

    #img_rgb = cv2.imread('foto.jpg')
    img_gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    template = cv2.imread('padrao3.jpg',0)
    w, h = template.shape[::-1]

    res = cv2.matchTemplate(img_gray,template,cv2.TM_CCOEFF_NORMED)
    threshold = 0.95
    loc = np.where( res >= threshold)

    for pt in zip(*loc[::-1]):
        cv2.rectangle(frame, pt, (pt[0] + w, pt[1] + h), (0,255,255), 2)

    cv2.imshow('Detected',frame)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()