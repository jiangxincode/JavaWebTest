
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.objectweb.asm.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    private static final SimpleDateFormat _formatDate1 = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
    private static final SimpleDateFormat _formatDate2 = new SimpleDateFormat("dd.MM.yyyy|HH:mm:ss");
    private static final SimpleDateFormat _formatDate3 = new SimpleDateFormat("dd-MM-yyyy|HH:mm:ss");
    private static final SimpleDateFormat _formatTimeSpan = new SimpleDateFormat("HHHHHHH:mm:ss");

    static {
//        DecimalFormatSymbols _symbols = new DecimalFormatSymbols();
//        _symbols.setDecimalSeparator('.');
//        _symbols.setGroupingSeparator(Character.MIN_VALUE);
       // _format.applyPattern("dd/MM/yyyy|HH:mm:ss");
      //  _format.applyPattern("HHHHH:mm:ss");
    }
    public static boolean parseIsPossible(SimpleDateFormat format,String text){
        try {
            format.parse(text);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public static Long parseDate(String text) throws ParseException {
        if (parseIsPossible(_formatDate1,text)){
            return _formatDate1.parse(text).getTime();
        }
        if (parseIsPossible(_formatDate2,text)){
            return _formatDate2.parse(text).getTime();
        }
        if (parseIsPossible(_formatDate3,text)){
            return _formatDate3.parse(text).getTime();
        }
        return Long.valueOf(0);
    }

    public static Long parseTime(String text) throws ParseException {
        return _formatTimeSpan.parse(text).getTime();
    }

    public static void main(String[] args) {
        String input;
        out.println("Key in the input string:");
        try (Scanner reader = new Scanner(System.in)) {
            input = reader.nextLine();
        }

        CharStream charStream = new ANTLRInputStream(input);
        DateCalculatorLexer lexer = new DateCalculatorLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        DateCalculatorParser parser = new DateCalculatorParser(tokenStream);
        //parser.removeErrorListeners();
        parser.setBuildParseTree(true);
        ParseTree tree = parser.expressionRoot();
        int errors = parser.getNumberOfSyntaxErrors();

        out.println("Number of syntax errors: " + errors);
        out.println(tree.toStringTree(parser));
        List<String> roleNames = new LinkedList<>();
        for (String rolename:parser.getRuleNames()
             ) {roleNames.add(rolename);

        }
        TreeViewer treeViewer = new TreeViewer(roleNames,tree);
        treeViewer.open();

        if (0 == errors) {
            TreeEvaluationVisitor visitor = new TreeEvaluationVisitor();
            Long result = visitor.visit(tree);
            Date date = new Date(result);
            int indexStart =tree.toStringTree(parser).indexOf("(",2);
            int indexEnd =tree.toStringTree(parser).indexOf(" ",indexStart);
            String role = tree.toStringTree(parser).substring(indexStart+1,indexEnd);

            if(role.equals("expressionResultData")||role.equals("expressionResultDataRightERT")){
                SimpleDateFormat formatResult = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                out.println("Result = "+ formatResult.format(date));
            }else if(role.equals("expressionResultTime")){
                long days = TimeUnit.MILLISECONDS.toDays(result);
                SimpleDateFormat formatResult = new SimpleDateFormat("HH:mm:ss");
                out.println("Result = "+ days + " days and "+ formatResult.format(date));
            }



//            // Synteza
//            if (args.length > 0)
//                compile(tree, args[0]);
//            else
//                compile(tree);
        }
    }

//    private static void compile(ParseTree tree) {
//        compile(tree, "Grammar/out/CompilationClass.class");
//    }
//
//    private static void compile(ParseTree tree, String classPath) {
//        if (null == tree)
//            throw new NullPointerException("parse tree cannot be null.");
//
//        try {
//            Path path = Paths.get(classPath);
//            byte[] bytes = Files.readAllBytes(path);
//            ClassReader cr = new ClassReader(bytes);
//            //ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS); // no need to calculate visitMaxs(int maxStack, int maxLocals) arguments
//            ClassWriter cw = new ClassWriter(cr, 0);
//            cr.accept(new CompilationClassVisitor(cw, tree), 0);
//            bytes = cw.toByteArray();
//            Files.write(path, bytes);
//        } catch (IOException e) {
//            out.println("CompilationClass.class not found.");
//        }
//    }
}
