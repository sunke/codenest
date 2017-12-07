grammar Calculator ;

/***********************************************************
 * Parser rules: define grammars
 **********************************************************/
input
	: setVar NL input             # ToSetVar
	| plusOrMinus NL? EOF         # Calculate ;

setVar
	: ID EQUAL plusOrMinus        # SetVariable ;

plusOrMinus 
	: plusOrMinus PLUS multOrDiv  # Plus
	| plusOrMinus MINUS multOrDiv # Minus
	| multOrDiv                   # ToMultOrDiv ;

multOrDiv
	: multOrDiv MULT pow          # Multiplication
	| multOrDiv DIV pow           # Division
	| pow                         # ToPow ;

pow
	: unaryMinus (POW pow)?       # Power ;

unaryMinus
	: MINUS unaryMinus            # ChangeSign
	| atom                        # ToAtom ;

atom
	: PI                          # ConstantPI
	| E                           # ConstantE
	| DOUBLE                      # Double
	| INT                         # Int
	| ID                          # Variable
	| LPAR plusOrMinus RPAR       # Braces ;


/***********************************************************
 * Lexer rules: define tokens
 **********************************************************/
ID		: [a-zA-Z_][a-zA-Z_0-9]* ;

INT		: [0-9]+ ;

DOUBLE	: [0-9]+'.'[0-9]+ ;

PI		: 'pi' ;

E		: 'e' ;

POW		: '^' ;

PLUS	: '+' ;

EQUAL	: '=' ;

MINUS	: '-' ;

MULT	: '*' ;

DIV		: '/' ;

LPAR	: '(' ;

RPAR	: ')' ;

NL		: '\n' ;

WS		: [ \t\r]+ -> skip ;