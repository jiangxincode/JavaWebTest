grammar DateCalculator;

fragment SINGLE_SPACE   : '\u0020'; // ' '
fragment TABULATION     : '\u0009'; // '\t'
fragment LINE_FEED      : '\u000A'; // '\n'
fragment CARRAIGE_RETURN: '\u000D'; // '\r'

WhiteSpace    : ( SINGLE_SPACE | TABULATION )+ -> skip;
NewLine       : ( CARRAIGE_RETURN | LINE_FEED )+ -> skip;

Add: '+';
Substract: '-';
Slash: '/';
Colon: ':';
Dash : '-';
Dot : '.';

Data :
    ('0'?[1-9] | [1-2][0-9] | '3'[0-1])//day
    (Slash|Dash|Dot)
    ('0'?[1-9] | '1'[0-2]) //Month
    (Slash|Dash|Dot)
    ([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])//year
    ;
Time:
    ([0-1][0-9]|'2'[0-3])
    Colon
    ([0-5][0-9]) //min
    Colon
    ([0-5][0-9])//sec
    ;
Timespan:('0'|([1-9][0-9]*))Colon
                              ([0-5][0-9]) //min
                              Colon
                              ([0-5][0-9])//sec
                              ;


timeSpan : Time|Timespan;

dataTime: Data('|')Time;

expressionResultData :
timeSpan op=Add dataTime|
timeSpan op=Add expressionResultData|
dataTime op=(Substract|Add) timeSpan|
dataTime op=(Add|Substract) expressionResultTime|
expressionResultData op=(Substract|Add) timeSpan|
expressionResultData op=(Substract|Add) expressionResultTime
;

expressionResultDataRightERT:
expressionResultTime op=Add dataTime|
expressionResultTime op=Add expressionResultData;

expressionResultTime:
dataTime op=Substract dataTime|
dataTime op=Substract expressionResultData|
expressionResultData op=Substract dataTime|
expressionResultData op=Substract expressionResultData|

timeSpan op=(Add|Substract)timeSpan|
expressionResultTime op=(Add|Substract)timeSpan|
timeSpan op=(Add|Substract) expressionResultTime
expressionResultTime op=(Add|Substract)expressionResultTime;




expressionRoot : expressionResultData|expressionResultDataRightERT|expressionResultTime|dataTime|timeSpan;
