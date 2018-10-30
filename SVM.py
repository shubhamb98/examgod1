#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm


# In[4]:


X = np.array([[1,2],[5,8],[1.5,1.8],[8,8],[1,0.6],[9,11]])
y = [0,1,0,1,0,1]


# In[13]:


clf = svm.SVC(kernel='linear', C = 1.0)
clf.fit(X,y)
w = clf.coef_[0]
print(w)
a = -w[0] / w[1]
xx = np.linspace(0,12)
yy = a * xx - clf.intercept_[0] / w[1]
h0 = plt.plot(xx, yy, 'k-', label="Non weighted div")
plt.scatter(X[:, 0], X[:, 1], c = y)
plt.legend()
plt.show()

print("Prediction of target for 0.58,0.76 values:")
t= clf.predict([[0.58,0.76]])
print(t)

print("Prediction of target for 10.58,10.76 value")
t= clf.predict([[10.58,10.76]])
print(t)


# In[ ]:





# In[ ]:




