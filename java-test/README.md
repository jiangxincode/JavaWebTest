# DateCalculator

```bat
# 假设antlr-4.6-complete.jar和asm-5.2.jar在lib目录中，命令执行在工程根目录中

# 生成工具类Java源文件
java.exe -cp "..\lib\antlr-4.6-complete.jar" org.antlr.v4.Tool -o target\generated-sources\antlr4 -listener -visitor src\main\antlr4\DateCalculator.g4

# 生成工具类Class字节码文件
javac.exe -cp "..\lib\antlr-4.6-complete.jar;..\lib\asm-5.2.jar" -d %~dp0out target\generated-sources\antlr4\*.java

# 展示分词结果
java.exe -cp "out;..\lib\antlr-4.6-complete.jar" org.antlr.v4.gui.TestRig DateCalculator expression -tokens

# 展示语法树
java.exe -cp "out;..\lib\antlr-4.6-complete.jar" org.antlr.v4.gui.TestRig DateCalculator expressionRoot -tree -gui

# 
javap.exe -c -s -p -verbose -cp "out" CompilationClass > CompilationClass.bytecode

#
java -cp "..\lib\asm-5.2.jar;..\lib\asm-util-5.2.jar;out" org.objectweb.asm.util.ASMifier CompilationClass > CompilationClass.asm

#
java.exe -classpath "out;..\lib\antlr-4.6-complete.jar;..\lib\asm-5.2.jar" Main out\CompilationClass.class

#
javap.exe -c -s -p -verbose -cp "out" CompilationClass > CompilationClass.bytecode

#
java.exe -cp "out" CompilationClass

```

25/02/1992|10:30:25+2:30:25