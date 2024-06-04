package projeto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Token {
    public final String type;
    public final String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("<%s, %s>", type, value);
    }
}

class Lexer {
    private static final String KEYWORDS = "\\b(int|float|string|if|else|switch|while|do|for|return)\\b";
    private static final String OPERATORS = "[+\\-*/<>!&|]{1,2}|==|=";
    private static final String DELIMITERS = "[;,.]";
    private static final String SPECIAL_CHARS = "[()\\[\\]{}]";
    private static final String IDENTIFIER = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
    private static final String INTEGER = "\\b\\d+\\b";
    private static final String REAL = "\\b\\d+\\.\\d+\\b";
    private static final String STRING = "\"(\\\\.|[^\\\\\"])*\"";
    private static final String COMMENT = "//.*|/\\*(.|\\n|\\r)*?\\*/";

    private final List<Token> tokens;
    private final String input;

    public Lexer(String input) {
        this.tokens = new ArrayList<>();
        this.input = input;
        tokenize();
    }

    private void tokenize() {
        String regex = String.format("(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)",
                COMMENT, KEYWORDS, OPERATORS, DELIMITERS, SPECIAL_CHARS, IDENTIFIER, INTEGER, REAL, STRING);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            if (match.matches(COMMENT)) {
                // Skip comments
                continue;
            } else if (match.matches(KEYWORDS)) {
                tokens.add(new Token("KEYWORD", match));
            } else if (match.matches(OPERATORS)) {
                tokens.add(new Token("OPERATOR", match));
            } else if (match.matches(DELIMITERS)) {
                tokens.add(new Token("DELIMITER", match));
            } else if (match.matches(SPECIAL_CHARS)) {
                tokens.add(new Token("SPECIAL_CHAR", match));
            } else if (match.matches(IDENTIFIER)) {
                tokens.add(new Token("IDENTIFIER", match));
            } else if (match.matches(INTEGER)) {
                tokens.add(new Token("INTEGER", match));
            } else if (match.matches(REAL)) {
                tokens.add(new Token("REAL", match));
            } else if (match.matches(STRING)) {
                tokens.add(new Token("STRING", match));
            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}

public class LexicalAnalyzer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java LexicalAnalyzer <source-file>");
            return;
        }

        String sourceFile = args[0];
        try {
            String content = new String(Files.readAllBytes(Paths.get(sourceFile)), StandardCharsets.UTF_8);
            Lexer lexer = new Lexer(content);

            System.out.println("Source Code:");
            System.out.println(content);
            System.out.println("\nTokens:");
            for (Token token : lexer.getTokens()) {
                System.out.println(token);
            }
        } catch (IOException e) {
            System.err.println("Error reading source file: " + e.getMessage());
        }
    }
}
