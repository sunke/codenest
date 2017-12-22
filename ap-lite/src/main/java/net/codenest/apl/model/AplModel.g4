grammar AplModel;

/***********************************************************
 * AP Lite grammar rules
 **********************************************************/
modelDefinition: (classDefinition)+ ;

classDefinition
 	: className '=' 'class' ';'
 	| className '=' 'class' '{' 
	 		(childrenDefinition)? 
	 		(propertiesDefinition)? 
	 		(attributesDefinition)? 
	 		(auxDefinition*)?
 		'}' ';'
 	;

childrenDefinition: 'children' '{' (childDefinition)* '}' ';' ;

propertiesDefinition
	: 'properties' '{'
 		( propertyDefinition
 		| propertyConstraint
 		| propertyUnitDefinition
 		)* '}' ';'
 	;
 	
attributesDefinition: 'attributes' '=' attributeName (',' attributeName)* ';' ;

auxDefinition: 
 	classUnitDefinition
 	| classDescriptionDefinition
 	| classResourceNameDefinition
 	| classGraphInfoDefinition
 	| classSortCodeDefinition
 	| classIconDefinition
 	| classColorDefinition
 	| effectivityDefinition
 	| componentsDefinition
	;
 
childDefinition: className ';' | className childAttributes ';' ;

childAttributes: '{' relationDefinition '}' ;
 
relationDefinition: 'relation' '=' 'automatic' ';' ;

propertyDefinition: propertyName ('.derived')? '=' ('undefined' | expression) ';' ;

propertyConstraint: propertyName ('>' | '<' | '>=' | '<=') expression ';' ;

propertyUnitDefinition: propertyName '.unit' '=' literalString ';' ;
  
expression
	: '(' expression ')'
 	| '-' expression
 	| expression ('/' | '*') expression
 	| expression ('-' | '+') expression
 	| expression '|' expression
 	| functionStatement
 	| dateTimeVariable
 	| propertyName
 	| NUMBER
	;

dateTimeVariable: '%' ('minute' | 'hour' | 'day' | 'week' | 'month' | 'year') ;
 
literalString: LITERALSTRING ;
 
className: IDENTIFIER ;

propertyName: IDENTIFIER ;

attributeName : IDENTIFIER ;

classPropertyRef: className '.' propertyName ;

classUnitDefinition: 'unit' '=' literalString ';' ;

classDescriptionDefinition: 'description' '=' literalString ';' ;

classResourceNameDefinition: 'resource' 'name' '=' literalString ';' ;

classGraphInfoDefinition: 'graph' 'info' '=' literalString ';' ;

classSortCodeDefinition: 'sort' 'code' '=' NUMBER ';' ;

classIconDefinition: 'icon' '=' literalString ';' ;

classColorDefinition: 'color' '=' literalString ';' ;

componentsDefinition: 'components' '=' className ',' className	(',' 'automatic')? ';' ;

effectivityDefinition: 'effectivity' '=' ('range' | 'moment') ';' ;

functionStatement
	: sumFunction
 	| boolFunction
 	| collectFunction
 	| shiftFunction
 	| ifFunction
 	| coverFunction
 	| maxFunction
 	| minFunction
 	| maxClassFunction
 	| minClassFunction
 	| intFunction
 	| invcoverFunction
 	| shiftFunction
	;

 // Syntax for specific functions
boolFunction: 'bool' '(' expression ')' ;

ifFunction: 'if' '(' expression ',' expression ',' expression ')' ;

collectFunction: 'collect' '(' expression ',' expression ',' expression')' ;

coverFunction: 'cover' '(' expression ',' expression (',' expression)? ')' ;

shiftFunction: 'shift' '(' expression ',' expression ')' ;

maxFunction: 'max' '(' expression (',' expression)* ')' ;

minFunction: 'min' '(' expression (',' expression)* ')' ;

sumFunction: 'sum' '(' classPropertyRef (',' classPropertyRef)* ')' ;

maxClassFunction: 'max' '(' classPropertyRef (',' classPropertyRef)* ')' ;

minClassFunction: 'min' '(' classPropertyRef (',' classPropertyRef)* ')' ;

intFunction: 'int' '(' expression ')' ;

invcoverFunction: 'invcover' '(' expression ',' expression ')' ;

 
 /***********************************************************
 * AP Lite lexer rules
 **********************************************************/
DIGIT: [0-9];

EXP: [Ee] [+-]? [0-9]+ ;

IDENTIFIER: [a-zA-Z] ([ a-zA-Z0-9_]? [a-zA-Z0-9_])*; 

DAY_NAME: 'mon' | 'tue' | 'wed' | 'thu' | 'fri' | 'sat' | 'sun' ;
 
LITERALSTRING: '"' .*? '"' ;

NUMBER: ((DIGIT+ '.' DIGIT* EXP?) | (DIGIT* '.' DIGIT+ EXP?) | (DIGIT+ EXP) | (DIGIT+)) | '-' NUMBER ;

LINE_COMMENT: '//' .*? [\r\n] -> skip;

BLOCK_COMMENT: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;