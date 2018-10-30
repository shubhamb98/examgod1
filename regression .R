library(caret)

input <- read.csv("F:/New folder/print/ML/MLprog/practical exam/Regression/DataSets/input.csv")
attach(input)
names(input)

plot(runs~at_bats,main="Runs Vs At_bats",xlim=c(5350,5750),ylim=c(500,900))
train=input[1:18,]
cv=input[19:24,]
test=input[25:30,]

mse_train = numeric()
mse_test = numeric()
mse_cv=numeric()
for(i in 1:24) {
 
  train=input[1:i,]
  model=lm(runs~at_bats,data = train[1:i,])
  
  predict=predict(model,train)
  mse_train[i] = (mean((predict - train$runs)^2))
  
  predict=predict(model,test)
  mse_test[i] = (mean((predict - test$runs)^2))
  
  predict=predict(model,cv)
  mse_cv[i] = (mean((predict - cv$runs)^2))
  

   
}

abline(model,col="blue",lwd=3)

print(mse_test)
print(mse_train)
plot(mse_train, type="l")
plot(mse_cv, type = "l")
plot(mse_test, type = "l")

#High Bias
plot(mse_train, type="l",xlim = c(0,30),ylim = c(0,20000))
lines(mse_cv,col="red")


#Subset election
plot(runs~homeruns,main="Runs Vs At_bats")
train = input[1:24,]
test = input[24:30,]
model=lm(runs~homeruns,data = train)
print(model)
abline(model,col="blue",lwd=3)
predict=predict(model,test)
mse_test = (mean((predict - test$runs)^2))
print(mse_test)
