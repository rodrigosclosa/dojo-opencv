import imutils
import glob
import cv2
import numpy as np
from matplotlib import pyplot as plt

blueLower = np.array([91,227,213])
blueUpper = np.array([203,255,255])

cap = cv2.VideoCapture(0)

# Load the image from file, converts it to gray scale and find the image edges (contornos)
template = cv2.imread('placa_cuidado.jpg')
template = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
template = cv2.Canny(template, 50, 200)

# Gets the image height and width
(tH, tW) = template.shape[::-1]
#cv2.imshow("Template", template)
#cv2.waitKey(0)

#img = cv2.imread('logo-larger.jpg',0)
img = cv2.medianBlur(template,5)

ret,th1 = cv2.threshold(template,127,255,cv2.THRESH_BINARY)

plt.subplot(2,2,1),
plt.imshow(th1,'gray')
plt.title('Teste')
plt.xticks([]),
plt.yticks([])
plt.show()


template = th1



edged = None

while(1):
    _, image = cap.read()

    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    found = None

    (grabbed, frame) = cap.read()

    # check to see if we have reached the end of the
    # video
    if not grabbed:
        break

    # hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    # determine which pixels fall within the blue boundaries
    # and then blur the binary image
    blue = cv2.inRange(frame, blueLower, blueUpper)
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
        #cv2.drawContours(frame, [rect], -1, (0, 255, 0), 2)


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

            # draw a bounding box around the detected region
            # clone = np.dstack([edged, edged, edged])
            # cv2.rectangle(clone, (maxLoc[0], maxLoc[1]),
            #     (maxLoc[0] + tW, maxLoc[1] + tH), (0, 0, 255), 2)
            # cv2.imshow("Visualize", clone)
            # cv2.waitKey(0)

            # if we have found a new maximum correlation value, then ipdate
            # the bookkeeping variable
            #if found is None or maxVal > found[0]:
            #    found = (maxVal, maxLoc, r)

        # unpack the bookkeeping varaible and compute the (x, y) coordinates
        # of the bounding box based on the resized ratio
        #if found is not None:
            #(_, maxLoc, r) = found
            (startX, startY) = (int(maxLoc[0] * r), int(maxLoc[1] * r))
            (endX, endY) = (int((maxLoc[0] + tW) * r), int((maxLoc[1] + tH) * r))

            # draw a bounding box around the detected result and display the image
            if startX > 0 and startY > 0:
                cv2.rectangle(frame, (startX, startY), (endX, endY), (255, 255, 255), 2)

    #cv2.imshow("Image", image)
    cv2.imshow("Tracking", frame)
    cv2.imshow("Binary", blue)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()
