import cv2
import numpy as np
from matplotlib import pyplot as plt

img = cv2.imread('placa.jpg',0)
img = cv2.medianBlur(img,5)

ret,th1 = cv2.threshold(img,127,255,cv2.THRESH_BINARY)

plt.subplot(2,2,1),
plt.imshow(th1,'gray')
plt.title('Teste')
plt.xticks([]),
plt.yticks([])
plt.show()



