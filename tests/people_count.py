import cv2
import numpy as np

def inside(r, q):
    rx, ry, rw, rh = r
    qx, qy, qw, qh = q
    return rx > qx and ry > qy and rx + rw < qx + qw and ry + rh < qy + qh

def draw_detections(img, rects, thickness = 1):
    for x, y, w, h in rects:
        # the HOG detector returns slightly larger rectangles than the real objects.
        # so we slightly shrink the rectangles to get a nicer output.
        pad_w, pad_h = int(0.15*w), int(0.05*h)
        cv2.rectangle(img, (x+pad_w, y+pad_h), (x+w-pad_w, y+h-pad_h), (0, 255, 0), thickness)

cap = cv2.VideoCapture(0)
hog = cv2.HOGDescriptor()
hog.setSVMDetector(cv2.HOGDescriptor_getDefaultPeopleDetector())

while(1):
    _, img = cap.read()

    gray=cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    found, w = hog.detectMultiScale(gray, winStride=(8,8), padding=(32,32), scale=1.2, group_threshold=2)
    found_filtered = []

    for ri, r in enumerate(found):
        for qi, q in enumerate(found):
            if ri != qi and inside(r, q):
                break
        else:
            found_filtered.append(r)

    draw_detections(gray, found)
    draw_detections(gray, found_filtered, 3)
    print('%d (%d) found' % (len(found_filtered), len(found)))

    cv2.imshow('img', gray)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()