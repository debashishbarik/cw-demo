C:\UBS\certf>java InstallCert.java localhost:8081
C:\UBS\certf>javac InstallCert.java

C:\UBS\certf>java InstallCert localhost:8081

check now:
C:\UBS\certf>java InstallCert localhost:8081
Loading KeyStore jssecacerts...
Opening connection to localhost:8081...
Starting SSL handshake...

No errors, certificate is already trusted

Server sent 1 certificate(s):

 1 Subject CN=localhost
   Issuer  CN=localhost
   sha1    a0 34 13 3f 60 b3 2b 48 27 48 e0 ad cd f1 1a 11 92 da 36 88
   md5     15 9a 1a 0e 8c 6c fd 36 54 78 72 3c 1d 60 64 44

Enter certificate to add to trusted keystore or 'q' to quit: [1]
q
KeyStore not changed


--------
Copy the jssecacerts file into C:\Program Files\Java\jdk1.8.0_231\jre\lib\security