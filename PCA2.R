my_data = read.csv("/home/abhi/Documents/practical exam/PCA/pca_gsp.csv")
attach(my_data)
names(my_data)

x = cbind(Ag, Mining, Constr, Manuf, Manuf_nd, Transp, Comm,
          Energy, TradeW, TradeR, RE, Services, Govt)
summary(x)
cor(x)

help("princomp")
pcal = princomp(x, scores = T, cor = T)
summary(pcal)
loadings(pcal)

plot(pcal)
screeplot(pcal, type = "line", main = "Scree plot")
biplot(pcal)
pcal$scores[1:10,]
