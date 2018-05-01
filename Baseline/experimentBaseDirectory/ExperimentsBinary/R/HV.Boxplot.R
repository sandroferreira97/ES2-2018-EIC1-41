postscript("HV.Boxplot.eps", horizontal=FALSE, onefile=FALSE, height=8, width=12, pointsize=10)
resultDirectory<-"../data"
qIndicator <- function(indicator, problem)
{
fileNSGAII<-paste(resultDirectory, "NSGAII", sep="/")
fileNSGAII<-paste(fileNSGAII, problem, sep="/")
fileNSGAII<-paste(fileNSGAII, indicator, sep="/")
NSGAII<-scan(fileNSGAII)

fileSMSEMOA<-paste(resultDirectory, "SMSEMOA", sep="/")
fileSMSEMOA<-paste(fileSMSEMOA, problem, sep="/")
fileSMSEMOA<-paste(fileSMSEMOA, indicator, sep="/")
SMSEMOA<-scan(fileSMSEMOA)

fileMOCell<-paste(resultDirectory, "MOCell", sep="/")
fileMOCell<-paste(fileMOCell, problem, sep="/")
fileMOCell<-paste(fileMOCell, indicator, sep="/")
MOCell<-scan(fileMOCell)

fileMOCH<-paste(resultDirectory, "MOCH", sep="/")
fileMOCH<-paste(fileMOCH, problem, sep="/")
fileMOCH<-paste(fileMOCH, indicator, sep="/")
MOCH<-scan(fileMOCH)

filePAES<-paste(resultDirectory, "PAES", sep="/")
filePAES<-paste(filePAES, problem, sep="/")
filePAES<-paste(filePAES, indicator, sep="/")
PAES<-scan(filePAES)

fileRandomSearch<-paste(resultDirectory, "RandomSearch", sep="/")
fileRandomSearch<-paste(fileRandomSearch, problem, sep="/")
fileRandomSearch<-paste(fileRandomSearch, indicator, sep="/")
RandomSearch<-scan(fileRandomSearch)

fileSPEA2<-paste(resultDirectory, "SPEA2", sep="/")
fileSPEA2<-paste(fileSPEA2, problem, sep="/")
fileSPEA2<-paste(fileSPEA2, indicator, sep="/")
SPEA2<-scan(fileSPEA2)

algs<-c("NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2")
boxplot(NSGAII,SMSEMOA,MOCell,MOCH,PAES,RandomSearch,SPEA2,names=algs, notch = FALSE)
titulo <-paste(indicator, problem, sep=":")
title(main=titulo)
}
par(mfrow=c(1,1))
indicator<-"HV"
qIndicator(indicator, "MyProblemBinary")
