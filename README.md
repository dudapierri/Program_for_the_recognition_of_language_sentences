# Program_for_the_recognition_of_language_sentences
Applying the knowledge obtained in compilers, this application aims to make a program that recognizes sentences in a language in an interactive and simple way through a graphical interface.

ENTRY: string of characters (typed at the top of the window - field A), which may contain
any character from the ASCII table, including arithmetic operators (+ - * /), characters
control (white space, line break, tab), among others.

OUTPUT: input characters must be grouped, displayed (at the bottom of the window
- field B) and classified into the following categories:
• valid sentence: sentence belonging to language L;
• arithmetic operator: one of the special symbols (+ or - or * or /);
• ERROR – invalid sentence: sentence that starts with one of the symbols of the alphabet of the
language, but does not follow the specified training pattern or contains in sequence
invalid symbols;
• ERROR - invalid symbol(s): string of characters starting with symbols that do not
belong to the alphabet of the language in question, are not arithmetic operators, nor
control characters
