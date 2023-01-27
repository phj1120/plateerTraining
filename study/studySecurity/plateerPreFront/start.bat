taskkill /f /im node.exe > NUL
IF NOT ERRORLEVEL 1 (
	ECHO NOT START PROJECT.
) ELSE (
	ECHO PROJECT KILL OK.	
)

:END

start yarn dev

Exit 0
