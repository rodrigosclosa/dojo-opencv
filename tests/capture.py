import cv2
cap = cv2.VideoCapture(0)
s, img = cap.read()
cv2.imwrite('pic.png', img)