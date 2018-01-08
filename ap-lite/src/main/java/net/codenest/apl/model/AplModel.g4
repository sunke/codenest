grammar AplModel;

/***********************************************************
 * AP Lite grammar rules
 **********************************************************/
modelDef: (classDef)+ ;

classDef
 	: className '=' 'class' ';'
 	| className '=' 'class' '{' 
	 		(childrenDef)? 
	 		(propertiesDef)? 
	 		(attributesDef)? 
	 		(componentsDef)?
	 		(auxiliaryDef)*
 		'}' ';'
 	;

childrenDef: 'children' '{' (childDef)* '}' ';' ;

propertiesDef
	: 'properties' '{'
 		( propertyDef
 		| propertyConstraint
 		| propertyUnitDef
 		)* '}' ';'
 	;
 	
attributesDef: 'attributes' '=' attributeName (',' attributeName)* ';' ;

componentsDef: 'components' '=' className ',' className	(',' 'automatic')? ';' ;

auxiliaryDef
	: classUnitDef
 	| classDescriptionDef
 	| classResourceNameDef
 	| classGraphInfoDef
 	| classSortCodeDef
 	| classIconDef
 	| classColorDef
 	| effectivityDef
	;
 
childDef: className ';' | className childAttributes ';' ;

childAttributes: '{' relationDef '}' ;
 
relationDef: 'relation' '=' 'automatic' ';' ;

propertyDef: propertyName ('.derived')? '=' ('undefined' | expression) ';' ;

propertyConstraint: propertyName ('>' | '<' | '>=' | '<=') expression ';' ;

propertyUnitDef: propertyName '.unit' '=' literalString ';' ;
  
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

classUnitDef: 'unit' '=' literalString ';' ;

classDescriptionDef: 'description' '=' literalString ';' ;

classResourceNameDef: 'resource' 'name' '=' literalString ';' ;

classGraphInfoDef: 'graph' 'info' '=' literalString ';' ;

classSortCodeDef: 'sort' 'code' '=' NUMBER ';' ;

classIconDef: 'icon' '=' literalString ';' ;

classColorDef: 'color' '=' literalString ';' ;

effectivityDef: 'effectivity' '=' ('range' | 'moment') ';' ;

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