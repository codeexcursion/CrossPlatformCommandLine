## JFindReplace

A tool that will recursively search files in a directory structure.  Replacing values if so instructed.

* Search files
* Find and replace in files
* Seperate command line options for regular expression find and replace.
* Should be able to use regular expressions across multiple lines.
* Should NOT recurse by default.
* Default to filename only in results.
* Detect and skip binary files for replace?
* Application will accept command line parameters.
* These parameters will consist of space flags and values.
* Flags begin with one hyphen always.
* Flag parameters
* Print help instructions
* Suppressing ANSI color codes will be -noansi.
* Directory flag will be -d and -directory followed by a String representing a directory.  This flag will be optional.
* Suppress results flag will be -s and -suppress which will prevent any results being outputted.  This will not affect error output.
* Max file size flage will be -m and -maximum which will set the max file size allowable for processing.  Default will be 65k.
* File include flag will be -i and -include followed by a String representing a filename or filename pattern.
* File exclude flag will be -e and -exclude followed by a String representing a filename or filename pattern.
* Regex Find flag will be -f and -find followed by a String representing a regular expression pattern.
* Regex Replace flag will be -r and -replace followed by a String representing a regular expression replacement pattern.
* Recursion flag will be -recursion.
* Display content flag will be -c and -content.
* Help flag will be -h or -help



