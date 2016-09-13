import cv2
from matplotlib import pyplot as plt
import numpy as np
import imutils

img = cv2.imread('yellow-sign-images/IMG_20160330_114049020.jpg')
img[:,:,1] = 0

#hist = cv2.calcHist(img, [0,1, 2])
#cv2.imshow('hist', hist)

cv2.imshow("image", img)

# convert the image to grayscale and create a histogram
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
#gray = imutils.resize(gray, width = 600)
#cv2.imshow("gray", gray)
hist = cv2.calcHist([gray], [0], None, [256], [0, 256])
#print(hist)
plt.figure()
plt.title("Grayscale Histogram")
plt.xlabel("Bins")
plt.ylabel("# of Pixels")
plt.plot(hist)
plt.xlim([0, 256])
plt.show()
# grab the image channels, initialize the tuple of colors,
# the figure and the flattened feature vector
chans = cv2.split(img)
colors = ("b", "g", "r")
plt.figure()
plt.title("'Flattened' Color Histogram")
plt.xlabel("Bins")
plt.ylabel("# of Pixels")
features = []
plt.show()
# loop over the image channels
for (chan, color) in zip(chans, colors):
	# create a histogram for the current channel and
	# concatenate the resulting histograms for each
	# channel
	hist = cv2.calcHist([chan], [0], None, [256], [0, 256])
	features.extend(hist)

	# plot the histogram
	plt.plot(hist, color = color)
	plt.xlim([0, 256])
plt.show()
# here we are simply showing the dimensionality of the
# flattened color histogram 256 bins for each channel
# x 3 channels = 768 total values -- in practice, we would
# normally not use 256 bins for each channel, a choice
# between 32-96 bins are normally used, but this tends
# to be application dependent
print "flattened feature vector size: %d" % (np.array(features).flatten().shape)

while(1):
    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break