grammar Calculator ;

/***********************************************************
 * Parser rules: define grammars
 **********************************************************/
expr
	: expr op=( MUL | DIV ) expr	# mulOrDiv
	| expr op=( ADD | SUB ) expr	# addOrSub
	| '(' expr ')'					# bracket
	| INT							# integer
	| DOUBLE						# double
	;


/***********************************************************
 * Lexer rules: define tokens
 **********************************************************/
INT 	: [0-9]+;         			// integer
DOUBLE	: [0-9]+'.'[0-9]+;			// double

MUL 	: '*';
DIV 	: '/';
ADD 	: '+';
SUB 	: '-';

WS  	: [ \t\r]+ -> skip;			// whitespace
