import numpy as np
import cv2
from matplotlib import pyplot as plt

cap = cv2.VideoCapture(0)

while(1):
    _, frame = cap.read()

    #img = cv2.imread('opencv-python-foreground-extraction-tutorial.jpg')
    mask = np.zeros(frame.shape[:2],np.uint8)

    bgdModel = np.zeros((1,65),np.float64)
    fgdModel = np.zeros((1,65),np.float64)

    rect = (161,79,150,150)
    cv2.grabCut(frame,mask,rect,bgdModel,fgdModel,5,cv2.GC_INIT_WITH_RECT)
    mask2 = np.where((mask==2)|(mask==0),0,1).astype('uint8')
    img = frame*mask2[:,:,np.newaxis]

    plt.imshow(frame)
    plt.colorbar()
    plt.show()

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()