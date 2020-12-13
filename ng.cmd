@ECHO OFF

SETLOCAL
CD c:\seed
SET PATH=%PATH%;C:\seed\node
node ".\node_modules\@angular\cli\bin\ng" %*