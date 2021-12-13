// $ANTLR 3.5.2 smaliParser.g 2016-10-05 03:03:56

package org.jf.smali;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.jf.dexlib2.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


@SuppressWarnings("all")
public class smaliParser extends Parser {
    public static final String[] tokenNames = new String[]{
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACCESS_SPEC", "ANNOTATION_DIRECTIVE",
            "ANNOTATION_VISIBILITY", "ARRAY_DATA_DIRECTIVE", "ARRAY_TYPE_PREFIX",
            "ARROW", "BOOL_LITERAL", "BYTE_LITERAL", "CATCHALL_DIRECTIVE", "CATCH_DIRECTIVE",
            "CHAR_LITERAL", "CLASS_DESCRIPTOR", "CLASS_DIRECTIVE", "CLOSE_BRACE",
            "CLOSE_PAREN", "COLON", "COMMA", "DOTDOT", "DOUBLE_LITERAL", "DOUBLE_LITERAL_OR_ID",
            "END_ANNOTATION_DIRECTIVE", "END_ARRAY_DATA_DIRECTIVE", "END_FIELD_DIRECTIVE",
            "END_LOCAL_DIRECTIVE", "END_METHOD_DIRECTIVE", "END_PACKED_SWITCH_DIRECTIVE",
            "END_PARAMETER_DIRECTIVE", "END_SPARSE_SWITCH_DIRECTIVE", "END_SUBANNOTATION_DIRECTIVE",
            "ENUM_DIRECTIVE", "EPILOGUE_DIRECTIVE", "EQUAL", "FIELD_DIRECTIVE", "FIELD_OFFSET",
            "FLOAT_LITERAL", "FLOAT_LITERAL_OR_ID", "IMPLEMENTS_DIRECTIVE", "INLINE_INDEX",
            "INSTRUCTION_FORMAT10t", "INSTRUCTION_FORMAT10x", "INSTRUCTION_FORMAT10x_ODEX",
            "INSTRUCTION_FORMAT11n", "INSTRUCTION_FORMAT11x", "INSTRUCTION_FORMAT12x",
            "INSTRUCTION_FORMAT12x_OR_ID", "INSTRUCTION_FORMAT20bc", "INSTRUCTION_FORMAT20t",
            "INSTRUCTION_FORMAT21c_FIELD", "INSTRUCTION_FORMAT21c_FIELD_ODEX", "INSTRUCTION_FORMAT21c_STRING",
            "INSTRUCTION_FORMAT21c_TYPE", "INSTRUCTION_FORMAT21ih", "INSTRUCTION_FORMAT21lh",
            "INSTRUCTION_FORMAT21s", "INSTRUCTION_FORMAT21t", "INSTRUCTION_FORMAT22b",
            "INSTRUCTION_FORMAT22c_FIELD", "INSTRUCTION_FORMAT22c_FIELD_ODEX", "INSTRUCTION_FORMAT22c_TYPE",
            "INSTRUCTION_FORMAT22cs_FIELD", "INSTRUCTION_FORMAT22s", "INSTRUCTION_FORMAT22s_OR_ID",
            "INSTRUCTION_FORMAT22t", "INSTRUCTION_FORMAT22x", "INSTRUCTION_FORMAT23x",
            "INSTRUCTION_FORMAT30t", "INSTRUCTION_FORMAT31c", "INSTRUCTION_FORMAT31i",
            "INSTRUCTION_FORMAT31i_OR_ID", "INSTRUCTION_FORMAT31t", "INSTRUCTION_FORMAT32x",
            "INSTRUCTION_FORMAT35c_METHOD", "INSTRUCTION_FORMAT35c_METHOD_ODEX", "INSTRUCTION_FORMAT35c_TYPE",
            "INSTRUCTION_FORMAT35mi_METHOD", "INSTRUCTION_FORMAT35ms_METHOD", "INSTRUCTION_FORMAT3rc_METHOD",
            "INSTRUCTION_FORMAT3rc_METHOD_ODEX", "INSTRUCTION_FORMAT3rc_TYPE", "INSTRUCTION_FORMAT3rmi_METHOD",
            "INSTRUCTION_FORMAT3rms_METHOD", "INSTRUCTION_FORMAT45cc_METHOD", "INSTRUCTION_FORMAT4rcc_METHOD",
            "INSTRUCTION_FORMAT51l", "INTEGER_LITERAL", "INVALID_TOKEN", "I_ACCESS_LIST",
            "I_ANNOTATION", "I_ANNOTATIONS", "I_ANNOTATION_ELEMENT", "I_ARRAY_ELEMENTS",
            "I_ARRAY_ELEMENT_SIZE", "I_CATCH", "I_CATCHALL", "I_CATCHES", "I_CLASS_DEF",
            "I_ENCODED_ARRAY", "I_ENCODED_ENUM", "I_ENCODED_FIELD", "I_ENCODED_METHOD",
            "I_END_LOCAL", "I_EPILOGUE", "I_FIELD", "I_FIELDS", "I_FIELD_INITIAL_VALUE",
            "I_FIELD_TYPE", "I_IMPLEMENTS", "I_LABEL", "I_LINE", "I_LOCAL", "I_LOCALS",
            "I_METHOD", "I_METHODS", "I_METHOD_PROTOTYPE", "I_METHOD_RETURN_TYPE",
            "I_ORDERED_METHOD_ITEMS", "I_PACKED_SWITCH_ELEMENTS", "I_PACKED_SWITCH_START_KEY",
            "I_PARAMETER", "I_PARAMETERS", "I_PARAMETER_NOT_SPECIFIED", "I_PROLOGUE",
            "I_REGISTERS", "I_REGISTER_LIST", "I_REGISTER_RANGE", "I_RESTART_LOCAL",
            "I_SOURCE", "I_SPARSE_SWITCH_ELEMENTS", "I_STATEMENT_ARRAY_DATA", "I_STATEMENT_FORMAT10t",
            "I_STATEMENT_FORMAT10x", "I_STATEMENT_FORMAT11n", "I_STATEMENT_FORMAT11x",
            "I_STATEMENT_FORMAT12x", "I_STATEMENT_FORMAT20bc", "I_STATEMENT_FORMAT20t",
            "I_STATEMENT_FORMAT21c_FIELD", "I_STATEMENT_FORMAT21c_STRING", "I_STATEMENT_FORMAT21c_TYPE",
            "I_STATEMENT_FORMAT21ih", "I_STATEMENT_FORMAT21lh", "I_STATEMENT_FORMAT21s",
            "I_STATEMENT_FORMAT21t", "I_STATEMENT_FORMAT22b", "I_STATEMENT_FORMAT22c_FIELD",
            "I_STATEMENT_FORMAT22c_TYPE", "I_STATEMENT_FORMAT22s", "I_STATEMENT_FORMAT22t",
            "I_STATEMENT_FORMAT22x", "I_STATEMENT_FORMAT23x", "I_STATEMENT_FORMAT30t",
            "I_STATEMENT_FORMAT31c", "I_STATEMENT_FORMAT31i", "I_STATEMENT_FORMAT31t",
            "I_STATEMENT_FORMAT32x", "I_STATEMENT_FORMAT35c_METHOD", "I_STATEMENT_FORMAT35c_TYPE",
            "I_STATEMENT_FORMAT3rc_METHOD", "I_STATEMENT_FORMAT3rc_TYPE", "I_STATEMENT_FORMAT45cc_METHOD",
            "I_STATEMENT_FORMAT4rcc_METHOD", "I_STATEMENT_FORMAT51l", "I_STATEMENT_PACKED_SWITCH",
            "I_STATEMENT_SPARSE_SWITCH", "I_SUBANNOTATION", "I_SUPER", "LINE_COMMENT",
            "LINE_DIRECTIVE", "LOCALS_DIRECTIVE", "LOCAL_DIRECTIVE", "LONG_LITERAL",
            "MEMBER_NAME", "METHOD_DIRECTIVE", "NEGATIVE_INTEGER_LITERAL", "NULL_LITERAL",
            "OPEN_BRACE", "OPEN_PAREN", "PACKED_SWITCH_DIRECTIVE", "PARAMETER_DIRECTIVE",
            "PARAM_LIST_OR_ID_PRIMITIVE_TYPE", "POSITIVE_INTEGER_LITERAL", "PRIMITIVE_TYPE",
            "PROLOGUE_DIRECTIVE", "REGISTER", "REGISTERS_DIRECTIVE", "RESTART_LOCAL_DIRECTIVE",
            "SHORT_LITERAL", "SIMPLE_NAME", "SOURCE_DIRECTIVE", "SPARSE_SWITCH_DIRECTIVE",
            "STRING_LITERAL", "SUBANNOTATION_DIRECTIVE", "SUPER_DIRECTIVE", "VERIFICATION_ERROR_TYPE",
            "VOID_TYPE", "VTABLE_INDEX", "WHITE_SPACE"
    };
    public static final int EOF = -1;
    public static final int ACCESS_SPEC = 4;
    public static final int ANNOTATION_DIRECTIVE = 5;
    public static final int ANNOTATION_VISIBILITY = 6;
    public static final int ARRAY_DATA_DIRECTIVE = 7;
    public static final int ARRAY_TYPE_PREFIX = 8;
    public static final int ARROW = 9;
    public static final int BOOL_LITERAL = 10;
    public static final int BYTE_LITERAL = 11;
    public static final int CATCHALL_DIRECTIVE = 12;
    public static final int CATCH_DIRECTIVE = 13;
    public static final int CHAR_LITERAL = 14;
    public static final int CLASS_DESCRIPTOR = 15;
    public static final int CLASS_DIRECTIVE = 16;
    public static final int CLOSE_BRACE = 17;
    public static final int CLOSE_PAREN = 18;
    public static final int COLON = 19;
    public static final int COMMA = 20;
    public static final int DOTDOT = 21;
    public static final int DOUBLE_LITERAL = 22;
    public static final int DOUBLE_LITERAL_OR_ID = 23;
    public static final int END_ANNOTATION_DIRECTIVE = 24;
    public static final int END_ARRAY_DATA_DIRECTIVE = 25;
    public static final int END_FIELD_DIRECTIVE = 26;
    public static final int END_LOCAL_DIRECTIVE = 27;
    public static final int END_METHOD_DIRECTIVE = 28;
    public static final int END_PACKED_SWITCH_DIRECTIVE = 29;
    public static final int END_PARAMETER_DIRECTIVE = 30;
    public static final int END_SPARSE_SWITCH_DIRECTIVE = 31;
    public static final int END_SUBANNOTATION_DIRECTIVE = 32;
    public static final int ENUM_DIRECTIVE = 33;
    public static final int EPILOGUE_DIRECTIVE = 34;
    public static final int EQUAL = 35;
    public static final int FIELD_DIRECTIVE = 36;
    public static final int FIELD_OFFSET = 37;
    public static final int FLOAT_LITERAL = 38;
    public static final int FLOAT_LITERAL_OR_ID = 39;
    public static final int IMPLEMENTS_DIRECTIVE = 40;
    public static final int INLINE_INDEX = 41;
    public static final int INSTRUCTION_FORMAT10t = 42;
    public static final int INSTRUCTION_FORMAT10x = 43;
    public static final int INSTRUCTION_FORMAT10x_ODEX = 44;
    public static final int INSTRUCTION_FORMAT11n = 45;
    public static final int INSTRUCTION_FORMAT11x = 46;
    public static final int INSTRUCTION_FORMAT12x = 47;
    public static final int INSTRUCTION_FORMAT12x_OR_ID = 48;
    public static final int INSTRUCTION_FORMAT20bc = 49;
    public static final int INSTRUCTION_FORMAT20t = 50;
    public static final int INSTRUCTION_FORMAT21c_FIELD = 51;
    public static final int INSTRUCTION_FORMAT21c_FIELD_ODEX = 52;
    public static final int INSTRUCTION_FORMAT21c_STRING = 53;
    public static final int INSTRUCTION_FORMAT21c_TYPE = 54;
    public static final int INSTRUCTION_FORMAT21ih = 55;
    public static final int INSTRUCTION_FORMAT21lh = 56;
    public static final int INSTRUCTION_FORMAT21s = 57;
    public static final int INSTRUCTION_FORMAT21t = 58;
    public static final int INSTRUCTION_FORMAT22b = 59;
    public static final int INSTRUCTION_FORMAT22c_FIELD = 60;
    public static final int INSTRUCTION_FORMAT22c_FIELD_ODEX = 61;
    public static final int INSTRUCTION_FORMAT22c_TYPE = 62;
    public static final int INSTRUCTION_FORMAT22cs_FIELD = 63;
    public static final int INSTRUCTION_FORMAT22s = 64;
    public static final int INSTRUCTION_FORMAT22s_OR_ID = 65;
    public static final int INSTRUCTION_FORMAT22t = 66;
    public static final int INSTRUCTION_FORMAT22x = 67;
    public static final int INSTRUCTION_FORMAT23x = 68;
    public static final int INSTRUCTION_FORMAT30t = 69;
    public static final int INSTRUCTION_FORMAT31c = 70;
    public static final int INSTRUCTION_FORMAT31i = 71;
    public static final int INSTRUCTION_FORMAT31i_OR_ID = 72;
    public static final int INSTRUCTION_FORMAT31t = 73;
    public static final int INSTRUCTION_FORMAT32x = 74;
    public static final int INSTRUCTION_FORMAT35c_METHOD = 75;
    public static final int INSTRUCTION_FORMAT35c_METHOD_ODEX = 76;
    public static final int INSTRUCTION_FORMAT35c_TYPE = 77;
    public static final int INSTRUCTION_FORMAT35mi_METHOD = 78;
    public static final int INSTRUCTION_FORMAT35ms_METHOD = 79;
    public static final int INSTRUCTION_FORMAT3rc_METHOD = 80;
    public static final int INSTRUCTION_FORMAT3rc_METHOD_ODEX = 81;
    public static final int INSTRUCTION_FORMAT3rc_TYPE = 82;
    public static final int INSTRUCTION_FORMAT3rmi_METHOD = 83;
    public static final int INSTRUCTION_FORMAT3rms_METHOD = 84;
    public static final int INSTRUCTION_FORMAT45cc_METHOD = 85;
    public static final int INSTRUCTION_FORMAT4rcc_METHOD = 86;
    public static final int INSTRUCTION_FORMAT51l = 87;
    public static final int INTEGER_LITERAL = 88;
    public static final int INVALID_TOKEN = 89;
    public static final int I_ACCESS_LIST = 90;
    public static final int I_ANNOTATION = 91;
    public static final int I_ANNOTATIONS = 92;
    public static final int I_ANNOTATION_ELEMENT = 93;
    public static final int I_ARRAY_ELEMENTS = 94;
    public static final int I_ARRAY_ELEMENT_SIZE = 95;
    public static final int I_CATCH = 96;
    public static final int I_CATCHALL = 97;
    public static final int I_CATCHES = 98;
    public static final int I_CLASS_DEF = 99;
    public static final int I_ENCODED_ARRAY = 100;
    public static final int I_ENCODED_ENUM = 101;
    public static final int I_ENCODED_FIELD = 102;
    public static final int I_ENCODED_METHOD = 103;
    public static final int I_END_LOCAL = 104;
    public static final int I_EPILOGUE = 105;
    public static final int I_FIELD = 106;
    public static final int I_FIELDS = 107;
    public static final int I_FIELD_INITIAL_VALUE = 108;
    public static final int I_FIELD_TYPE = 109;
    public static final int I_IMPLEMENTS = 110;
    public static final int I_LABEL = 111;
    public static final int I_LINE = 112;
    public static final int I_LOCAL = 113;
    public static final int I_LOCALS = 114;
    public static final int I_METHOD = 115;
    public static final int I_METHODS = 116;
    public static final int I_METHOD_PROTOTYPE = 117;
    public static final int I_METHOD_RETURN_TYPE = 118;
    public static final int I_ORDERED_METHOD_ITEMS = 119;
    public static final int I_PACKED_SWITCH_ELEMENTS = 120;
    public static final int I_PACKED_SWITCH_START_KEY = 121;
    public static final int I_PARAMETER = 122;
    public static final int I_PARAMETERS = 123;
    public static final int I_PARAMETER_NOT_SPECIFIED = 124;
    public static final int I_PROLOGUE = 125;
    public static final int I_REGISTERS = 126;
    public static final int I_REGISTER_LIST = 127;
    public static final int I_REGISTER_RANGE = 128;
    public static final int I_RESTART_LOCAL = 129;
    public static final int I_SOURCE = 130;
    public static final int I_SPARSE_SWITCH_ELEMENTS = 131;
    public static final int I_STATEMENT_ARRAY_DATA = 132;
    public static final int I_STATEMENT_FORMAT10t = 133;
    public static final int I_STATEMENT_FORMAT10x = 134;
    public static final int I_STATEMENT_FORMAT11n = 135;
    public static final int I_STATEMENT_FORMAT11x = 136;
    public static final int I_STATEMENT_FORMAT12x = 137;
    public static final int I_STATEMENT_FORMAT20bc = 138;
    public static final int I_STATEMENT_FORMAT20t = 139;
    public static final int I_STATEMENT_FORMAT21c_FIELD = 140;
    public static final int I_STATEMENT_FORMAT21c_STRING = 141;
    public static final int I_STATEMENT_FORMAT21c_TYPE = 142;
    public static final int I_STATEMENT_FORMAT21ih = 143;
    public static final int I_STATEMENT_FORMAT21lh = 144;
    public static final int I_STATEMENT_FORMAT21s = 145;
    public static final int I_STATEMENT_FORMAT21t = 146;
    public static final int I_STATEMENT_FORMAT22b = 147;
    public static final int I_STATEMENT_FORMAT22c_FIELD = 148;
    public static final int I_STATEMENT_FORMAT22c_TYPE = 149;
    public static final int I_STATEMENT_FORMAT22s = 150;
    public static final int I_STATEMENT_FORMAT22t = 151;
    public static final int I_STATEMENT_FORMAT22x = 152;
    public static final int I_STATEMENT_FORMAT23x = 153;
    public static final int I_STATEMENT_FORMAT30t = 154;
    public static final int I_STATEMENT_FORMAT31c = 155;
    public static final int I_STATEMENT_FORMAT31i = 156;
    public static final int I_STATEMENT_FORMAT31t = 157;
    public static final int I_STATEMENT_FORMAT32x = 158;
    public static final int I_STATEMENT_FORMAT35c_METHOD = 159;
    public static final int I_STATEMENT_FORMAT35c_TYPE = 160;
    public static final int I_STATEMENT_FORMAT3rc_METHOD = 161;
    public static final int I_STATEMENT_FORMAT3rc_TYPE = 162;
    public static final int I_STATEMENT_FORMAT45cc_METHOD = 163;
    public static final int I_STATEMENT_FORMAT4rcc_METHOD = 164;
    public static final int I_STATEMENT_FORMAT51l = 165;
    public static final int I_STATEMENT_PACKED_SWITCH = 166;
    public static final int I_STATEMENT_SPARSE_SWITCH = 167;
    public static final int I_SUBANNOTATION = 168;
    public static final int I_SUPER = 169;
    public static final int LINE_COMMENT = 170;
    public static final int LINE_DIRECTIVE = 171;
    public static final int LOCALS_DIRECTIVE = 172;
    public static final int LOCAL_DIRECTIVE = 173;
    public static final int LONG_LITERAL = 174;
    public static final int MEMBER_NAME = 175;
    public static final int METHOD_DIRECTIVE = 176;
    public static final int NEGATIVE_INTEGER_LITERAL = 177;
    public static final int NULL_LITERAL = 178;
    public static final int OPEN_BRACE = 179;
    public static final int OPEN_PAREN = 180;
    public static final int PACKED_SWITCH_DIRECTIVE = 181;
    public static final int PARAMETER_DIRECTIVE = 182;
    public static final int PARAM_LIST_OR_ID_PRIMITIVE_TYPE = 183;
    public static final int POSITIVE_INTEGER_LITERAL = 184;
    public static final int PRIMITIVE_TYPE = 185;
    public static final int PROLOGUE_DIRECTIVE = 186;
    public static final int REGISTER = 187;
    public static final int REGISTERS_DIRECTIVE = 188;
    public static final int RESTART_LOCAL_DIRECTIVE = 189;
    public static final int SHORT_LITERAL = 190;
    public static final int SIMPLE_NAME = 191;
    public static final int SOURCE_DIRECTIVE = 192;
    public static final int SPARSE_SWITCH_DIRECTIVE = 193;
    public static final int STRING_LITERAL = 194;
    public static final int SUBANNOTATION_DIRECTIVE = 195;
    public static final int SUPER_DIRECTIVE = 196;
    public static final int VERIFICATION_ERROR_TYPE = 197;
    public static final int VOID_TYPE = 198;
    public static final int VTABLE_INDEX = 199;
    public static final int WHITE_SPACE = 200;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[]{};
    }

    // delegators


    public smaliParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public smaliParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    @Override
    public String[] getTokenNames() {
        return smaliParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "smaliParser.g";
    }


    public static final int ERROR_CHANNEL = 100;

    private boolean verboseErrors = false;
    private boolean allowOdex = false;
    private int apiLevel = 15;
    private Opcodes opcodes = Opcodes.forApi(apiLevel);

    public void setVerboseErrors(boolean verboseErrors) {
        this.verboseErrors = verboseErrors;
    }

    public void setAllowOdex(boolean allowOdex) {
        this.allowOdex = allowOdex;
    }

    public void setApiLevel(int apiLevel) {
        this.opcodes = Opcodes.forApi(apiLevel);
        this.apiLevel = apiLevel;
    }

    public String getErrorMessage(RecognitionException e,
                                  String[] tokenNames) {

        if (verboseErrors) {
            List stack = getRuleInvocationStack(e, this.getClass().getName());
            String msg = null;

            if (e instanceof NoViableAltException) {
                NoViableAltException nvae = (NoViableAltException) e;
                msg = " no viable alt; token=" + getTokenErrorDisplay(e.token) +
                        " (decision=" + nvae.decisionNumber +
                        " state " + nvae.stateNumber + ")" +
                        " decision=<<" + nvae.grammarDecisionDescription + ">>";
            } else {
                msg = super.getErrorMessage(e, tokenNames);
            }

            return stack + " " + msg;
        } else {
            return super.getErrorMessage(e, tokenNames);
        }
    }

    public String getTokenErrorDisplay(Token t) {
        if (!verboseErrors) {
            String s = t.getText();
            if (s == null) {
                if (t.getType() == Token.EOF) {
                    s = "<EOF>";
                } else {
                    s = "<" + tokenNames[t.getType()] + ">";
                }
            }
            s = s.replaceAll("\n", "\\\\n");
            s = s.replaceAll("\r", "\\\\r");
            s = s.replaceAll("\t", "\\\\t");
            return "'" + s + "'";
        }

        CommonToken ct = (CommonToken) t;

        String channelStr = "";
        if (t.getChannel() > 0) {
            channelStr = ",channel=" + t.getChannel();
        }
        String txt = t.getText();
        if (txt != null) {
            txt = txt.replaceAll("\n", "\\\\n");
            txt = txt.replaceAll("\r", "\\\\r");
            txt = txt.replaceAll("\t", "\\\\t");
        } else {
            txt = "<no text>";
        }
        return "[@" + t.getTokenIndex() + "," + ct.getStartIndex() + ":" + ct.getStopIndex() + "='" + txt + "',<" + tokenNames[t.getType()] + ">" + channelStr + "," + t.getLine() + ":" + t.getCharPositionInLine() + "]";
    }

    public String getErrorHeader(RecognitionException e) {
        return getSourceName() + "[" + e.line + "," + e.charPositionInLine + "]";
    }

    private CommonTree buildTree(int type, String text, List<CommonTree> children) {
        CommonTree root = new CommonTree(new CommonToken(type, text));
        for (CommonTree child : children) {
            root.addChild(child);
        }
        return root;
    }

    private CommonToken getParamListSubToken(CommonToken baseToken, String str, int typeStartIndex) {
        CommonToken token = new CommonToken(baseToken);
        token.setStartIndex(baseToken.getStartIndex() + typeStartIndex);

        switch (str.charAt(typeStartIndex)) {
            case 'Z':
            case 'B':
            case 'S':
            case 'C':
            case 'I':
            case 'J':
            case 'F':
            case 'D': {
                token.setType(PRIMITIVE_TYPE);
                token.setText(str.substring(typeStartIndex, typeStartIndex + 1));
                token.setStopIndex(baseToken.getStartIndex() + typeStartIndex);
                break;
            }
            case 'L': {
                int i = typeStartIndex;
                while (str.charAt(++i) != ';') ;

                token.setType(CLASS_DESCRIPTOR);
                token.setText(str.substring(typeStartIndex, i + 1));
                token.setStopIndex(baseToken.getStartIndex() + i);
                break;
            }
            case '[': {
                int i = typeStartIndex;
                while (str.charAt(++i) == '[') ;

                token.setType(ARRAY_TYPE_PREFIX);
                token.setText(str.substring(typeStartIndex, i));
                token.setStopIndex(baseToken.getStartIndex() + i - 1);
                break;
            }
            default:
                throw new RuntimeException(String.format("Invalid character '%c' in param list \"%s\" at position %d", str.charAt(typeStartIndex), str, typeStartIndex));
        }

        return token;
    }

    private CommonTree parseParamList(CommonToken paramListToken) {
        String paramList = paramListToken.getText();
        CommonTree root = new CommonTree();

        int startIndex = paramListToken.getStartIndex();

        int i = 0;
        while (i < paramList.length()) {
            CommonToken token = getParamListSubToken(paramListToken, paramList, i);
            root.addChild(new CommonTree(token));
            i += token.getText().length();
        }

        if (root.getChildCount() == 0) {
            return null;
        }
        return root;
    }

    private void throwOdexedInstructionException(IntStream input, String odexedInstruction)
            throws OdexedInstructionException {
        /*this has to be done in a separate method, otherwise java will complain about the
	    auto-generated code in the rule after the throw not being reachable*/
        throw new OdexedInstructionException(input, odexedInstruction);
    }


    protected static class smali_file_scope {
        boolean hasClassSpec;
        boolean hasSuperSpec;
        boolean hasSourceSpec;
        List<CommonTree> classAnnotations;
    }

    protected Stack<smali_file_scope> smali_file_stack = new Stack<smali_file_scope>();

    public static class smali_file_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "smali_file"
    // smaliParser.g:415:1: smali_file : ({...}? => class_spec |{...}? => super_spec | implements_spec |{...}? => source_spec | method | field | annotation )+ EOF -> ^( I_CLASS_DEF class_spec ( super_spec )? ( implements_spec )* ( source_spec )? ^( I_METHODS ( method )* ) ^( I_FIELDS ( field )* ) ) ;
    public final smaliParser.smali_file_return smali_file() throws RecognitionException {
        smali_file_stack.push(new smali_file_scope());
        smaliParser.smali_file_return retval = new smaliParser.smali_file_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF8 = null;
        ParserRuleReturnScope class_spec1 = null;
        ParserRuleReturnScope super_spec2 = null;
        ParserRuleReturnScope implements_spec3 = null;
        ParserRuleReturnScope source_spec4 = null;
        ParserRuleReturnScope method5 = null;
        ParserRuleReturnScope field6 = null;
        ParserRuleReturnScope annotation7 = null;

        CommonTree EOF8_tree = null;
        RewriteRuleTokenStream stream_EOF = new RewriteRuleTokenStream(adaptor, "token EOF");
        RewriteRuleSubtreeStream stream_class_spec = new RewriteRuleSubtreeStream(adaptor, "rule class_spec");
        RewriteRuleSubtreeStream stream_annotation = new RewriteRuleSubtreeStream(adaptor, "rule annotation");
        RewriteRuleSubtreeStream stream_method = new RewriteRuleSubtreeStream(adaptor, "rule method");
        RewriteRuleSubtreeStream stream_field = new RewriteRuleSubtreeStream(adaptor, "rule field");
        RewriteRuleSubtreeStream stream_super_spec = new RewriteRuleSubtreeStream(adaptor, "rule super_spec");
        RewriteRuleSubtreeStream stream_implements_spec = new RewriteRuleSubtreeStream(adaptor, "rule implements_spec");
        RewriteRuleSubtreeStream stream_source_spec = new RewriteRuleSubtreeStream(adaptor, "rule source_spec");

        smali_file_stack.peek().hasClassSpec = smali_file_stack.peek().hasSuperSpec = smali_file_stack.peek().hasSourceSpec = false;
        smali_file_stack.peek().classAnnotations = new ArrayList<CommonTree>();

        try {
            // smaliParser.g:427:3: ( ({...}? => class_spec |{...}? => super_spec | implements_spec |{...}? => source_spec | method | field | annotation )+ EOF -> ^( I_CLASS_DEF class_spec ( super_spec )? ( implements_spec )* ( source_spec )? ^( I_METHODS ( method )* ) ^( I_FIELDS ( field )* ) ) )
            // smaliParser.g:428:3: ({...}? => class_spec |{...}? => super_spec | implements_spec |{...}? => source_spec | method | field | annotation )+ EOF
            {
                // smaliParser.g:428:3: ({...}? => class_spec |{...}? => super_spec | implements_spec |{...}? => source_spec | method | field | annotation )+
                int cnt1 = 0;
                loop1:
                while (true) {
                    int alt1 = 8;
                    int LA1_0 = input.LA(1);
                    if ((LA1_0 == CLASS_DIRECTIVE) && ((!smali_file_stack.peek().hasClassSpec))) {
                        alt1 = 1;
                    } else if ((LA1_0 == SUPER_DIRECTIVE) && ((!smali_file_stack.peek().hasSuperSpec))) {
                        alt1 = 2;
                    } else if ((LA1_0 == IMPLEMENTS_DIRECTIVE)) {
                        alt1 = 3;
                    } else if ((LA1_0 == SOURCE_DIRECTIVE) && ((!smali_file_stack.peek().hasSourceSpec))) {
                        alt1 = 4;
                    } else if ((LA1_0 == METHOD_DIRECTIVE)) {
                        alt1 = 5;
                    } else if ((LA1_0 == FIELD_DIRECTIVE)) {
                        alt1 = 6;
                    } else if ((LA1_0 == ANNOTATION_DIRECTIVE)) {
                        alt1 = 7;
                    }

                    switch (alt1) {
                        case 1:
                            // smaliParser.g:428:5: {...}? => class_spec
                        {
                            if (!((!smali_file_stack.peek().hasClassSpec))) {
                                throw new FailedPredicateException(input, "smali_file", "!$smali_file::hasClassSpec");
                            }
                            pushFollow(FOLLOW_class_spec_in_smali_file1075);
                            class_spec1 = class_spec();
                            state._fsp--;

                            stream_class_spec.add(class_spec1.getTree());
                            smali_file_stack.peek().hasClassSpec = true;
                        }
                        break;
                        case 2:
                            // smaliParser.g:429:5: {...}? => super_spec
                        {
                            if (!((!smali_file_stack.peek().hasSuperSpec))) {
                                throw new FailedPredicateException(input, "smali_file", "!$smali_file::hasSuperSpec");
                            }
                            pushFollow(FOLLOW_super_spec_in_smali_file1086);
                            super_spec2 = super_spec();
                            state._fsp--;

                            stream_super_spec.add(super_spec2.getTree());
                            smali_file_stack.peek().hasSuperSpec = true;
                        }
                        break;
                        case 3:
                            // smaliParser.g:430:5: implements_spec
                        {
                            pushFollow(FOLLOW_implements_spec_in_smali_file1094);
                            implements_spec3 = implements_spec();
                            state._fsp--;

                            stream_implements_spec.add(implements_spec3.getTree());
                        }
                        break;
                        case 4:
                            // smaliParser.g:431:5: {...}? => source_spec
                        {
                            if (!((!smali_file_stack.peek().hasSourceSpec))) {
                                throw new FailedPredicateException(input, "smali_file", "!$smali_file::hasSourceSpec");
                            }
                            pushFollow(FOLLOW_source_spec_in_smali_file1103);
                            source_spec4 = source_spec();
                            state._fsp--;

                            stream_source_spec.add(source_spec4.getTree());
                            smali_file_stack.peek().hasSourceSpec = true;
                        }
                        break;
                        case 5:
                            // smaliParser.g:432:5: method
                        {
                            pushFollow(FOLLOW_method_in_smali_file1111);
                            method5 = method();
                            state._fsp--;

                            stream_method.add(method5.getTree());
                        }
                        break;
                        case 6:
                            // smaliParser.g:433:5: field
                        {
                            pushFollow(FOLLOW_field_in_smali_file1117);
                            field6 = field();
                            state._fsp--;

                            stream_field.add(field6.getTree());
                        }
                        break;
                        case 7:
                            // smaliParser.g:434:5: annotation
                        {
                            pushFollow(FOLLOW_annotation_in_smali_file1123);
                            annotation7 = annotation();
                            state._fsp--;

                            stream_annotation.add(annotation7.getTree());
                            smali_file_stack.peek().classAnnotations.add((annotation7 != null ? ((CommonTree) annotation7.getTree()) : null));
                        }
                        break;

                        default:
                            if (cnt1 >= 1) break loop1;
                            EarlyExitException eee = new EarlyExitException(1, input);
                            throw eee;
                    }
                    cnt1++;
                }

                EOF8 = (Token) match(input, EOF, FOLLOW_EOF_in_smali_file1134);
                stream_EOF.add(EOF8);


                if (!smali_file_stack.peek().hasClassSpec) {
                    throw new SemanticException(input, "The file must contain a .class directive");
                }

                if (!smali_file_stack.peek().hasSuperSpec) {
                    if (!(class_spec1 != null ? ((smaliParser.class_spec_return) class_spec1).className : null).equals("Ljava/lang/Object;")) {
                        throw new SemanticException(input, "The file must contain a .super directive");
                    }
                }

                // AST REWRITE
                // elements: implements_spec, class_spec, source_spec, super_spec, field, method
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 448:3: -> ^( I_CLASS_DEF class_spec ( super_spec )? ( implements_spec )* ( source_spec )? ^( I_METHODS ( method )* ) ^( I_FIELDS ( field )* ) )
                {
                    // smaliParser.g:448:6: ^( I_CLASS_DEF class_spec ( super_spec )? ( implements_spec )* ( source_spec )? ^( I_METHODS ( method )* ) ^( I_FIELDS ( field )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_CLASS_DEF, "I_CLASS_DEF"), root_1);
                        adaptor.addChild(root_1, stream_class_spec.nextTree());
                        // smaliParser.g:450:8: ( super_spec )?
                        if (stream_super_spec.hasNext()) {
                            adaptor.addChild(root_1, stream_super_spec.nextTree());
                        }
                        stream_super_spec.reset();

                        // smaliParser.g:451:8: ( implements_spec )*
                        while (stream_implements_spec.hasNext()) {
                            adaptor.addChild(root_1, stream_implements_spec.nextTree());
                        }
                        stream_implements_spec.reset();

                        // smaliParser.g:452:8: ( source_spec )?
                        if (stream_source_spec.hasNext()) {
                            adaptor.addChild(root_1, stream_source_spec.nextTree());
                        }
                        stream_source_spec.reset();

                        // smaliParser.g:453:8: ^( I_METHODS ( method )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_METHODS, "I_METHODS"), root_2);
                            // smaliParser.g:453:20: ( method )*
                            while (stream_method.hasNext()) {
                                adaptor.addChild(root_2, stream_method.nextTree());
                            }
                            stream_method.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        // smaliParser.g:453:29: ^( I_FIELDS ( field )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELDS, "I_FIELDS"), root_2);
                            // smaliParser.g:453:40: ( field )*
                            while (stream_field.hasNext()) {
                                adaptor.addChild(root_2, stream_field.nextTree());
                            }
                            stream_field.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, buildTree(I_ANNOTATIONS, "I_ANNOTATIONS", smali_file_stack.peek().classAnnotations));
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
            smali_file_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "smali_file"


    public static class class_spec_return extends ParserRuleReturnScope {
        public String className;
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "class_spec"
    // smaliParser.g:455:1: class_spec returns [String className] : CLASS_DIRECTIVE access_list CLASS_DESCRIPTOR -> CLASS_DESCRIPTOR access_list ;
    public final smaliParser.class_spec_return class_spec() throws RecognitionException {
        smaliParser.class_spec_return retval = new smaliParser.class_spec_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CLASS_DIRECTIVE9 = null;
        Token CLASS_DESCRIPTOR11 = null;
        ParserRuleReturnScope access_list10 = null;

        CommonTree CLASS_DIRECTIVE9_tree = null;
        CommonTree CLASS_DESCRIPTOR11_tree = null;
        RewriteRuleTokenStream stream_CLASS_DESCRIPTOR = new RewriteRuleTokenStream(adaptor, "token CLASS_DESCRIPTOR");
        RewriteRuleTokenStream stream_CLASS_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token CLASS_DIRECTIVE");
        RewriteRuleSubtreeStream stream_access_list = new RewriteRuleSubtreeStream(adaptor, "rule access_list");

        try {
            // smaliParser.g:456:3: ( CLASS_DIRECTIVE access_list CLASS_DESCRIPTOR -> CLASS_DESCRIPTOR access_list )
            // smaliParser.g:456:5: CLASS_DIRECTIVE access_list CLASS_DESCRIPTOR
            {
                CLASS_DIRECTIVE9 = (Token) match(input, CLASS_DIRECTIVE, FOLLOW_CLASS_DIRECTIVE_in_class_spec1221);
                stream_CLASS_DIRECTIVE.add(CLASS_DIRECTIVE9);

                pushFollow(FOLLOW_access_list_in_class_spec1223);
                access_list10 = access_list();
                state._fsp--;

                stream_access_list.add(access_list10.getTree());
                CLASS_DESCRIPTOR11 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_class_spec1225);
                stream_CLASS_DESCRIPTOR.add(CLASS_DESCRIPTOR11);

                retval.className = (CLASS_DESCRIPTOR11 != null ? CLASS_DESCRIPTOR11.getText() : null);
                // AST REWRITE
                // elements: access_list, CLASS_DESCRIPTOR
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 456:89: -> CLASS_DESCRIPTOR access_list
                {
                    adaptor.addChild(root_0, stream_CLASS_DESCRIPTOR.nextNode());
                    adaptor.addChild(root_0, stream_access_list.nextTree());
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "class_spec"


    public static class super_spec_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "super_spec"
    // smaliParser.g:458:1: super_spec : SUPER_DIRECTIVE CLASS_DESCRIPTOR -> ^( I_SUPER[$start, \"I_SUPER\"] CLASS_DESCRIPTOR ) ;
    public final smaliParser.super_spec_return super_spec() throws RecognitionException {
        smaliParser.super_spec_return retval = new smaliParser.super_spec_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUPER_DIRECTIVE12 = null;
        Token CLASS_DESCRIPTOR13 = null;

        CommonTree SUPER_DIRECTIVE12_tree = null;
        CommonTree CLASS_DESCRIPTOR13_tree = null;
        RewriteRuleTokenStream stream_CLASS_DESCRIPTOR = new RewriteRuleTokenStream(adaptor, "token CLASS_DESCRIPTOR");
        RewriteRuleTokenStream stream_SUPER_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token SUPER_DIRECTIVE");

        try {
            // smaliParser.g:459:3: ( SUPER_DIRECTIVE CLASS_DESCRIPTOR -> ^( I_SUPER[$start, \"I_SUPER\"] CLASS_DESCRIPTOR ) )
            // smaliParser.g:459:5: SUPER_DIRECTIVE CLASS_DESCRIPTOR
            {
                SUPER_DIRECTIVE12 = (Token) match(input, SUPER_DIRECTIVE, FOLLOW_SUPER_DIRECTIVE_in_super_spec1243);
                stream_SUPER_DIRECTIVE.add(SUPER_DIRECTIVE12);

                CLASS_DESCRIPTOR13 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_super_spec1245);
                stream_CLASS_DESCRIPTOR.add(CLASS_DESCRIPTOR13);

                // AST REWRITE
                // elements: CLASS_DESCRIPTOR
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 459:38: -> ^( I_SUPER[$start, \"I_SUPER\"] CLASS_DESCRIPTOR )
                {
                    // smaliParser.g:459:41: ^( I_SUPER[$start, \"I_SUPER\"] CLASS_DESCRIPTOR )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SUPER, (retval.start), "I_SUPER"), root_1);
                        adaptor.addChild(root_1, stream_CLASS_DESCRIPTOR.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "super_spec"


    public static class implements_spec_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "implements_spec"
    // smaliParser.g:461:1: implements_spec : IMPLEMENTS_DIRECTIVE CLASS_DESCRIPTOR -> ^( I_IMPLEMENTS[$start, \"I_IMPLEMENTS\"] CLASS_DESCRIPTOR ) ;
    public final smaliParser.implements_spec_return implements_spec() throws RecognitionException {
        smaliParser.implements_spec_return retval = new smaliParser.implements_spec_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IMPLEMENTS_DIRECTIVE14 = null;
        Token CLASS_DESCRIPTOR15 = null;

        CommonTree IMPLEMENTS_DIRECTIVE14_tree = null;
        CommonTree CLASS_DESCRIPTOR15_tree = null;
        RewriteRuleTokenStream stream_IMPLEMENTS_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token IMPLEMENTS_DIRECTIVE");
        RewriteRuleTokenStream stream_CLASS_DESCRIPTOR = new RewriteRuleTokenStream(adaptor, "token CLASS_DESCRIPTOR");

        try {
            // smaliParser.g:462:3: ( IMPLEMENTS_DIRECTIVE CLASS_DESCRIPTOR -> ^( I_IMPLEMENTS[$start, \"I_IMPLEMENTS\"] CLASS_DESCRIPTOR ) )
            // smaliParser.g:462:5: IMPLEMENTS_DIRECTIVE CLASS_DESCRIPTOR
            {
                IMPLEMENTS_DIRECTIVE14 = (Token) match(input, IMPLEMENTS_DIRECTIVE, FOLLOW_IMPLEMENTS_DIRECTIVE_in_implements_spec1264);
                stream_IMPLEMENTS_DIRECTIVE.add(IMPLEMENTS_DIRECTIVE14);

                CLASS_DESCRIPTOR15 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_implements_spec1266);
                stream_CLASS_DESCRIPTOR.add(CLASS_DESCRIPTOR15);

                // AST REWRITE
                // elements: CLASS_DESCRIPTOR
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 462:43: -> ^( I_IMPLEMENTS[$start, \"I_IMPLEMENTS\"] CLASS_DESCRIPTOR )
                {
                    // smaliParser.g:462:46: ^( I_IMPLEMENTS[$start, \"I_IMPLEMENTS\"] CLASS_DESCRIPTOR )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_IMPLEMENTS, (retval.start), "I_IMPLEMENTS"), root_1);
                        adaptor.addChild(root_1, stream_CLASS_DESCRIPTOR.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "implements_spec"


    public static class source_spec_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "source_spec"
    // smaliParser.g:464:1: source_spec : SOURCE_DIRECTIVE STRING_LITERAL -> ^( I_SOURCE[$start, \"I_SOURCE\"] STRING_LITERAL ) ;
    public final smaliParser.source_spec_return source_spec() throws RecognitionException {
        smaliParser.source_spec_return retval = new smaliParser.source_spec_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SOURCE_DIRECTIVE16 = null;
        Token STRING_LITERAL17 = null;

        CommonTree SOURCE_DIRECTIVE16_tree = null;
        CommonTree STRING_LITERAL17_tree = null;
        RewriteRuleTokenStream stream_SOURCE_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token SOURCE_DIRECTIVE");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");

        try {
            // smaliParser.g:465:3: ( SOURCE_DIRECTIVE STRING_LITERAL -> ^( I_SOURCE[$start, \"I_SOURCE\"] STRING_LITERAL ) )
            // smaliParser.g:465:5: SOURCE_DIRECTIVE STRING_LITERAL
            {
                SOURCE_DIRECTIVE16 = (Token) match(input, SOURCE_DIRECTIVE, FOLLOW_SOURCE_DIRECTIVE_in_source_spec1285);
                stream_SOURCE_DIRECTIVE.add(SOURCE_DIRECTIVE16);

                STRING_LITERAL17 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_source_spec1287);
                stream_STRING_LITERAL.add(STRING_LITERAL17);

                // AST REWRITE
                // elements: STRING_LITERAL
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 465:37: -> ^( I_SOURCE[$start, \"I_SOURCE\"] STRING_LITERAL )
                {
                    // smaliParser.g:465:40: ^( I_SOURCE[$start, \"I_SOURCE\"] STRING_LITERAL )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SOURCE, (retval.start), "I_SOURCE"), root_1);
                        adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "source_spec"


    public static class access_list_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "access_list"
    // smaliParser.g:467:1: access_list : ( ACCESS_SPEC )* -> ^( I_ACCESS_LIST[$start,\"I_ACCESS_LIST\"] ( ACCESS_SPEC )* ) ;
    public final smaliParser.access_list_return access_list() throws RecognitionException {
        smaliParser.access_list_return retval = new smaliParser.access_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ACCESS_SPEC18 = null;

        CommonTree ACCESS_SPEC18_tree = null;
        RewriteRuleTokenStream stream_ACCESS_SPEC = new RewriteRuleTokenStream(adaptor, "token ACCESS_SPEC");

        try {
            // smaliParser.g:468:3: ( ( ACCESS_SPEC )* -> ^( I_ACCESS_LIST[$start,\"I_ACCESS_LIST\"] ( ACCESS_SPEC )* ) )
            // smaliParser.g:468:5: ( ACCESS_SPEC )*
            {
                // smaliParser.g:468:5: ( ACCESS_SPEC )*
                loop2:
                while (true) {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);
                    if ((LA2_0 == ACCESS_SPEC)) {
                        int LA2_2 = input.LA(2);
                        if ((LA2_2 == ACCESS_SPEC || LA2_2 == ANNOTATION_VISIBILITY || LA2_2 == BOOL_LITERAL || LA2_2 == CLASS_DESCRIPTOR || LA2_2 == DOUBLE_LITERAL_OR_ID || LA2_2 == FLOAT_LITERAL_OR_ID || (LA2_2 >= INSTRUCTION_FORMAT10t && LA2_2 <= INSTRUCTION_FORMAT10x_ODEX) || LA2_2 == INSTRUCTION_FORMAT11x || LA2_2 == INSTRUCTION_FORMAT12x_OR_ID || (LA2_2 >= INSTRUCTION_FORMAT21c_FIELD && LA2_2 <= INSTRUCTION_FORMAT21c_TYPE) || LA2_2 == INSTRUCTION_FORMAT21t || (LA2_2 >= INSTRUCTION_FORMAT22c_FIELD && LA2_2 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA2_2 >= INSTRUCTION_FORMAT22s_OR_ID && LA2_2 <= INSTRUCTION_FORMAT22t) || LA2_2 == INSTRUCTION_FORMAT23x || (LA2_2 >= INSTRUCTION_FORMAT31i_OR_ID && LA2_2 <= INSTRUCTION_FORMAT31t) || (LA2_2 >= INSTRUCTION_FORMAT35c_METHOD && LA2_2 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA2_2 >= INSTRUCTION_FORMAT45cc_METHOD && LA2_2 <= INSTRUCTION_FORMAT51l) || LA2_2 == MEMBER_NAME || (LA2_2 >= NEGATIVE_INTEGER_LITERAL && LA2_2 <= NULL_LITERAL) || (LA2_2 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA2_2 <= PRIMITIVE_TYPE) || LA2_2 == REGISTER || LA2_2 == SIMPLE_NAME || (LA2_2 >= VERIFICATION_ERROR_TYPE && LA2_2 <= VOID_TYPE))) {
                            alt2 = 1;
                        }

                    }

                    switch (alt2) {
                        case 1:
                            // smaliParser.g:468:5: ACCESS_SPEC
                        {
                            ACCESS_SPEC18 = (Token) match(input, ACCESS_SPEC, FOLLOW_ACCESS_SPEC_in_access_list1306);
                            stream_ACCESS_SPEC.add(ACCESS_SPEC18);

                        }
                        break;

                        default:
                            break loop2;
                    }
                }

                // AST REWRITE
                // elements: ACCESS_SPEC
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 468:18: -> ^( I_ACCESS_LIST[$start,\"I_ACCESS_LIST\"] ( ACCESS_SPEC )* )
                {
                    // smaliParser.g:468:21: ^( I_ACCESS_LIST[$start,\"I_ACCESS_LIST\"] ( ACCESS_SPEC )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ACCESS_LIST, (retval.start), "I_ACCESS_LIST"), root_1);
                        // smaliParser.g:468:61: ( ACCESS_SPEC )*
                        while (stream_ACCESS_SPEC.hasNext()) {
                            adaptor.addChild(root_1, stream_ACCESS_SPEC.nextNode());
                        }
                        stream_ACCESS_SPEC.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "access_list"


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "field"
    // smaliParser.g:475:1: field : FIELD_DIRECTIVE access_list member_name COLON nonvoid_type_descriptor ( EQUAL literal )? ( ({...}? annotation )* ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) ) ) ;
    public final smaliParser.field_return field() throws RecognitionException {
        smaliParser.field_return retval = new smaliParser.field_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FIELD_DIRECTIVE19 = null;
        Token COLON22 = null;
        Token EQUAL24 = null;
        Token END_FIELD_DIRECTIVE27 = null;
        ParserRuleReturnScope access_list20 = null;
        ParserRuleReturnScope member_name21 = null;
        ParserRuleReturnScope nonvoid_type_descriptor23 = null;
        ParserRuleReturnScope literal25 = null;
        ParserRuleReturnScope annotation26 = null;

        CommonTree FIELD_DIRECTIVE19_tree = null;
        CommonTree COLON22_tree = null;
        CommonTree EQUAL24_tree = null;
        CommonTree END_FIELD_DIRECTIVE27_tree = null;
        RewriteRuleTokenStream stream_END_FIELD_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_FIELD_DIRECTIVE");
        RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(adaptor, "token EQUAL");
        RewriteRuleTokenStream stream_FIELD_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token FIELD_DIRECTIVE");
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleSubtreeStream stream_annotation = new RewriteRuleSubtreeStream(adaptor, "rule annotation");
        RewriteRuleSubtreeStream stream_access_list = new RewriteRuleSubtreeStream(adaptor, "rule access_list");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");
        RewriteRuleSubtreeStream stream_member_name = new RewriteRuleSubtreeStream(adaptor, "rule member_name");
        RewriteRuleSubtreeStream stream_literal = new RewriteRuleSubtreeStream(adaptor, "rule literal");

        List<CommonTree> annotations = new ArrayList<CommonTree>();
        try {
            // smaliParser.g:477:3: ( FIELD_DIRECTIVE access_list member_name COLON nonvoid_type_descriptor ( EQUAL literal )? ( ({...}? annotation )* ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) ) ) )
            // smaliParser.g:477:5: FIELD_DIRECTIVE access_list member_name COLON nonvoid_type_descriptor ( EQUAL literal )? ( ({...}? annotation )* ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) ) )
            {
                FIELD_DIRECTIVE19 = (Token) match(input, FIELD_DIRECTIVE, FOLLOW_FIELD_DIRECTIVE_in_field1337);
                stream_FIELD_DIRECTIVE.add(FIELD_DIRECTIVE19);

                pushFollow(FOLLOW_access_list_in_field1339);
                access_list20 = access_list();
                state._fsp--;

                stream_access_list.add(access_list20.getTree());
                pushFollow(FOLLOW_member_name_in_field1341);
                member_name21 = member_name();
                state._fsp--;

                stream_member_name.add(member_name21.getTree());
                COLON22 = (Token) match(input, COLON, FOLLOW_COLON_in_field1343);
                stream_COLON.add(COLON22);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_field1345);
                nonvoid_type_descriptor23 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor23.getTree());
                // smaliParser.g:477:75: ( EQUAL literal )?
                int alt3 = 2;
                int LA3_0 = input.LA(1);
                if ((LA3_0 == EQUAL)) {
                    alt3 = 1;
                }
                switch (alt3) {
                    case 1:
                        // smaliParser.g:477:76: EQUAL literal
                    {
                        EQUAL24 = (Token) match(input, EQUAL, FOLLOW_EQUAL_in_field1348);
                        stream_EQUAL.add(EQUAL24);

                        pushFollow(FOLLOW_literal_in_field1350);
                        literal25 = literal();
                        state._fsp--;

                        stream_literal.add(literal25.getTree());
                    }
                    break;

                }

                // smaliParser.g:478:5: ( ({...}? annotation )* ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) ) )
                // smaliParser.g:478:7: ({...}? annotation )* ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) )
                {
                    // smaliParser.g:478:7: ({...}? annotation )*
                    loop4:
                    while (true) {
                        int alt4 = 2;
                        int LA4_0 = input.LA(1);
                        if ((LA4_0 == ANNOTATION_DIRECTIVE)) {
                            int LA4_9 = input.LA(2);
                            if (((input.LA(1) == ANNOTATION_DIRECTIVE))) {
                                alt4 = 1;
                            }

                        }

                        switch (alt4) {
                            case 1:
                                // smaliParser.g:478:8: {...}? annotation
                            {
                                if (!((input.LA(1) == ANNOTATION_DIRECTIVE))) {
                                    throw new FailedPredicateException(input, "field", "input.LA(1) == ANNOTATION_DIRECTIVE");
                                }
                                pushFollow(FOLLOW_annotation_in_field1363);
                                annotation26 = annotation();
                                state._fsp--;

                                stream_annotation.add(annotation26.getTree());
                                annotations.add((annotation26 != null ? ((CommonTree) annotation26.getTree()) : null));
                            }
                            break;

                            default:
                                break loop4;
                        }
                    }

                    // smaliParser.g:479:7: ( END_FIELD_DIRECTIVE -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) ) )
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);
                    if ((LA5_0 == END_FIELD_DIRECTIVE)) {
                        alt5 = 1;
                    } else if ((LA5_0 == EOF || LA5_0 == ANNOTATION_DIRECTIVE || LA5_0 == CLASS_DIRECTIVE || LA5_0 == FIELD_DIRECTIVE || LA5_0 == IMPLEMENTS_DIRECTIVE || LA5_0 == METHOD_DIRECTIVE || LA5_0 == SOURCE_DIRECTIVE || LA5_0 == SUPER_DIRECTIVE)) {
                        alt5 = 2;
                    } else {
                        NoViableAltException nvae =
                                new NoViableAltException("", 5, 0, input);
                        throw nvae;
                    }

                    switch (alt5) {
                        case 1:
                            // smaliParser.g:479:9: END_FIELD_DIRECTIVE
                        {
                            END_FIELD_DIRECTIVE27 = (Token) match(input, END_FIELD_DIRECTIVE, FOLLOW_END_FIELD_DIRECTIVE_in_field1377);
                            stream_END_FIELD_DIRECTIVE.add(END_FIELD_DIRECTIVE27);

                            // AST REWRITE
                            // elements: member_name, annotation, nonvoid_type_descriptor, access_list, literal
                            // token labels:
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                            root_0 = (CommonTree) adaptor.nil();
                            // 480:9: -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) )
                            {
                                // smaliParser.g:480:12: ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ( annotation )* ) )
                                {
                                    CommonTree root_1 = (CommonTree) adaptor.nil();
                                    root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD, (retval.start), "I_FIELD"), root_1);
                                    adaptor.addChild(root_1, stream_member_name.nextTree());
                                    adaptor.addChild(root_1, stream_access_list.nextTree());
                                    // smaliParser.g:480:65: ^( I_FIELD_TYPE nonvoid_type_descriptor )
                                    {
                                        CommonTree root_2 = (CommonTree) adaptor.nil();
                                        root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD_TYPE, "I_FIELD_TYPE"), root_2);
                                        adaptor.addChild(root_2, stream_nonvoid_type_descriptor.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }

                                    // smaliParser.g:480:105: ( ^( I_FIELD_INITIAL_VALUE literal ) )?
                                    if (stream_literal.hasNext()) {
                                        // smaliParser.g:480:105: ^( I_FIELD_INITIAL_VALUE literal )
                                        {
                                            CommonTree root_2 = (CommonTree) adaptor.nil();
                                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD_INITIAL_VALUE, "I_FIELD_INITIAL_VALUE"), root_2);
                                            adaptor.addChild(root_2, stream_literal.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }

                                    }
                                    stream_literal.reset();

                                    // smaliParser.g:480:139: ^( I_ANNOTATIONS ( annotation )* )
                                    {
                                        CommonTree root_2 = (CommonTree) adaptor.nil();
                                        root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATIONS, "I_ANNOTATIONS"), root_2);
                                        // smaliParser.g:480:155: ( annotation )*
                                        while (stream_annotation.hasNext()) {
                                            adaptor.addChild(root_2, stream_annotation.nextTree());
                                        }
                                        stream_annotation.reset();

                                        adaptor.addChild(root_1, root_2);
                                    }

                                    adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                        }
                        break;
                        case 2:
                            // smaliParser.g:481:21:
                        {
                            smali_file_stack.peek().classAnnotations.addAll(annotations);
                            // AST REWRITE
                            // elements: access_list, nonvoid_type_descriptor, member_name, literal
                            // token labels:
                            // rule labels: retval
                            // token list labels:
                            // rule list labels:
                            // wildcard labels:
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                            root_0 = (CommonTree) adaptor.nil();
                            // 482:9: -> ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) )
                            {
                                // smaliParser.g:482:12: ^( I_FIELD[$start, \"I_FIELD\"] member_name access_list ^( I_FIELD_TYPE nonvoid_type_descriptor ) ( ^( I_FIELD_INITIAL_VALUE literal ) )? ^( I_ANNOTATIONS ) )
                                {
                                    CommonTree root_1 = (CommonTree) adaptor.nil();
                                    root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD, (retval.start), "I_FIELD"), root_1);
                                    adaptor.addChild(root_1, stream_member_name.nextTree());
                                    adaptor.addChild(root_1, stream_access_list.nextTree());
                                    // smaliParser.g:482:65: ^( I_FIELD_TYPE nonvoid_type_descriptor )
                                    {
                                        CommonTree root_2 = (CommonTree) adaptor.nil();
                                        root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD_TYPE, "I_FIELD_TYPE"), root_2);
                                        adaptor.addChild(root_2, stream_nonvoid_type_descriptor.nextTree());
                                        adaptor.addChild(root_1, root_2);
                                    }

                                    // smaliParser.g:482:105: ( ^( I_FIELD_INITIAL_VALUE literal ) )?
                                    if (stream_literal.hasNext()) {
                                        // smaliParser.g:482:105: ^( I_FIELD_INITIAL_VALUE literal )
                                        {
                                            CommonTree root_2 = (CommonTree) adaptor.nil();
                                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_FIELD_INITIAL_VALUE, "I_FIELD_INITIAL_VALUE"), root_2);
                                            adaptor.addChild(root_2, stream_literal.nextTree());
                                            adaptor.addChild(root_1, root_2);
                                        }

                                    }
                                    stream_literal.reset();

                                    // smaliParser.g:482:139: ^( I_ANNOTATIONS )
                                    {
                                        CommonTree root_2 = (CommonTree) adaptor.nil();
                                        root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATIONS, "I_ANNOTATIONS"), root_2);
                                        adaptor.addChild(root_1, root_2);
                                    }

                                    adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                        }
                        break;

                    }

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field"


    public static class method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "method"
    // smaliParser.g:486:1: method : METHOD_DIRECTIVE access_list member_name method_prototype statements_and_directives END_METHOD_DIRECTIVE -> ^( I_METHOD[$start, \"I_METHOD\"] member_name method_prototype access_list statements_and_directives ) ;
    public final smaliParser.method_return method() throws RecognitionException {
        smaliParser.method_return retval = new smaliParser.method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token METHOD_DIRECTIVE28 = null;
        Token END_METHOD_DIRECTIVE33 = null;
        ParserRuleReturnScope access_list29 = null;
        ParserRuleReturnScope member_name30 = null;
        ParserRuleReturnScope method_prototype31 = null;
        ParserRuleReturnScope statements_and_directives32 = null;

        CommonTree METHOD_DIRECTIVE28_tree = null;
        CommonTree END_METHOD_DIRECTIVE33_tree = null;
        RewriteRuleTokenStream stream_END_METHOD_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_METHOD_DIRECTIVE");
        RewriteRuleTokenStream stream_METHOD_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token METHOD_DIRECTIVE");
        RewriteRuleSubtreeStream stream_method_prototype = new RewriteRuleSubtreeStream(adaptor, "rule method_prototype");
        RewriteRuleSubtreeStream stream_access_list = new RewriteRuleSubtreeStream(adaptor, "rule access_list");
        RewriteRuleSubtreeStream stream_member_name = new RewriteRuleSubtreeStream(adaptor, "rule member_name");
        RewriteRuleSubtreeStream stream_statements_and_directives = new RewriteRuleSubtreeStream(adaptor, "rule statements_and_directives");

        try {
            // smaliParser.g:487:3: ( METHOD_DIRECTIVE access_list member_name method_prototype statements_and_directives END_METHOD_DIRECTIVE -> ^( I_METHOD[$start, \"I_METHOD\"] member_name method_prototype access_list statements_and_directives ) )
            // smaliParser.g:487:5: METHOD_DIRECTIVE access_list member_name method_prototype statements_and_directives END_METHOD_DIRECTIVE
            {
                METHOD_DIRECTIVE28 = (Token) match(input, METHOD_DIRECTIVE, FOLLOW_METHOD_DIRECTIVE_in_method1488);
                stream_METHOD_DIRECTIVE.add(METHOD_DIRECTIVE28);

                pushFollow(FOLLOW_access_list_in_method1490);
                access_list29 = access_list();
                state._fsp--;

                stream_access_list.add(access_list29.getTree());
                pushFollow(FOLLOW_member_name_in_method1492);
                member_name30 = member_name();
                state._fsp--;

                stream_member_name.add(member_name30.getTree());
                pushFollow(FOLLOW_method_prototype_in_method1494);
                method_prototype31 = method_prototype();
                state._fsp--;

                stream_method_prototype.add(method_prototype31.getTree());
                pushFollow(FOLLOW_statements_and_directives_in_method1496);
                statements_and_directives32 = statements_and_directives();
                state._fsp--;

                stream_statements_and_directives.add(statements_and_directives32.getTree());
                END_METHOD_DIRECTIVE33 = (Token) match(input, END_METHOD_DIRECTIVE, FOLLOW_END_METHOD_DIRECTIVE_in_method1502);
                stream_END_METHOD_DIRECTIVE.add(END_METHOD_DIRECTIVE33);

                // AST REWRITE
                // elements: method_prototype, statements_and_directives, access_list, member_name
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 489:5: -> ^( I_METHOD[$start, \"I_METHOD\"] member_name method_prototype access_list statements_and_directives )
                {
                    // smaliParser.g:489:8: ^( I_METHOD[$start, \"I_METHOD\"] member_name method_prototype access_list statements_and_directives )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_METHOD, (retval.start), "I_METHOD"), root_1);
                        adaptor.addChild(root_1, stream_member_name.nextTree());
                        adaptor.addChild(root_1, stream_method_prototype.nextTree());
                        adaptor.addChild(root_1, stream_access_list.nextTree());
                        adaptor.addChild(root_1, stream_statements_and_directives.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "method"


    protected static class statements_and_directives_scope {
        boolean hasRegistersDirective;
        List<CommonTree> methodAnnotations;
    }

    protected Stack<statements_and_directives_scope> statements_and_directives_stack = new Stack<statements_and_directives_scope>();

    public static class statements_and_directives_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "statements_and_directives"
    // smaliParser.g:491:1: statements_and_directives : ( ordered_method_item | registers_directive | catch_directive | catchall_directive | parameter_directive | annotation )* -> ( registers_directive )? ^( I_ORDERED_METHOD_ITEMS ( ordered_method_item )* ) ^( I_CATCHES ( catch_directive )* ( catchall_directive )* ) ^( I_PARAMETERS ( parameter_directive )* ) ;
    public final smaliParser.statements_and_directives_return statements_and_directives() throws RecognitionException {
        statements_and_directives_stack.push(new statements_and_directives_scope());
        smaliParser.statements_and_directives_return retval = new smaliParser.statements_and_directives_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope ordered_method_item34 = null;
        ParserRuleReturnScope registers_directive35 = null;
        ParserRuleReturnScope catch_directive36 = null;
        ParserRuleReturnScope catchall_directive37 = null;
        ParserRuleReturnScope parameter_directive38 = null;
        ParserRuleReturnScope annotation39 = null;

        RewriteRuleSubtreeStream stream_annotation = new RewriteRuleSubtreeStream(adaptor, "rule annotation");
        RewriteRuleSubtreeStream stream_catchall_directive = new RewriteRuleSubtreeStream(adaptor, "rule catchall_directive");
        RewriteRuleSubtreeStream stream_registers_directive = new RewriteRuleSubtreeStream(adaptor, "rule registers_directive");
        RewriteRuleSubtreeStream stream_catch_directive = new RewriteRuleSubtreeStream(adaptor, "rule catch_directive");
        RewriteRuleSubtreeStream stream_ordered_method_item = new RewriteRuleSubtreeStream(adaptor, "rule ordered_method_item");
        RewriteRuleSubtreeStream stream_parameter_directive = new RewriteRuleSubtreeStream(adaptor, "rule parameter_directive");

        try {
            // smaliParser.g:497:3: ( ( ordered_method_item | registers_directive | catch_directive | catchall_directive | parameter_directive | annotation )* -> ( registers_directive )? ^( I_ORDERED_METHOD_ITEMS ( ordered_method_item )* ) ^( I_CATCHES ( catch_directive )* ( catchall_directive )* ) ^( I_PARAMETERS ( parameter_directive )* ) )
            // smaliParser.g:497:5: ( ordered_method_item | registers_directive | catch_directive | catchall_directive | parameter_directive | annotation )*
            {

                statements_and_directives_stack.peek().hasRegistersDirective = false;
                statements_and_directives_stack.peek().methodAnnotations = new ArrayList<CommonTree>();

                // smaliParser.g:501:5: ( ordered_method_item | registers_directive | catch_directive | catchall_directive | parameter_directive | annotation )*
                loop6:
                while (true) {
                    int alt6 = 7;
                    switch (input.LA(1)) {
                        case ARRAY_DATA_DIRECTIVE:
                        case COLON:
                        case END_LOCAL_DIRECTIVE:
                        case EPILOGUE_DIRECTIVE:
                        case INSTRUCTION_FORMAT10t:
                        case INSTRUCTION_FORMAT10x:
                        case INSTRUCTION_FORMAT10x_ODEX:
                        case INSTRUCTION_FORMAT11n:
                        case INSTRUCTION_FORMAT11x:
                        case INSTRUCTION_FORMAT12x:
                        case INSTRUCTION_FORMAT12x_OR_ID:
                        case INSTRUCTION_FORMAT20bc:
                        case INSTRUCTION_FORMAT20t:
                        case INSTRUCTION_FORMAT21c_FIELD:
                        case INSTRUCTION_FORMAT21c_FIELD_ODEX:
                        case INSTRUCTION_FORMAT21c_STRING:
                        case INSTRUCTION_FORMAT21c_TYPE:
                        case INSTRUCTION_FORMAT21ih:
                        case INSTRUCTION_FORMAT21lh:
                        case INSTRUCTION_FORMAT21s:
                        case INSTRUCTION_FORMAT21t:
                        case INSTRUCTION_FORMAT22b:
                        case INSTRUCTION_FORMAT22c_FIELD:
                        case INSTRUCTION_FORMAT22c_FIELD_ODEX:
                        case INSTRUCTION_FORMAT22c_TYPE:
                        case INSTRUCTION_FORMAT22cs_FIELD:
                        case INSTRUCTION_FORMAT22s:
                        case INSTRUCTION_FORMAT22s_OR_ID:
                        case INSTRUCTION_FORMAT22t:
                        case INSTRUCTION_FORMAT22x:
                        case INSTRUCTION_FORMAT23x:
                        case INSTRUCTION_FORMAT30t:
                        case INSTRUCTION_FORMAT31c:
                        case INSTRUCTION_FORMAT31i:
                        case INSTRUCTION_FORMAT31i_OR_ID:
                        case INSTRUCTION_FORMAT31t:
                        case INSTRUCTION_FORMAT32x:
                        case INSTRUCTION_FORMAT35c_METHOD:
                        case INSTRUCTION_FORMAT35c_METHOD_ODEX:
                        case INSTRUCTION_FORMAT35c_TYPE:
                        case INSTRUCTION_FORMAT35mi_METHOD:
                        case INSTRUCTION_FORMAT35ms_METHOD:
                        case INSTRUCTION_FORMAT3rc_METHOD:
                        case INSTRUCTION_FORMAT3rc_METHOD_ODEX:
                        case INSTRUCTION_FORMAT3rc_TYPE:
                        case INSTRUCTION_FORMAT3rmi_METHOD:
                        case INSTRUCTION_FORMAT3rms_METHOD:
                        case INSTRUCTION_FORMAT45cc_METHOD:
                        case INSTRUCTION_FORMAT4rcc_METHOD:
                        case INSTRUCTION_FORMAT51l:
                        case LINE_DIRECTIVE:
                        case LOCAL_DIRECTIVE:
                        case PACKED_SWITCH_DIRECTIVE:
                        case PROLOGUE_DIRECTIVE:
                        case RESTART_LOCAL_DIRECTIVE:
                        case SOURCE_DIRECTIVE:
                        case SPARSE_SWITCH_DIRECTIVE: {
                            alt6 = 1;
                        }
                        break;
                        case LOCALS_DIRECTIVE:
                        case REGISTERS_DIRECTIVE: {
                            alt6 = 2;
                        }
                        break;
                        case CATCH_DIRECTIVE: {
                            alt6 = 3;
                        }
                        break;
                        case CATCHALL_DIRECTIVE: {
                            alt6 = 4;
                        }
                        break;
                        case PARAMETER_DIRECTIVE: {
                            alt6 = 5;
                        }
                        break;
                        case ANNOTATION_DIRECTIVE: {
                            alt6 = 6;
                        }
                        break;
                    }
                    switch (alt6) {
                        case 1:
                            // smaliParser.g:501:7: ordered_method_item
                        {
                            pushFollow(FOLLOW_ordered_method_item_in_statements_and_directives1547);
                            ordered_method_item34 = ordered_method_item();
                            state._fsp--;

                            stream_ordered_method_item.add(ordered_method_item34.getTree());
                        }
                        break;
                        case 2:
                            // smaliParser.g:502:7: registers_directive
                        {
                            pushFollow(FOLLOW_registers_directive_in_statements_and_directives1555);
                            registers_directive35 = registers_directive();
                            state._fsp--;

                            stream_registers_directive.add(registers_directive35.getTree());
                        }
                        break;
                        case 3:
                            // smaliParser.g:503:7: catch_directive
                        {
                            pushFollow(FOLLOW_catch_directive_in_statements_and_directives1563);
                            catch_directive36 = catch_directive();
                            state._fsp--;

                            stream_catch_directive.add(catch_directive36.getTree());
                        }
                        break;
                        case 4:
                            // smaliParser.g:504:7: catchall_directive
                        {
                            pushFollow(FOLLOW_catchall_directive_in_statements_and_directives1571);
                            catchall_directive37 = catchall_directive();
                            state._fsp--;

                            stream_catchall_directive.add(catchall_directive37.getTree());
                        }
                        break;
                        case 5:
                            // smaliParser.g:505:7: parameter_directive
                        {
                            pushFollow(FOLLOW_parameter_directive_in_statements_and_directives1579);
                            parameter_directive38 = parameter_directive();
                            state._fsp--;

                            stream_parameter_directive.add(parameter_directive38.getTree());
                        }
                        break;
                        case 6:
                            // smaliParser.g:506:7: annotation
                        {
                            pushFollow(FOLLOW_annotation_in_statements_and_directives1587);
                            annotation39 = annotation();
                            state._fsp--;

                            stream_annotation.add(annotation39.getTree());
                            statements_and_directives_stack.peek().methodAnnotations.add((annotation39 != null ? ((CommonTree) annotation39.getTree()) : null));
                        }
                        break;

                        default:
                            break loop6;
                    }
                }

                // AST REWRITE
                // elements: registers_directive, catchall_directive, parameter_directive, ordered_method_item, catch_directive
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 508:5: -> ( registers_directive )? ^( I_ORDERED_METHOD_ITEMS ( ordered_method_item )* ) ^( I_CATCHES ( catch_directive )* ( catchall_directive )* ) ^( I_PARAMETERS ( parameter_directive )* )
                {
                    // smaliParser.g:508:8: ( registers_directive )?
                    if (stream_registers_directive.hasNext()) {
                        adaptor.addChild(root_0, stream_registers_directive.nextTree());
                    }
                    stream_registers_directive.reset();

                    // smaliParser.g:509:8: ^( I_ORDERED_METHOD_ITEMS ( ordered_method_item )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ORDERED_METHOD_ITEMS, "I_ORDERED_METHOD_ITEMS"), root_1);
                        // smaliParser.g:509:33: ( ordered_method_item )*
                        while (stream_ordered_method_item.hasNext()) {
                            adaptor.addChild(root_1, stream_ordered_method_item.nextTree());
                        }
                        stream_ordered_method_item.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                    // smaliParser.g:510:8: ^( I_CATCHES ( catch_directive )* ( catchall_directive )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_CATCHES, "I_CATCHES"), root_1);
                        // smaliParser.g:510:20: ( catch_directive )*
                        while (stream_catch_directive.hasNext()) {
                            adaptor.addChild(root_1, stream_catch_directive.nextTree());
                        }
                        stream_catch_directive.reset();

                        // smaliParser.g:510:37: ( catchall_directive )*
                        while (stream_catchall_directive.hasNext()) {
                            adaptor.addChild(root_1, stream_catchall_directive.nextTree());
                        }
                        stream_catchall_directive.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                    // smaliParser.g:511:8: ^( I_PARAMETERS ( parameter_directive )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PARAMETERS, "I_PARAMETERS"), root_1);
                        // smaliParser.g:511:23: ( parameter_directive )*
                        while (stream_parameter_directive.hasNext()) {
                            adaptor.addChild(root_1, stream_parameter_directive.nextTree());
                        }
                        stream_parameter_directive.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                    adaptor.addChild(root_0, buildTree(I_ANNOTATIONS, "I_ANNOTATIONS", statements_and_directives_stack.peek().methodAnnotations));
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
            statements_and_directives_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statements_and_directives"


    public static class ordered_method_item_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "ordered_method_item"
    // smaliParser.g:515:1: ordered_method_item : ( label | instruction | debug_directive );
    public final smaliParser.ordered_method_item_return ordered_method_item() throws RecognitionException {
        smaliParser.ordered_method_item_return retval = new smaliParser.ordered_method_item_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope label40 = null;
        ParserRuleReturnScope instruction41 = null;
        ParserRuleReturnScope debug_directive42 = null;


        try {
            // smaliParser.g:516:3: ( label | instruction | debug_directive )
            int alt7 = 3;
            switch (input.LA(1)) {
                case COLON: {
                    alt7 = 1;
                }
                break;
                case ARRAY_DATA_DIRECTIVE:
                case INSTRUCTION_FORMAT10t:
                case INSTRUCTION_FORMAT10x:
                case INSTRUCTION_FORMAT10x_ODEX:
                case INSTRUCTION_FORMAT11n:
                case INSTRUCTION_FORMAT11x:
                case INSTRUCTION_FORMAT12x:
                case INSTRUCTION_FORMAT12x_OR_ID:
                case INSTRUCTION_FORMAT20bc:
                case INSTRUCTION_FORMAT20t:
                case INSTRUCTION_FORMAT21c_FIELD:
                case INSTRUCTION_FORMAT21c_FIELD_ODEX:
                case INSTRUCTION_FORMAT21c_STRING:
                case INSTRUCTION_FORMAT21c_TYPE:
                case INSTRUCTION_FORMAT21ih:
                case INSTRUCTION_FORMAT21lh:
                case INSTRUCTION_FORMAT21s:
                case INSTRUCTION_FORMAT21t:
                case INSTRUCTION_FORMAT22b:
                case INSTRUCTION_FORMAT22c_FIELD:
                case INSTRUCTION_FORMAT22c_FIELD_ODEX:
                case INSTRUCTION_FORMAT22c_TYPE:
                case INSTRUCTION_FORMAT22cs_FIELD:
                case INSTRUCTION_FORMAT22s:
                case INSTRUCTION_FORMAT22s_OR_ID:
                case INSTRUCTION_FORMAT22t:
                case INSTRUCTION_FORMAT22x:
                case INSTRUCTION_FORMAT23x:
                case INSTRUCTION_FORMAT30t:
                case INSTRUCTION_FORMAT31c:
                case INSTRUCTION_FORMAT31i:
                case INSTRUCTION_FORMAT31i_OR_ID:
                case INSTRUCTION_FORMAT31t:
                case INSTRUCTION_FORMAT32x:
                case INSTRUCTION_FORMAT35c_METHOD:
                case INSTRUCTION_FORMAT35c_METHOD_ODEX:
                case INSTRUCTION_FORMAT35c_TYPE:
                case INSTRUCTION_FORMAT35mi_METHOD:
                case INSTRUCTION_FORMAT35ms_METHOD:
                case INSTRUCTION_FORMAT3rc_METHOD:
                case INSTRUCTION_FORMAT3rc_METHOD_ODEX:
                case INSTRUCTION_FORMAT3rc_TYPE:
                case INSTRUCTION_FORMAT3rmi_METHOD:
                case INSTRUCTION_FORMAT3rms_METHOD:
                case INSTRUCTION_FORMAT45cc_METHOD:
                case INSTRUCTION_FORMAT4rcc_METHOD:
                case INSTRUCTION_FORMAT51l:
                case PACKED_SWITCH_DIRECTIVE:
                case SPARSE_SWITCH_DIRECTIVE: {
                    alt7 = 2;
                }
                break;
                case END_LOCAL_DIRECTIVE:
                case EPILOGUE_DIRECTIVE:
                case LINE_DIRECTIVE:
                case LOCAL_DIRECTIVE:
                case PROLOGUE_DIRECTIVE:
                case RESTART_LOCAL_DIRECTIVE:
                case SOURCE_DIRECTIVE: {
                    alt7 = 3;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);
                    throw nvae;
            }
            switch (alt7) {
                case 1:
                    // smaliParser.g:516:5: label
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_label_in_ordered_method_item1672);
                    label40 = label();
                    state._fsp--;

                    adaptor.addChild(root_0, label40.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:517:5: instruction
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_instruction_in_ordered_method_item1678);
                    instruction41 = instruction();
                    state._fsp--;

                    adaptor.addChild(root_0, instruction41.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:518:5: debug_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_debug_directive_in_ordered_method_item1684);
                    debug_directive42 = debug_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, debug_directive42.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ordered_method_item"


    public static class registers_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "registers_directive"
    // smaliParser.g:520:1: registers_directive : (directive= REGISTERS_DIRECTIVE regCount= integral_literal -> ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount) |directive= LOCALS_DIRECTIVE regCount2= integral_literal -> ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2) ) ;
    public final smaliParser.registers_directive_return registers_directive() throws RecognitionException {
        smaliParser.registers_directive_return retval = new smaliParser.registers_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token directive = null;
        ParserRuleReturnScope regCount = null;
        ParserRuleReturnScope regCount2 = null;

        CommonTree directive_tree = null;
        RewriteRuleTokenStream stream_LOCALS_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token LOCALS_DIRECTIVE");
        RewriteRuleTokenStream stream_REGISTERS_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token REGISTERS_DIRECTIVE");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:521:3: ( (directive= REGISTERS_DIRECTIVE regCount= integral_literal -> ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount) |directive= LOCALS_DIRECTIVE regCount2= integral_literal -> ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2) ) )
            // smaliParser.g:521:5: (directive= REGISTERS_DIRECTIVE regCount= integral_literal -> ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount) |directive= LOCALS_DIRECTIVE regCount2= integral_literal -> ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2) )
            {
                // smaliParser.g:521:5: (directive= REGISTERS_DIRECTIVE regCount= integral_literal -> ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount) |directive= LOCALS_DIRECTIVE regCount2= integral_literal -> ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2) )
                int alt8 = 2;
                int LA8_0 = input.LA(1);
                if ((LA8_0 == REGISTERS_DIRECTIVE)) {
                    alt8 = 1;
                } else if ((LA8_0 == LOCALS_DIRECTIVE)) {
                    alt8 = 2;
                } else {
                    NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);
                    throw nvae;
                }

                switch (alt8) {
                    case 1:
                        // smaliParser.g:522:7: directive= REGISTERS_DIRECTIVE regCount= integral_literal
                    {
                        directive = (Token) match(input, REGISTERS_DIRECTIVE, FOLLOW_REGISTERS_DIRECTIVE_in_registers_directive1704);
                        stream_REGISTERS_DIRECTIVE.add(directive);

                        pushFollow(FOLLOW_integral_literal_in_registers_directive1708);
                        regCount = integral_literal();
                        state._fsp--;

                        stream_integral_literal.add(regCount.getTree());
                        // AST REWRITE
                        // elements: regCount
                        // token labels:
                        // rule labels: regCount, retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_regCount = new RewriteRuleSubtreeStream(adaptor, "rule regCount", regCount != null ? regCount.getTree() : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                        root_0 = (CommonTree) adaptor.nil();
                        // 522:63: -> ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount)
                        {
                            // smaliParser.g:522:66: ^( I_REGISTERS[$REGISTERS_DIRECTIVE, \"I_REGISTERS\"] $regCount)
                            {
                                CommonTree root_1 = (CommonTree) adaptor.nil();
                                root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_REGISTERS, directive, "I_REGISTERS"), root_1);
                                adaptor.addChild(root_1, stream_regCount.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;

                    }
                    break;
                    case 2:
                        // smaliParser.g:523:7: directive= LOCALS_DIRECTIVE regCount2= integral_literal
                    {
                        directive = (Token) match(input, LOCALS_DIRECTIVE, FOLLOW_LOCALS_DIRECTIVE_in_registers_directive1728);
                        stream_LOCALS_DIRECTIVE.add(directive);

                        pushFollow(FOLLOW_integral_literal_in_registers_directive1732);
                        regCount2 = integral_literal();
                        state._fsp--;

                        stream_integral_literal.add(regCount2.getTree());
                        // AST REWRITE
                        // elements: regCount2
                        // token labels:
                        // rule labels: regCount2, retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_regCount2 = new RewriteRuleSubtreeStream(adaptor, "rule regCount2", regCount2 != null ? regCount2.getTree() : null);
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                        root_0 = (CommonTree) adaptor.nil();
                        // 523:61: -> ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2)
                        {
                            // smaliParser.g:523:64: ^( I_LOCALS[$LOCALS_DIRECTIVE, \"I_LOCALS\"] $regCount2)
                            {
                                CommonTree root_1 = (CommonTree) adaptor.nil();
                                root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_LOCALS, directive, "I_LOCALS"), root_1);
                                adaptor.addChild(root_1, stream_regCount2.nextTree());
                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;

                    }
                    break;

                }


                if (statements_and_directives_stack.peek().hasRegistersDirective) {
                    throw new SemanticException(input, directive, "There can only be a single .registers or .locals directive in a method");
                }
                statements_and_directives_stack.peek().hasRegistersDirective = true;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "registers_directive"


    public static class param_list_or_id_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "param_list_or_id"
    // smaliParser.g:532:1: param_list_or_id : ( PARAM_LIST_OR_ID_PRIMITIVE_TYPE )+ ;
    public final smaliParser.param_list_or_id_return param_list_or_id() throws RecognitionException {
        smaliParser.param_list_or_id_return retval = new smaliParser.param_list_or_id_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PARAM_LIST_OR_ID_PRIMITIVE_TYPE43 = null;

        CommonTree PARAM_LIST_OR_ID_PRIMITIVE_TYPE43_tree = null;

        try {
            // smaliParser.g:533:3: ( ( PARAM_LIST_OR_ID_PRIMITIVE_TYPE )+ )
            // smaliParser.g:533:5: ( PARAM_LIST_OR_ID_PRIMITIVE_TYPE )+
            {
                root_0 = (CommonTree) adaptor.nil();


                // smaliParser.g:533:5: ( PARAM_LIST_OR_ID_PRIMITIVE_TYPE )+
                int cnt9 = 0;
                loop9:
                while (true) {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);
                    if ((LA9_0 == PARAM_LIST_OR_ID_PRIMITIVE_TYPE)) {
                        alt9 = 1;
                    }

                    switch (alt9) {
                        case 1:
                            // smaliParser.g:533:5: PARAM_LIST_OR_ID_PRIMITIVE_TYPE
                        {
                            PARAM_LIST_OR_ID_PRIMITIVE_TYPE43 = (Token) match(input, PARAM_LIST_OR_ID_PRIMITIVE_TYPE, FOLLOW_PARAM_LIST_OR_ID_PRIMITIVE_TYPE_in_param_list_or_id1764);
                            PARAM_LIST_OR_ID_PRIMITIVE_TYPE43_tree = (CommonTree) adaptor.create(PARAM_LIST_OR_ID_PRIMITIVE_TYPE43);
                            adaptor.addChild(root_0, PARAM_LIST_OR_ID_PRIMITIVE_TYPE43_tree);

                        }
                        break;

                        default:
                            if (cnt9 >= 1) break loop9;
                            EarlyExitException eee = new EarlyExitException(9, input);
                            throw eee;
                    }
                    cnt9++;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "param_list_or_id"


    public static class simple_name_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "simple_name"
    // smaliParser.g:537:1: simple_name : ( SIMPLE_NAME | ACCESS_SPEC -> SIMPLE_NAME[$ACCESS_SPEC] | VERIFICATION_ERROR_TYPE -> SIMPLE_NAME[$VERIFICATION_ERROR_TYPE] | POSITIVE_INTEGER_LITERAL -> SIMPLE_NAME[$POSITIVE_INTEGER_LITERAL] | NEGATIVE_INTEGER_LITERAL -> SIMPLE_NAME[$NEGATIVE_INTEGER_LITERAL] | FLOAT_LITERAL_OR_ID -> SIMPLE_NAME[$FLOAT_LITERAL_OR_ID] | DOUBLE_LITERAL_OR_ID -> SIMPLE_NAME[$DOUBLE_LITERAL_OR_ID] | BOOL_LITERAL -> SIMPLE_NAME[$BOOL_LITERAL] | NULL_LITERAL -> SIMPLE_NAME[$NULL_LITERAL] | REGISTER -> SIMPLE_NAME[$REGISTER] | param_list_or_id ->| PRIMITIVE_TYPE -> SIMPLE_NAME[$PRIMITIVE_TYPE] | VOID_TYPE -> SIMPLE_NAME[$VOID_TYPE] | ANNOTATION_VISIBILITY -> SIMPLE_NAME[$ANNOTATION_VISIBILITY] | INSTRUCTION_FORMAT10t -> SIMPLE_NAME[$INSTRUCTION_FORMAT10t] | INSTRUCTION_FORMAT10x -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x] | INSTRUCTION_FORMAT10x_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x_ODEX] | INSTRUCTION_FORMAT11x -> SIMPLE_NAME[$INSTRUCTION_FORMAT11x] | INSTRUCTION_FORMAT12x_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT12x_OR_ID] | INSTRUCTION_FORMAT21c_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD] | INSTRUCTION_FORMAT21c_FIELD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD_ODEX] | INSTRUCTION_FORMAT21c_STRING -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_STRING] | INSTRUCTION_FORMAT21c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_TYPE] | INSTRUCTION_FORMAT21t -> SIMPLE_NAME[$INSTRUCTION_FORMAT21t] | INSTRUCTION_FORMAT22c_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD] | INSTRUCTION_FORMAT22c_FIELD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD_ODEX] | INSTRUCTION_FORMAT22c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_TYPE] | INSTRUCTION_FORMAT22cs_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT22cs_FIELD] | INSTRUCTION_FORMAT22s_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT22s_OR_ID] | INSTRUCTION_FORMAT22t -> SIMPLE_NAME[$INSTRUCTION_FORMAT22t] | INSTRUCTION_FORMAT23x -> SIMPLE_NAME[$INSTRUCTION_FORMAT23x] | INSTRUCTION_FORMAT31i_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT31i_OR_ID] | INSTRUCTION_FORMAT31t -> SIMPLE_NAME[$INSTRUCTION_FORMAT31t] | INSTRUCTION_FORMAT35c_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD] | INSTRUCTION_FORMAT35c_METHOD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD_ODEX] | INSTRUCTION_FORMAT35c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_TYPE] | INSTRUCTION_FORMAT35mi_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35mi_METHOD] | INSTRUCTION_FORMAT35ms_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35ms_METHOD] | INSTRUCTION_FORMAT45cc_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT45cc_METHOD] | INSTRUCTION_FORMAT4rcc_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT4rcc_METHOD] | INSTRUCTION_FORMAT51l -> SIMPLE_NAME[$INSTRUCTION_FORMAT51l] );
    public final smaliParser.simple_name_return simple_name() throws RecognitionException {
        smaliParser.simple_name_return retval = new smaliParser.simple_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SIMPLE_NAME44 = null;
        Token ACCESS_SPEC45 = null;
        Token VERIFICATION_ERROR_TYPE46 = null;
        Token POSITIVE_INTEGER_LITERAL47 = null;
        Token NEGATIVE_INTEGER_LITERAL48 = null;
        Token FLOAT_LITERAL_OR_ID49 = null;
        Token DOUBLE_LITERAL_OR_ID50 = null;
        Token BOOL_LITERAL51 = null;
        Token NULL_LITERAL52 = null;
        Token REGISTER53 = null;
        Token PRIMITIVE_TYPE55 = null;
        Token VOID_TYPE56 = null;
        Token ANNOTATION_VISIBILITY57 = null;
        Token INSTRUCTION_FORMAT10t58 = null;
        Token INSTRUCTION_FORMAT10x59 = null;
        Token INSTRUCTION_FORMAT10x_ODEX60 = null;
        Token INSTRUCTION_FORMAT11x61 = null;
        Token INSTRUCTION_FORMAT12x_OR_ID62 = null;
        Token INSTRUCTION_FORMAT21c_FIELD63 = null;
        Token INSTRUCTION_FORMAT21c_FIELD_ODEX64 = null;
        Token INSTRUCTION_FORMAT21c_STRING65 = null;
        Token INSTRUCTION_FORMAT21c_TYPE66 = null;
        Token INSTRUCTION_FORMAT21t67 = null;
        Token INSTRUCTION_FORMAT22c_FIELD68 = null;
        Token INSTRUCTION_FORMAT22c_FIELD_ODEX69 = null;
        Token INSTRUCTION_FORMAT22c_TYPE70 = null;
        Token INSTRUCTION_FORMAT22cs_FIELD71 = null;
        Token INSTRUCTION_FORMAT22s_OR_ID72 = null;
        Token INSTRUCTION_FORMAT22t73 = null;
        Token INSTRUCTION_FORMAT23x74 = null;
        Token INSTRUCTION_FORMAT31i_OR_ID75 = null;
        Token INSTRUCTION_FORMAT31t76 = null;
        Token INSTRUCTION_FORMAT35c_METHOD77 = null;
        Token INSTRUCTION_FORMAT35c_METHOD_ODEX78 = null;
        Token INSTRUCTION_FORMAT35c_TYPE79 = null;
        Token INSTRUCTION_FORMAT35mi_METHOD80 = null;
        Token INSTRUCTION_FORMAT35ms_METHOD81 = null;
        Token INSTRUCTION_FORMAT45cc_METHOD82 = null;
        Token INSTRUCTION_FORMAT4rcc_METHOD83 = null;
        Token INSTRUCTION_FORMAT51l84 = null;
        ParserRuleReturnScope param_list_or_id54 = null;

        CommonTree SIMPLE_NAME44_tree = null;
        CommonTree ACCESS_SPEC45_tree = null;
        CommonTree VERIFICATION_ERROR_TYPE46_tree = null;
        CommonTree POSITIVE_INTEGER_LITERAL47_tree = null;
        CommonTree NEGATIVE_INTEGER_LITERAL48_tree = null;
        CommonTree FLOAT_LITERAL_OR_ID49_tree = null;
        CommonTree DOUBLE_LITERAL_OR_ID50_tree = null;
        CommonTree BOOL_LITERAL51_tree = null;
        CommonTree NULL_LITERAL52_tree = null;
        CommonTree REGISTER53_tree = null;
        CommonTree PRIMITIVE_TYPE55_tree = null;
        CommonTree VOID_TYPE56_tree = null;
        CommonTree ANNOTATION_VISIBILITY57_tree = null;
        CommonTree INSTRUCTION_FORMAT10t58_tree = null;
        CommonTree INSTRUCTION_FORMAT10x59_tree = null;
        CommonTree INSTRUCTION_FORMAT10x_ODEX60_tree = null;
        CommonTree INSTRUCTION_FORMAT11x61_tree = null;
        CommonTree INSTRUCTION_FORMAT12x_OR_ID62_tree = null;
        CommonTree INSTRUCTION_FORMAT21c_FIELD63_tree = null;
        CommonTree INSTRUCTION_FORMAT21c_FIELD_ODEX64_tree = null;
        CommonTree INSTRUCTION_FORMAT21c_STRING65_tree = null;
        CommonTree INSTRUCTION_FORMAT21c_TYPE66_tree = null;
        CommonTree INSTRUCTION_FORMAT21t67_tree = null;
        CommonTree INSTRUCTION_FORMAT22c_FIELD68_tree = null;
        CommonTree INSTRUCTION_FORMAT22c_FIELD_ODEX69_tree = null;
        CommonTree INSTRUCTION_FORMAT22c_TYPE70_tree = null;
        CommonTree INSTRUCTION_FORMAT22cs_FIELD71_tree = null;
        CommonTree INSTRUCTION_FORMAT22s_OR_ID72_tree = null;
        CommonTree INSTRUCTION_FORMAT22t73_tree = null;
        CommonTree INSTRUCTION_FORMAT23x74_tree = null;
        CommonTree INSTRUCTION_FORMAT31i_OR_ID75_tree = null;
        CommonTree INSTRUCTION_FORMAT31t76_tree = null;
        CommonTree INSTRUCTION_FORMAT35c_METHOD77_tree = null;
        CommonTree INSTRUCTION_FORMAT35c_METHOD_ODEX78_tree = null;
        CommonTree INSTRUCTION_FORMAT35c_TYPE79_tree = null;
        CommonTree INSTRUCTION_FORMAT35mi_METHOD80_tree = null;
        CommonTree INSTRUCTION_FORMAT35ms_METHOD81_tree = null;
        CommonTree INSTRUCTION_FORMAT45cc_METHOD82_tree = null;
        CommonTree INSTRUCTION_FORMAT4rcc_METHOD83_tree = null;
        CommonTree INSTRUCTION_FORMAT51l84_tree = null;
        RewriteRuleTokenStream stream_ANNOTATION_VISIBILITY = new RewriteRuleTokenStream(adaptor, "token ANNOTATION_VISIBILITY");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22t");
        RewriteRuleTokenStream stream_VOID_TYPE = new RewriteRuleTokenStream(adaptor, "token VOID_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT10t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT10t");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35mi_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35mi_METHOD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22s_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22s_OR_ID");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22cs_FIELD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22cs_FIELD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT12x_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT12x_OR_ID");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35ms_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35ms_METHOD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35c_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35c_METHOD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT45cc_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT45cc_METHOD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35c_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT10x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT10x");
        RewriteRuleTokenStream stream_FLOAT_LITERAL_OR_ID = new RewriteRuleTokenStream(adaptor, "token FLOAT_LITERAL_OR_ID");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_STRING = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_STRING");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35c_METHOD_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35c_METHOD_ODEX");
        RewriteRuleTokenStream stream_NEGATIVE_INTEGER_LITERAL = new RewriteRuleTokenStream(adaptor, "token NEGATIVE_INTEGER_LITERAL");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_FIELD_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_FIELD_ODEX");
        RewriteRuleTokenStream stream_DOUBLE_LITERAL_OR_ID = new RewriteRuleTokenStream(adaptor, "token DOUBLE_LITERAL_OR_ID");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT31i_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT31i_OR_ID");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21t");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT31t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT31t");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT23x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT23x");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT51l = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT51l");
        RewriteRuleTokenStream stream_POSITIVE_INTEGER_LITERAL = new RewriteRuleTokenStream(adaptor, "token POSITIVE_INTEGER_LITERAL");
        RewriteRuleTokenStream stream_BOOL_LITERAL = new RewriteRuleTokenStream(adaptor, "token BOOL_LITERAL");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT10x_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT10x_ODEX");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_FIELD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_FIELD");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_FIELD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_FIELD");
        RewriteRuleTokenStream stream_VERIFICATION_ERROR_TYPE = new RewriteRuleTokenStream(adaptor, "token VERIFICATION_ERROR_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT11x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT11x");
        RewriteRuleTokenStream stream_ACCESS_SPEC = new RewriteRuleTokenStream(adaptor, "token ACCESS_SPEC");
        RewriteRuleTokenStream stream_NULL_LITERAL = new RewriteRuleTokenStream(adaptor, "token NULL_LITERAL");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT4rcc_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT4rcc_METHOD");
        RewriteRuleTokenStream stream_PRIMITIVE_TYPE = new RewriteRuleTokenStream(adaptor, "token PRIMITIVE_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_FIELD_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_FIELD_ODEX");
        RewriteRuleSubtreeStream stream_param_list_or_id = new RewriteRuleSubtreeStream(adaptor, "rule param_list_or_id");

        try {
            // smaliParser.g:538:3: ( SIMPLE_NAME | ACCESS_SPEC -> SIMPLE_NAME[$ACCESS_SPEC] | VERIFICATION_ERROR_TYPE -> SIMPLE_NAME[$VERIFICATION_ERROR_TYPE] | POSITIVE_INTEGER_LITERAL -> SIMPLE_NAME[$POSITIVE_INTEGER_LITERAL] | NEGATIVE_INTEGER_LITERAL -> SIMPLE_NAME[$NEGATIVE_INTEGER_LITERAL] | FLOAT_LITERAL_OR_ID -> SIMPLE_NAME[$FLOAT_LITERAL_OR_ID] | DOUBLE_LITERAL_OR_ID -> SIMPLE_NAME[$DOUBLE_LITERAL_OR_ID] | BOOL_LITERAL -> SIMPLE_NAME[$BOOL_LITERAL] | NULL_LITERAL -> SIMPLE_NAME[$NULL_LITERAL] | REGISTER -> SIMPLE_NAME[$REGISTER] | param_list_or_id ->| PRIMITIVE_TYPE -> SIMPLE_NAME[$PRIMITIVE_TYPE] | VOID_TYPE -> SIMPLE_NAME[$VOID_TYPE] | ANNOTATION_VISIBILITY -> SIMPLE_NAME[$ANNOTATION_VISIBILITY] | INSTRUCTION_FORMAT10t -> SIMPLE_NAME[$INSTRUCTION_FORMAT10t] | INSTRUCTION_FORMAT10x -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x] | INSTRUCTION_FORMAT10x_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x_ODEX] | INSTRUCTION_FORMAT11x -> SIMPLE_NAME[$INSTRUCTION_FORMAT11x] | INSTRUCTION_FORMAT12x_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT12x_OR_ID] | INSTRUCTION_FORMAT21c_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD] | INSTRUCTION_FORMAT21c_FIELD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD_ODEX] | INSTRUCTION_FORMAT21c_STRING -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_STRING] | INSTRUCTION_FORMAT21c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_TYPE] | INSTRUCTION_FORMAT21t -> SIMPLE_NAME[$INSTRUCTION_FORMAT21t] | INSTRUCTION_FORMAT22c_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD] | INSTRUCTION_FORMAT22c_FIELD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD_ODEX] | INSTRUCTION_FORMAT22c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_TYPE] | INSTRUCTION_FORMAT22cs_FIELD -> SIMPLE_NAME[$INSTRUCTION_FORMAT22cs_FIELD] | INSTRUCTION_FORMAT22s_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT22s_OR_ID] | INSTRUCTION_FORMAT22t -> SIMPLE_NAME[$INSTRUCTION_FORMAT22t] | INSTRUCTION_FORMAT23x -> SIMPLE_NAME[$INSTRUCTION_FORMAT23x] | INSTRUCTION_FORMAT31i_OR_ID -> SIMPLE_NAME[$INSTRUCTION_FORMAT31i_OR_ID] | INSTRUCTION_FORMAT31t -> SIMPLE_NAME[$INSTRUCTION_FORMAT31t] | INSTRUCTION_FORMAT35c_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD] | INSTRUCTION_FORMAT35c_METHOD_ODEX -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD_ODEX] | INSTRUCTION_FORMAT35c_TYPE -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_TYPE] | INSTRUCTION_FORMAT35mi_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35mi_METHOD] | INSTRUCTION_FORMAT35ms_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT35ms_METHOD] | INSTRUCTION_FORMAT45cc_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT45cc_METHOD] | INSTRUCTION_FORMAT4rcc_METHOD -> SIMPLE_NAME[$INSTRUCTION_FORMAT4rcc_METHOD] | INSTRUCTION_FORMAT51l -> SIMPLE_NAME[$INSTRUCTION_FORMAT51l] )
            int alt10 = 41;
            switch (input.LA(1)) {
                case SIMPLE_NAME: {
                    alt10 = 1;
                }
                break;
                case ACCESS_SPEC: {
                    alt10 = 2;
                }
                break;
                case VERIFICATION_ERROR_TYPE: {
                    alt10 = 3;
                }
                break;
                case POSITIVE_INTEGER_LITERAL: {
                    alt10 = 4;
                }
                break;
                case NEGATIVE_INTEGER_LITERAL: {
                    alt10 = 5;
                }
                break;
                case FLOAT_LITERAL_OR_ID: {
                    alt10 = 6;
                }
                break;
                case DOUBLE_LITERAL_OR_ID: {
                    alt10 = 7;
                }
                break;
                case BOOL_LITERAL: {
                    alt10 = 8;
                }
                break;
                case NULL_LITERAL: {
                    alt10 = 9;
                }
                break;
                case REGISTER: {
                    alt10 = 10;
                }
                break;
                case PARAM_LIST_OR_ID_PRIMITIVE_TYPE: {
                    alt10 = 11;
                }
                break;
                case PRIMITIVE_TYPE: {
                    alt10 = 12;
                }
                break;
                case VOID_TYPE: {
                    alt10 = 13;
                }
                break;
                case ANNOTATION_VISIBILITY: {
                    alt10 = 14;
                }
                break;
                case INSTRUCTION_FORMAT10t: {
                    alt10 = 15;
                }
                break;
                case INSTRUCTION_FORMAT10x: {
                    alt10 = 16;
                }
                break;
                case INSTRUCTION_FORMAT10x_ODEX: {
                    alt10 = 17;
                }
                break;
                case INSTRUCTION_FORMAT11x: {
                    alt10 = 18;
                }
                break;
                case INSTRUCTION_FORMAT12x_OR_ID: {
                    alt10 = 19;
                }
                break;
                case INSTRUCTION_FORMAT21c_FIELD: {
                    alt10 = 20;
                }
                break;
                case INSTRUCTION_FORMAT21c_FIELD_ODEX: {
                    alt10 = 21;
                }
                break;
                case INSTRUCTION_FORMAT21c_STRING: {
                    alt10 = 22;
                }
                break;
                case INSTRUCTION_FORMAT21c_TYPE: {
                    alt10 = 23;
                }
                break;
                case INSTRUCTION_FORMAT21t: {
                    alt10 = 24;
                }
                break;
                case INSTRUCTION_FORMAT22c_FIELD: {
                    alt10 = 25;
                }
                break;
                case INSTRUCTION_FORMAT22c_FIELD_ODEX: {
                    alt10 = 26;
                }
                break;
                case INSTRUCTION_FORMAT22c_TYPE: {
                    alt10 = 27;
                }
                break;
                case INSTRUCTION_FORMAT22cs_FIELD: {
                    alt10 = 28;
                }
                break;
                case INSTRUCTION_FORMAT22s_OR_ID: {
                    alt10 = 29;
                }
                break;
                case INSTRUCTION_FORMAT22t: {
                    alt10 = 30;
                }
                break;
                case INSTRUCTION_FORMAT23x: {
                    alt10 = 31;
                }
                break;
                case INSTRUCTION_FORMAT31i_OR_ID: {
                    alt10 = 32;
                }
                break;
                case INSTRUCTION_FORMAT31t: {
                    alt10 = 33;
                }
                break;
                case INSTRUCTION_FORMAT35c_METHOD: {
                    alt10 = 34;
                }
                break;
                case INSTRUCTION_FORMAT35c_METHOD_ODEX: {
                    alt10 = 35;
                }
                break;
                case INSTRUCTION_FORMAT35c_TYPE: {
                    alt10 = 36;
                }
                break;
                case INSTRUCTION_FORMAT35mi_METHOD: {
                    alt10 = 37;
                }
                break;
                case INSTRUCTION_FORMAT35ms_METHOD: {
                    alt10 = 38;
                }
                break;
                case INSTRUCTION_FORMAT45cc_METHOD: {
                    alt10 = 39;
                }
                break;
                case INSTRUCTION_FORMAT4rcc_METHOD: {
                    alt10 = 40;
                }
                break;
                case INSTRUCTION_FORMAT51l: {
                    alt10 = 41;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);
                    throw nvae;
            }
            switch (alt10) {
                case 1:
                    // smaliParser.g:538:5: SIMPLE_NAME
                {
                    root_0 = (CommonTree) adaptor.nil();


                    SIMPLE_NAME44 = (Token) match(input, SIMPLE_NAME, FOLLOW_SIMPLE_NAME_in_simple_name1777);
                    SIMPLE_NAME44_tree = (CommonTree) adaptor.create(SIMPLE_NAME44);
                    adaptor.addChild(root_0, SIMPLE_NAME44_tree);

                }
                break;
                case 2:
                    // smaliParser.g:539:5: ACCESS_SPEC
                {
                    ACCESS_SPEC45 = (Token) match(input, ACCESS_SPEC, FOLLOW_ACCESS_SPEC_in_simple_name1783);
                    stream_ACCESS_SPEC.add(ACCESS_SPEC45);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 539:17: -> SIMPLE_NAME[$ACCESS_SPEC]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, ACCESS_SPEC45));
                    }


                    retval.tree = root_0;

                }
                break;
                case 3:
                    // smaliParser.g:540:5: VERIFICATION_ERROR_TYPE
                {
                    VERIFICATION_ERROR_TYPE46 = (Token) match(input, VERIFICATION_ERROR_TYPE, FOLLOW_VERIFICATION_ERROR_TYPE_in_simple_name1794);
                    stream_VERIFICATION_ERROR_TYPE.add(VERIFICATION_ERROR_TYPE46);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 540:29: -> SIMPLE_NAME[$VERIFICATION_ERROR_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, VERIFICATION_ERROR_TYPE46));
                    }


                    retval.tree = root_0;

                }
                break;
                case 4:
                    // smaliParser.g:541:5: POSITIVE_INTEGER_LITERAL
                {
                    POSITIVE_INTEGER_LITERAL47 = (Token) match(input, POSITIVE_INTEGER_LITERAL, FOLLOW_POSITIVE_INTEGER_LITERAL_in_simple_name1805);
                    stream_POSITIVE_INTEGER_LITERAL.add(POSITIVE_INTEGER_LITERAL47);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 541:30: -> SIMPLE_NAME[$POSITIVE_INTEGER_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, POSITIVE_INTEGER_LITERAL47));
                    }


                    retval.tree = root_0;

                }
                break;
                case 5:
                    // smaliParser.g:542:5: NEGATIVE_INTEGER_LITERAL
                {
                    NEGATIVE_INTEGER_LITERAL48 = (Token) match(input, NEGATIVE_INTEGER_LITERAL, FOLLOW_NEGATIVE_INTEGER_LITERAL_in_simple_name1816);
                    stream_NEGATIVE_INTEGER_LITERAL.add(NEGATIVE_INTEGER_LITERAL48);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 542:30: -> SIMPLE_NAME[$NEGATIVE_INTEGER_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, NEGATIVE_INTEGER_LITERAL48));
                    }


                    retval.tree = root_0;

                }
                break;
                case 6:
                    // smaliParser.g:543:5: FLOAT_LITERAL_OR_ID
                {
                    FLOAT_LITERAL_OR_ID49 = (Token) match(input, FLOAT_LITERAL_OR_ID, FOLLOW_FLOAT_LITERAL_OR_ID_in_simple_name1827);
                    stream_FLOAT_LITERAL_OR_ID.add(FLOAT_LITERAL_OR_ID49);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 543:25: -> SIMPLE_NAME[$FLOAT_LITERAL_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, FLOAT_LITERAL_OR_ID49));
                    }


                    retval.tree = root_0;

                }
                break;
                case 7:
                    // smaliParser.g:544:5: DOUBLE_LITERAL_OR_ID
                {
                    DOUBLE_LITERAL_OR_ID50 = (Token) match(input, DOUBLE_LITERAL_OR_ID, FOLLOW_DOUBLE_LITERAL_OR_ID_in_simple_name1838);
                    stream_DOUBLE_LITERAL_OR_ID.add(DOUBLE_LITERAL_OR_ID50);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 544:26: -> SIMPLE_NAME[$DOUBLE_LITERAL_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, DOUBLE_LITERAL_OR_ID50));
                    }


                    retval.tree = root_0;

                }
                break;
                case 8:
                    // smaliParser.g:545:5: BOOL_LITERAL
                {
                    BOOL_LITERAL51 = (Token) match(input, BOOL_LITERAL, FOLLOW_BOOL_LITERAL_in_simple_name1849);
                    stream_BOOL_LITERAL.add(BOOL_LITERAL51);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 545:18: -> SIMPLE_NAME[$BOOL_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, BOOL_LITERAL51));
                    }


                    retval.tree = root_0;

                }
                break;
                case 9:
                    // smaliParser.g:546:5: NULL_LITERAL
                {
                    NULL_LITERAL52 = (Token) match(input, NULL_LITERAL, FOLLOW_NULL_LITERAL_in_simple_name1860);
                    stream_NULL_LITERAL.add(NULL_LITERAL52);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 546:18: -> SIMPLE_NAME[$NULL_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, NULL_LITERAL52));
                    }


                    retval.tree = root_0;

                }
                break;
                case 10:
                    // smaliParser.g:547:5: REGISTER
                {
                    REGISTER53 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_simple_name1871);
                    stream_REGISTER.add(REGISTER53);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 547:14: -> SIMPLE_NAME[$REGISTER]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, REGISTER53));
                    }


                    retval.tree = root_0;

                }
                break;
                case 11:
                    // smaliParser.g:548:5: param_list_or_id
                {
                    pushFollow(FOLLOW_param_list_or_id_in_simple_name1882);
                    param_list_or_id54 = param_list_or_id();
                    state._fsp--;

                    stream_param_list_or_id.add(param_list_or_id54.getTree());
                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 548:22: ->
                    {
                        adaptor.addChild(root_0, adaptor.create(SIMPLE_NAME, (param_list_or_id54 != null ? input.toString(param_list_or_id54.start, param_list_or_id54.stop) : null)));
                    }


                    retval.tree = root_0;

                }
                break;
                case 12:
                    // smaliParser.g:549:5: PRIMITIVE_TYPE
                {
                    PRIMITIVE_TYPE55 = (Token) match(input, PRIMITIVE_TYPE, FOLLOW_PRIMITIVE_TYPE_in_simple_name1892);
                    stream_PRIMITIVE_TYPE.add(PRIMITIVE_TYPE55);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 549:20: -> SIMPLE_NAME[$PRIMITIVE_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, PRIMITIVE_TYPE55));
                    }


                    retval.tree = root_0;

                }
                break;
                case 13:
                    // smaliParser.g:550:5: VOID_TYPE
                {
                    VOID_TYPE56 = (Token) match(input, VOID_TYPE, FOLLOW_VOID_TYPE_in_simple_name1903);
                    stream_VOID_TYPE.add(VOID_TYPE56);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 550:15: -> SIMPLE_NAME[$VOID_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, VOID_TYPE56));
                    }


                    retval.tree = root_0;

                }
                break;
                case 14:
                    // smaliParser.g:551:5: ANNOTATION_VISIBILITY
                {
                    ANNOTATION_VISIBILITY57 = (Token) match(input, ANNOTATION_VISIBILITY, FOLLOW_ANNOTATION_VISIBILITY_in_simple_name1914);
                    stream_ANNOTATION_VISIBILITY.add(ANNOTATION_VISIBILITY57);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 551:27: -> SIMPLE_NAME[$ANNOTATION_VISIBILITY]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, ANNOTATION_VISIBILITY57));
                    }


                    retval.tree = root_0;

                }
                break;
                case 15:
                    // smaliParser.g:552:5: INSTRUCTION_FORMAT10t
                {
                    INSTRUCTION_FORMAT10t58 = (Token) match(input, INSTRUCTION_FORMAT10t, FOLLOW_INSTRUCTION_FORMAT10t_in_simple_name1925);
                    stream_INSTRUCTION_FORMAT10t.add(INSTRUCTION_FORMAT10t58);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 552:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT10t]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT10t58));
                    }


                    retval.tree = root_0;

                }
                break;
                case 16:
                    // smaliParser.g:553:5: INSTRUCTION_FORMAT10x
                {
                    INSTRUCTION_FORMAT10x59 = (Token) match(input, INSTRUCTION_FORMAT10x, FOLLOW_INSTRUCTION_FORMAT10x_in_simple_name1936);
                    stream_INSTRUCTION_FORMAT10x.add(INSTRUCTION_FORMAT10x59);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 553:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT10x59));
                    }


                    retval.tree = root_0;

                }
                break;
                case 17:
                    // smaliParser.g:554:5: INSTRUCTION_FORMAT10x_ODEX
                {
                    INSTRUCTION_FORMAT10x_ODEX60 = (Token) match(input, INSTRUCTION_FORMAT10x_ODEX, FOLLOW_INSTRUCTION_FORMAT10x_ODEX_in_simple_name1947);
                    stream_INSTRUCTION_FORMAT10x_ODEX.add(INSTRUCTION_FORMAT10x_ODEX60);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 554:32: -> SIMPLE_NAME[$INSTRUCTION_FORMAT10x_ODEX]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT10x_ODEX60));
                    }


                    retval.tree = root_0;

                }
                break;
                case 18:
                    // smaliParser.g:555:5: INSTRUCTION_FORMAT11x
                {
                    INSTRUCTION_FORMAT11x61 = (Token) match(input, INSTRUCTION_FORMAT11x, FOLLOW_INSTRUCTION_FORMAT11x_in_simple_name1958);
                    stream_INSTRUCTION_FORMAT11x.add(INSTRUCTION_FORMAT11x61);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 555:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT11x]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT11x61));
                    }


                    retval.tree = root_0;

                }
                break;
                case 19:
                    // smaliParser.g:556:5: INSTRUCTION_FORMAT12x_OR_ID
                {
                    INSTRUCTION_FORMAT12x_OR_ID62 = (Token) match(input, INSTRUCTION_FORMAT12x_OR_ID, FOLLOW_INSTRUCTION_FORMAT12x_OR_ID_in_simple_name1969);
                    stream_INSTRUCTION_FORMAT12x_OR_ID.add(INSTRUCTION_FORMAT12x_OR_ID62);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 556:33: -> SIMPLE_NAME[$INSTRUCTION_FORMAT12x_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT12x_OR_ID62));
                    }


                    retval.tree = root_0;

                }
                break;
                case 20:
                    // smaliParser.g:557:5: INSTRUCTION_FORMAT21c_FIELD
                {
                    INSTRUCTION_FORMAT21c_FIELD63 = (Token) match(input, INSTRUCTION_FORMAT21c_FIELD, FOLLOW_INSTRUCTION_FORMAT21c_FIELD_in_simple_name1980);
                    stream_INSTRUCTION_FORMAT21c_FIELD.add(INSTRUCTION_FORMAT21c_FIELD63);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 557:33: -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT21c_FIELD63));
                    }


                    retval.tree = root_0;

                }
                break;
                case 21:
                    // smaliParser.g:558:5: INSTRUCTION_FORMAT21c_FIELD_ODEX
                {
                    INSTRUCTION_FORMAT21c_FIELD_ODEX64 = (Token) match(input, INSTRUCTION_FORMAT21c_FIELD_ODEX, FOLLOW_INSTRUCTION_FORMAT21c_FIELD_ODEX_in_simple_name1991);
                    stream_INSTRUCTION_FORMAT21c_FIELD_ODEX.add(INSTRUCTION_FORMAT21c_FIELD_ODEX64);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 558:38: -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_FIELD_ODEX]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT21c_FIELD_ODEX64));
                    }


                    retval.tree = root_0;

                }
                break;
                case 22:
                    // smaliParser.g:559:5: INSTRUCTION_FORMAT21c_STRING
                {
                    INSTRUCTION_FORMAT21c_STRING65 = (Token) match(input, INSTRUCTION_FORMAT21c_STRING, FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_simple_name2002);
                    stream_INSTRUCTION_FORMAT21c_STRING.add(INSTRUCTION_FORMAT21c_STRING65);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 559:34: -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_STRING]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT21c_STRING65));
                    }


                    retval.tree = root_0;

                }
                break;
                case 23:
                    // smaliParser.g:560:5: INSTRUCTION_FORMAT21c_TYPE
                {
                    INSTRUCTION_FORMAT21c_TYPE66 = (Token) match(input, INSTRUCTION_FORMAT21c_TYPE, FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_simple_name2013);
                    stream_INSTRUCTION_FORMAT21c_TYPE.add(INSTRUCTION_FORMAT21c_TYPE66);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 560:32: -> SIMPLE_NAME[$INSTRUCTION_FORMAT21c_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT21c_TYPE66));
                    }


                    retval.tree = root_0;

                }
                break;
                case 24:
                    // smaliParser.g:561:5: INSTRUCTION_FORMAT21t
                {
                    INSTRUCTION_FORMAT21t67 = (Token) match(input, INSTRUCTION_FORMAT21t, FOLLOW_INSTRUCTION_FORMAT21t_in_simple_name2024);
                    stream_INSTRUCTION_FORMAT21t.add(INSTRUCTION_FORMAT21t67);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 561:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT21t]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT21t67));
                    }


                    retval.tree = root_0;

                }
                break;
                case 25:
                    // smaliParser.g:562:5: INSTRUCTION_FORMAT22c_FIELD
                {
                    INSTRUCTION_FORMAT22c_FIELD68 = (Token) match(input, INSTRUCTION_FORMAT22c_FIELD, FOLLOW_INSTRUCTION_FORMAT22c_FIELD_in_simple_name2035);
                    stream_INSTRUCTION_FORMAT22c_FIELD.add(INSTRUCTION_FORMAT22c_FIELD68);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 562:33: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22c_FIELD68));
                    }


                    retval.tree = root_0;

                }
                break;
                case 26:
                    // smaliParser.g:563:5: INSTRUCTION_FORMAT22c_FIELD_ODEX
                {
                    INSTRUCTION_FORMAT22c_FIELD_ODEX69 = (Token) match(input, INSTRUCTION_FORMAT22c_FIELD_ODEX, FOLLOW_INSTRUCTION_FORMAT22c_FIELD_ODEX_in_simple_name2046);
                    stream_INSTRUCTION_FORMAT22c_FIELD_ODEX.add(INSTRUCTION_FORMAT22c_FIELD_ODEX69);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 563:38: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_FIELD_ODEX]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22c_FIELD_ODEX69));
                    }


                    retval.tree = root_0;

                }
                break;
                case 27:
                    // smaliParser.g:564:5: INSTRUCTION_FORMAT22c_TYPE
                {
                    INSTRUCTION_FORMAT22c_TYPE70 = (Token) match(input, INSTRUCTION_FORMAT22c_TYPE, FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_simple_name2057);
                    stream_INSTRUCTION_FORMAT22c_TYPE.add(INSTRUCTION_FORMAT22c_TYPE70);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 564:32: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22c_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22c_TYPE70));
                    }


                    retval.tree = root_0;

                }
                break;
                case 28:
                    // smaliParser.g:565:5: INSTRUCTION_FORMAT22cs_FIELD
                {
                    INSTRUCTION_FORMAT22cs_FIELD71 = (Token) match(input, INSTRUCTION_FORMAT22cs_FIELD, FOLLOW_INSTRUCTION_FORMAT22cs_FIELD_in_simple_name2068);
                    stream_INSTRUCTION_FORMAT22cs_FIELD.add(INSTRUCTION_FORMAT22cs_FIELD71);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 565:34: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22cs_FIELD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22cs_FIELD71));
                    }


                    retval.tree = root_0;

                }
                break;
                case 29:
                    // smaliParser.g:566:5: INSTRUCTION_FORMAT22s_OR_ID
                {
                    INSTRUCTION_FORMAT22s_OR_ID72 = (Token) match(input, INSTRUCTION_FORMAT22s_OR_ID, FOLLOW_INSTRUCTION_FORMAT22s_OR_ID_in_simple_name2079);
                    stream_INSTRUCTION_FORMAT22s_OR_ID.add(INSTRUCTION_FORMAT22s_OR_ID72);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 566:33: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22s_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22s_OR_ID72));
                    }


                    retval.tree = root_0;

                }
                break;
                case 30:
                    // smaliParser.g:567:5: INSTRUCTION_FORMAT22t
                {
                    INSTRUCTION_FORMAT22t73 = (Token) match(input, INSTRUCTION_FORMAT22t, FOLLOW_INSTRUCTION_FORMAT22t_in_simple_name2090);
                    stream_INSTRUCTION_FORMAT22t.add(INSTRUCTION_FORMAT22t73);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 567:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT22t]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT22t73));
                    }


                    retval.tree = root_0;

                }
                break;
                case 31:
                    // smaliParser.g:568:5: INSTRUCTION_FORMAT23x
                {
                    INSTRUCTION_FORMAT23x74 = (Token) match(input, INSTRUCTION_FORMAT23x, FOLLOW_INSTRUCTION_FORMAT23x_in_simple_name2101);
                    stream_INSTRUCTION_FORMAT23x.add(INSTRUCTION_FORMAT23x74);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 568:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT23x]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT23x74));
                    }


                    retval.tree = root_0;

                }
                break;
                case 32:
                    // smaliParser.g:569:5: INSTRUCTION_FORMAT31i_OR_ID
                {
                    INSTRUCTION_FORMAT31i_OR_ID75 = (Token) match(input, INSTRUCTION_FORMAT31i_OR_ID, FOLLOW_INSTRUCTION_FORMAT31i_OR_ID_in_simple_name2112);
                    stream_INSTRUCTION_FORMAT31i_OR_ID.add(INSTRUCTION_FORMAT31i_OR_ID75);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 569:33: -> SIMPLE_NAME[$INSTRUCTION_FORMAT31i_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT31i_OR_ID75));
                    }


                    retval.tree = root_0;

                }
                break;
                case 33:
                    // smaliParser.g:570:5: INSTRUCTION_FORMAT31t
                {
                    INSTRUCTION_FORMAT31t76 = (Token) match(input, INSTRUCTION_FORMAT31t, FOLLOW_INSTRUCTION_FORMAT31t_in_simple_name2123);
                    stream_INSTRUCTION_FORMAT31t.add(INSTRUCTION_FORMAT31t76);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 570:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT31t]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT31t76));
                    }


                    retval.tree = root_0;

                }
                break;
                case 34:
                    // smaliParser.g:571:5: INSTRUCTION_FORMAT35c_METHOD
                {
                    INSTRUCTION_FORMAT35c_METHOD77 = (Token) match(input, INSTRUCTION_FORMAT35c_METHOD, FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_simple_name2134);
                    stream_INSTRUCTION_FORMAT35c_METHOD.add(INSTRUCTION_FORMAT35c_METHOD77);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 571:34: -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT35c_METHOD77));
                    }


                    retval.tree = root_0;

                }
                break;
                case 35:
                    // smaliParser.g:572:5: INSTRUCTION_FORMAT35c_METHOD_ODEX
                {
                    INSTRUCTION_FORMAT35c_METHOD_ODEX78 = (Token) match(input, INSTRUCTION_FORMAT35c_METHOD_ODEX, FOLLOW_INSTRUCTION_FORMAT35c_METHOD_ODEX_in_simple_name2145);
                    stream_INSTRUCTION_FORMAT35c_METHOD_ODEX.add(INSTRUCTION_FORMAT35c_METHOD_ODEX78);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 572:39: -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_METHOD_ODEX]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT35c_METHOD_ODEX78));
                    }


                    retval.tree = root_0;

                }
                break;
                case 36:
                    // smaliParser.g:573:5: INSTRUCTION_FORMAT35c_TYPE
                {
                    INSTRUCTION_FORMAT35c_TYPE79 = (Token) match(input, INSTRUCTION_FORMAT35c_TYPE, FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_simple_name2156);
                    stream_INSTRUCTION_FORMAT35c_TYPE.add(INSTRUCTION_FORMAT35c_TYPE79);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 573:32: -> SIMPLE_NAME[$INSTRUCTION_FORMAT35c_TYPE]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT35c_TYPE79));
                    }


                    retval.tree = root_0;

                }
                break;
                case 37:
                    // smaliParser.g:574:5: INSTRUCTION_FORMAT35mi_METHOD
                {
                    INSTRUCTION_FORMAT35mi_METHOD80 = (Token) match(input, INSTRUCTION_FORMAT35mi_METHOD, FOLLOW_INSTRUCTION_FORMAT35mi_METHOD_in_simple_name2167);
                    stream_INSTRUCTION_FORMAT35mi_METHOD.add(INSTRUCTION_FORMAT35mi_METHOD80);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 574:35: -> SIMPLE_NAME[$INSTRUCTION_FORMAT35mi_METHOD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT35mi_METHOD80));
                    }


                    retval.tree = root_0;

                }
                break;
                case 38:
                    // smaliParser.g:575:5: INSTRUCTION_FORMAT35ms_METHOD
                {
                    INSTRUCTION_FORMAT35ms_METHOD81 = (Token) match(input, INSTRUCTION_FORMAT35ms_METHOD, FOLLOW_INSTRUCTION_FORMAT35ms_METHOD_in_simple_name2178);
                    stream_INSTRUCTION_FORMAT35ms_METHOD.add(INSTRUCTION_FORMAT35ms_METHOD81);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 575:35: -> SIMPLE_NAME[$INSTRUCTION_FORMAT35ms_METHOD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT35ms_METHOD81));
                    }


                    retval.tree = root_0;

                }
                break;
                case 39:
                    // smaliParser.g:576:5: INSTRUCTION_FORMAT45cc_METHOD
                {
                    INSTRUCTION_FORMAT45cc_METHOD82 = (Token) match(input, INSTRUCTION_FORMAT45cc_METHOD, FOLLOW_INSTRUCTION_FORMAT45cc_METHOD_in_simple_name2189);
                    stream_INSTRUCTION_FORMAT45cc_METHOD.add(INSTRUCTION_FORMAT45cc_METHOD82);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 576:35: -> SIMPLE_NAME[$INSTRUCTION_FORMAT45cc_METHOD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT45cc_METHOD82));
                    }


                    retval.tree = root_0;

                }
                break;
                case 40:
                    // smaliParser.g:577:5: INSTRUCTION_FORMAT4rcc_METHOD
                {
                    INSTRUCTION_FORMAT4rcc_METHOD83 = (Token) match(input, INSTRUCTION_FORMAT4rcc_METHOD, FOLLOW_INSTRUCTION_FORMAT4rcc_METHOD_in_simple_name2200);
                    stream_INSTRUCTION_FORMAT4rcc_METHOD.add(INSTRUCTION_FORMAT4rcc_METHOD83);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 577:35: -> SIMPLE_NAME[$INSTRUCTION_FORMAT4rcc_METHOD]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT4rcc_METHOD83));
                    }


                    retval.tree = root_0;

                }
                break;
                case 41:
                    // smaliParser.g:578:5: INSTRUCTION_FORMAT51l
                {
                    INSTRUCTION_FORMAT51l84 = (Token) match(input, INSTRUCTION_FORMAT51l, FOLLOW_INSTRUCTION_FORMAT51l_in_simple_name2211);
                    stream_INSTRUCTION_FORMAT51l.add(INSTRUCTION_FORMAT51l84);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 578:27: -> SIMPLE_NAME[$INSTRUCTION_FORMAT51l]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, INSTRUCTION_FORMAT51l84));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_name"


    public static class member_name_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "member_name"
    // smaliParser.g:580:1: member_name : ( simple_name | MEMBER_NAME -> SIMPLE_NAME[$MEMBER_NAME] );
    public final smaliParser.member_name_return member_name() throws RecognitionException {
        smaliParser.member_name_return retval = new smaliParser.member_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MEMBER_NAME86 = null;
        ParserRuleReturnScope simple_name85 = null;

        CommonTree MEMBER_NAME86_tree = null;
        RewriteRuleTokenStream stream_MEMBER_NAME = new RewriteRuleTokenStream(adaptor, "token MEMBER_NAME");

        try {
            // smaliParser.g:581:3: ( simple_name | MEMBER_NAME -> SIMPLE_NAME[$MEMBER_NAME] )
            int alt11 = 2;
            int LA11_0 = input.LA(1);
            if ((LA11_0 == ACCESS_SPEC || LA11_0 == ANNOTATION_VISIBILITY || LA11_0 == BOOL_LITERAL || LA11_0 == DOUBLE_LITERAL_OR_ID || LA11_0 == FLOAT_LITERAL_OR_ID || (LA11_0 >= INSTRUCTION_FORMAT10t && LA11_0 <= INSTRUCTION_FORMAT10x_ODEX) || LA11_0 == INSTRUCTION_FORMAT11x || LA11_0 == INSTRUCTION_FORMAT12x_OR_ID || (LA11_0 >= INSTRUCTION_FORMAT21c_FIELD && LA11_0 <= INSTRUCTION_FORMAT21c_TYPE) || LA11_0 == INSTRUCTION_FORMAT21t || (LA11_0 >= INSTRUCTION_FORMAT22c_FIELD && LA11_0 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA11_0 >= INSTRUCTION_FORMAT22s_OR_ID && LA11_0 <= INSTRUCTION_FORMAT22t) || LA11_0 == INSTRUCTION_FORMAT23x || (LA11_0 >= INSTRUCTION_FORMAT31i_OR_ID && LA11_0 <= INSTRUCTION_FORMAT31t) || (LA11_0 >= INSTRUCTION_FORMAT35c_METHOD && LA11_0 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA11_0 >= INSTRUCTION_FORMAT45cc_METHOD && LA11_0 <= INSTRUCTION_FORMAT51l) || (LA11_0 >= NEGATIVE_INTEGER_LITERAL && LA11_0 <= NULL_LITERAL) || (LA11_0 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA11_0 <= PRIMITIVE_TYPE) || LA11_0 == REGISTER || LA11_0 == SIMPLE_NAME || (LA11_0 >= VERIFICATION_ERROR_TYPE && LA11_0 <= VOID_TYPE))) {
                alt11 = 1;
            } else if ((LA11_0 == MEMBER_NAME)) {
                alt11 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 11, 0, input);
                throw nvae;
            }

            switch (alt11) {
                case 1:
                    // smaliParser.g:581:5: simple_name
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_simple_name_in_member_name2226);
                    simple_name85 = simple_name();
                    state._fsp--;

                    adaptor.addChild(root_0, simple_name85.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:582:5: MEMBER_NAME
                {
                    MEMBER_NAME86 = (Token) match(input, MEMBER_NAME, FOLLOW_MEMBER_NAME_in_member_name2232);
                    stream_MEMBER_NAME.add(MEMBER_NAME86);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 582:17: -> SIMPLE_NAME[$MEMBER_NAME]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(SIMPLE_NAME, MEMBER_NAME86));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "member_name"


    public static class method_prototype_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "method_prototype"
    // smaliParser.g:584:1: method_prototype : OPEN_PAREN param_list CLOSE_PAREN type_descriptor -> ^( I_METHOD_PROTOTYPE[$start, \"I_METHOD_PROTOTYPE\"] ^( I_METHOD_RETURN_TYPE type_descriptor ) ( param_list )? ) ;
    public final smaliParser.method_prototype_return method_prototype() throws RecognitionException {
        smaliParser.method_prototype_return retval = new smaliParser.method_prototype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OPEN_PAREN87 = null;
        Token CLOSE_PAREN89 = null;
        ParserRuleReturnScope param_list88 = null;
        ParserRuleReturnScope type_descriptor90 = null;

        CommonTree OPEN_PAREN87_tree = null;
        CommonTree CLOSE_PAREN89_tree = null;
        RewriteRuleTokenStream stream_OPEN_PAREN = new RewriteRuleTokenStream(adaptor, "token OPEN_PAREN");
        RewriteRuleTokenStream stream_CLOSE_PAREN = new RewriteRuleTokenStream(adaptor, "token CLOSE_PAREN");
        RewriteRuleSubtreeStream stream_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule type_descriptor");
        RewriteRuleSubtreeStream stream_param_list = new RewriteRuleSubtreeStream(adaptor, "rule param_list");

        try {
            // smaliParser.g:585:3: ( OPEN_PAREN param_list CLOSE_PAREN type_descriptor -> ^( I_METHOD_PROTOTYPE[$start, \"I_METHOD_PROTOTYPE\"] ^( I_METHOD_RETURN_TYPE type_descriptor ) ( param_list )? ) )
            // smaliParser.g:585:5: OPEN_PAREN param_list CLOSE_PAREN type_descriptor
            {
                OPEN_PAREN87 = (Token) match(input, OPEN_PAREN, FOLLOW_OPEN_PAREN_in_method_prototype2247);
                stream_OPEN_PAREN.add(OPEN_PAREN87);

                pushFollow(FOLLOW_param_list_in_method_prototype2249);
                param_list88 = param_list();
                state._fsp--;

                stream_param_list.add(param_list88.getTree());
                CLOSE_PAREN89 = (Token) match(input, CLOSE_PAREN, FOLLOW_CLOSE_PAREN_in_method_prototype2251);
                stream_CLOSE_PAREN.add(CLOSE_PAREN89);

                pushFollow(FOLLOW_type_descriptor_in_method_prototype2253);
                type_descriptor90 = type_descriptor();
                state._fsp--;

                stream_type_descriptor.add(type_descriptor90.getTree());
                // AST REWRITE
                // elements: type_descriptor, param_list
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 586:5: -> ^( I_METHOD_PROTOTYPE[$start, \"I_METHOD_PROTOTYPE\"] ^( I_METHOD_RETURN_TYPE type_descriptor ) ( param_list )? )
                {
                    // smaliParser.g:586:8: ^( I_METHOD_PROTOTYPE[$start, \"I_METHOD_PROTOTYPE\"] ^( I_METHOD_RETURN_TYPE type_descriptor ) ( param_list )? )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_METHOD_PROTOTYPE, (retval.start), "I_METHOD_PROTOTYPE"), root_1);
                        // smaliParser.g:586:59: ^( I_METHOD_RETURN_TYPE type_descriptor )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_METHOD_RETURN_TYPE, "I_METHOD_RETURN_TYPE"), root_2);
                            adaptor.addChild(root_2, stream_type_descriptor.nextTree());
                            adaptor.addChild(root_1, root_2);
                        }

                        // smaliParser.g:586:99: ( param_list )?
                        if (stream_param_list.hasNext()) {
                            adaptor.addChild(root_1, stream_param_list.nextTree());
                        }
                        stream_param_list.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "method_prototype"


    public static class param_list_or_id_primitive_type_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "param_list_or_id_primitive_type"
    // smaliParser.g:588:1: param_list_or_id_primitive_type : PARAM_LIST_OR_ID_PRIMITIVE_TYPE -> PRIMITIVE_TYPE[$PARAM_LIST_OR_ID_PRIMITIVE_TYPE] ;
    public final smaliParser.param_list_or_id_primitive_type_return param_list_or_id_primitive_type() throws RecognitionException {
        smaliParser.param_list_or_id_primitive_type_return retval = new smaliParser.param_list_or_id_primitive_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PARAM_LIST_OR_ID_PRIMITIVE_TYPE91 = null;

        CommonTree PARAM_LIST_OR_ID_PRIMITIVE_TYPE91_tree = null;
        RewriteRuleTokenStream stream_PARAM_LIST_OR_ID_PRIMITIVE_TYPE = new RewriteRuleTokenStream(adaptor, "token PARAM_LIST_OR_ID_PRIMITIVE_TYPE");

        try {
            // smaliParser.g:589:3: ( PARAM_LIST_OR_ID_PRIMITIVE_TYPE -> PRIMITIVE_TYPE[$PARAM_LIST_OR_ID_PRIMITIVE_TYPE] )
            // smaliParser.g:589:5: PARAM_LIST_OR_ID_PRIMITIVE_TYPE
            {
                PARAM_LIST_OR_ID_PRIMITIVE_TYPE91 = (Token) match(input, PARAM_LIST_OR_ID_PRIMITIVE_TYPE, FOLLOW_PARAM_LIST_OR_ID_PRIMITIVE_TYPE_in_param_list_or_id_primitive_type2283);
                stream_PARAM_LIST_OR_ID_PRIMITIVE_TYPE.add(PARAM_LIST_OR_ID_PRIMITIVE_TYPE91);

                // AST REWRITE
                // elements:
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 589:37: -> PRIMITIVE_TYPE[$PARAM_LIST_OR_ID_PRIMITIVE_TYPE]
                {
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(PRIMITIVE_TYPE, PARAM_LIST_OR_ID_PRIMITIVE_TYPE91));
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "param_list_or_id_primitive_type"


    public static class param_list_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "param_list"
    // smaliParser.g:591:1: param_list : ( ( param_list_or_id_primitive_type )+ | ( nonvoid_type_descriptor )* );
    public final smaliParser.param_list_return param_list() throws RecognitionException {
        smaliParser.param_list_return retval = new smaliParser.param_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope param_list_or_id_primitive_type92 = null;
        ParserRuleReturnScope nonvoid_type_descriptor93 = null;


        try {
            // smaliParser.g:592:3: ( ( param_list_or_id_primitive_type )+ | ( nonvoid_type_descriptor )* )
            int alt14 = 2;
            int LA14_0 = input.LA(1);
            if ((LA14_0 == PARAM_LIST_OR_ID_PRIMITIVE_TYPE)) {
                alt14 = 1;
            } else if ((LA14_0 == ARRAY_TYPE_PREFIX || LA14_0 == CLASS_DESCRIPTOR || LA14_0 == CLOSE_PAREN || LA14_0 == PRIMITIVE_TYPE)) {
                alt14 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 14, 0, input);
                throw nvae;
            }

            switch (alt14) {
                case 1:
                    // smaliParser.g:592:5: ( param_list_or_id_primitive_type )+
                {
                    root_0 = (CommonTree) adaptor.nil();


                    // smaliParser.g:592:5: ( param_list_or_id_primitive_type )+
                    int cnt12 = 0;
                    loop12:
                    while (true) {
                        int alt12 = 2;
                        int LA12_0 = input.LA(1);
                        if ((LA12_0 == PARAM_LIST_OR_ID_PRIMITIVE_TYPE)) {
                            alt12 = 1;
                        }

                        switch (alt12) {
                            case 1:
                                // smaliParser.g:592:5: param_list_or_id_primitive_type
                            {
                                pushFollow(FOLLOW_param_list_or_id_primitive_type_in_param_list2298);
                                param_list_or_id_primitive_type92 = param_list_or_id_primitive_type();
                                state._fsp--;

                                adaptor.addChild(root_0, param_list_or_id_primitive_type92.getTree());

                            }
                            break;

                            default:
                                if (cnt12 >= 1) break loop12;
                                EarlyExitException eee = new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    }

                }
                break;
                case 2:
                    // smaliParser.g:593:5: ( nonvoid_type_descriptor )*
                {
                    root_0 = (CommonTree) adaptor.nil();


                    // smaliParser.g:593:5: ( nonvoid_type_descriptor )*
                    loop13:
                    while (true) {
                        int alt13 = 2;
                        int LA13_0 = input.LA(1);
                        if ((LA13_0 == ARRAY_TYPE_PREFIX || LA13_0 == CLASS_DESCRIPTOR || LA13_0 == PRIMITIVE_TYPE)) {
                            alt13 = 1;
                        }

                        switch (alt13) {
                            case 1:
                                // smaliParser.g:593:5: nonvoid_type_descriptor
                            {
                                pushFollow(FOLLOW_nonvoid_type_descriptor_in_param_list2305);
                                nonvoid_type_descriptor93 = nonvoid_type_descriptor();
                                state._fsp--;

                                adaptor.addChild(root_0, nonvoid_type_descriptor93.getTree());

                            }
                            break;

                            default:
                                break loop13;
                        }
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "param_list"


    public static class array_descriptor_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "array_descriptor"
    // smaliParser.g:595:1: array_descriptor : ARRAY_TYPE_PREFIX ( PRIMITIVE_TYPE | CLASS_DESCRIPTOR ) ;
    public final smaliParser.array_descriptor_return array_descriptor() throws RecognitionException {
        smaliParser.array_descriptor_return retval = new smaliParser.array_descriptor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARRAY_TYPE_PREFIX94 = null;
        Token set95 = null;

        CommonTree ARRAY_TYPE_PREFIX94_tree = null;
        CommonTree set95_tree = null;

        try {
            // smaliParser.g:596:3: ( ARRAY_TYPE_PREFIX ( PRIMITIVE_TYPE | CLASS_DESCRIPTOR ) )
            // smaliParser.g:596:5: ARRAY_TYPE_PREFIX ( PRIMITIVE_TYPE | CLASS_DESCRIPTOR )
            {
                root_0 = (CommonTree) adaptor.nil();


                ARRAY_TYPE_PREFIX94 = (Token) match(input, ARRAY_TYPE_PREFIX, FOLLOW_ARRAY_TYPE_PREFIX_in_array_descriptor2316);
                ARRAY_TYPE_PREFIX94_tree = (CommonTree) adaptor.create(ARRAY_TYPE_PREFIX94);
                adaptor.addChild(root_0, ARRAY_TYPE_PREFIX94_tree);

                set95 = input.LT(1);
                if (input.LA(1) == CLASS_DESCRIPTOR || input.LA(1) == PRIMITIVE_TYPE) {
                    input.consume();
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(set95));
                    state.errorRecovery = false;
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_descriptor"


    public static class type_descriptor_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "type_descriptor"
    // smaliParser.g:598:1: type_descriptor : ( VOID_TYPE | PRIMITIVE_TYPE | CLASS_DESCRIPTOR | array_descriptor );
    public final smaliParser.type_descriptor_return type_descriptor() throws RecognitionException {
        smaliParser.type_descriptor_return retval = new smaliParser.type_descriptor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOID_TYPE96 = null;
        Token PRIMITIVE_TYPE97 = null;
        Token CLASS_DESCRIPTOR98 = null;
        ParserRuleReturnScope array_descriptor99 = null;

        CommonTree VOID_TYPE96_tree = null;
        CommonTree PRIMITIVE_TYPE97_tree = null;
        CommonTree CLASS_DESCRIPTOR98_tree = null;

        try {
            // smaliParser.g:599:3: ( VOID_TYPE | PRIMITIVE_TYPE | CLASS_DESCRIPTOR | array_descriptor )
            int alt15 = 4;
            switch (input.LA(1)) {
                case VOID_TYPE: {
                    alt15 = 1;
                }
                break;
                case PRIMITIVE_TYPE: {
                    alt15 = 2;
                }
                break;
                case CLASS_DESCRIPTOR: {
                    alt15 = 3;
                }
                break;
                case ARRAY_TYPE_PREFIX: {
                    alt15 = 4;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);
                    throw nvae;
            }
            switch (alt15) {
                case 1:
                    // smaliParser.g:599:5: VOID_TYPE
                {
                    root_0 = (CommonTree) adaptor.nil();


                    VOID_TYPE96 = (Token) match(input, VOID_TYPE, FOLLOW_VOID_TYPE_in_type_descriptor2334);
                    VOID_TYPE96_tree = (CommonTree) adaptor.create(VOID_TYPE96);
                    adaptor.addChild(root_0, VOID_TYPE96_tree);

                }
                break;
                case 2:
                    // smaliParser.g:600:5: PRIMITIVE_TYPE
                {
                    root_0 = (CommonTree) adaptor.nil();


                    PRIMITIVE_TYPE97 = (Token) match(input, PRIMITIVE_TYPE, FOLLOW_PRIMITIVE_TYPE_in_type_descriptor2340);
                    PRIMITIVE_TYPE97_tree = (CommonTree) adaptor.create(PRIMITIVE_TYPE97);
                    adaptor.addChild(root_0, PRIMITIVE_TYPE97_tree);

                }
                break;
                case 3:
                    // smaliParser.g:601:5: CLASS_DESCRIPTOR
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CLASS_DESCRIPTOR98 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_type_descriptor2346);
                    CLASS_DESCRIPTOR98_tree = (CommonTree) adaptor.create(CLASS_DESCRIPTOR98);
                    adaptor.addChild(root_0, CLASS_DESCRIPTOR98_tree);

                }
                break;
                case 4:
                    // smaliParser.g:602:5: array_descriptor
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_array_descriptor_in_type_descriptor2352);
                    array_descriptor99 = array_descriptor();
                    state._fsp--;

                    adaptor.addChild(root_0, array_descriptor99.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_descriptor"


    public static class nonvoid_type_descriptor_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "nonvoid_type_descriptor"
    // smaliParser.g:604:1: nonvoid_type_descriptor : ( PRIMITIVE_TYPE | CLASS_DESCRIPTOR | array_descriptor );
    public final smaliParser.nonvoid_type_descriptor_return nonvoid_type_descriptor() throws RecognitionException {
        smaliParser.nonvoid_type_descriptor_return retval = new smaliParser.nonvoid_type_descriptor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRIMITIVE_TYPE100 = null;
        Token CLASS_DESCRIPTOR101 = null;
        ParserRuleReturnScope array_descriptor102 = null;

        CommonTree PRIMITIVE_TYPE100_tree = null;
        CommonTree CLASS_DESCRIPTOR101_tree = null;

        try {
            // smaliParser.g:605:3: ( PRIMITIVE_TYPE | CLASS_DESCRIPTOR | array_descriptor )
            int alt16 = 3;
            switch (input.LA(1)) {
                case PRIMITIVE_TYPE: {
                    alt16 = 1;
                }
                break;
                case CLASS_DESCRIPTOR: {
                    alt16 = 2;
                }
                break;
                case ARRAY_TYPE_PREFIX: {
                    alt16 = 3;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);
                    throw nvae;
            }
            switch (alt16) {
                case 1:
                    // smaliParser.g:605:5: PRIMITIVE_TYPE
                {
                    root_0 = (CommonTree) adaptor.nil();


                    PRIMITIVE_TYPE100 = (Token) match(input, PRIMITIVE_TYPE, FOLLOW_PRIMITIVE_TYPE_in_nonvoid_type_descriptor2362);
                    PRIMITIVE_TYPE100_tree = (CommonTree) adaptor.create(PRIMITIVE_TYPE100);
                    adaptor.addChild(root_0, PRIMITIVE_TYPE100_tree);

                }
                break;
                case 2:
                    // smaliParser.g:606:5: CLASS_DESCRIPTOR
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CLASS_DESCRIPTOR101 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_nonvoid_type_descriptor2368);
                    CLASS_DESCRIPTOR101_tree = (CommonTree) adaptor.create(CLASS_DESCRIPTOR101);
                    adaptor.addChild(root_0, CLASS_DESCRIPTOR101_tree);

                }
                break;
                case 3:
                    // smaliParser.g:607:5: array_descriptor
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_array_descriptor_in_nonvoid_type_descriptor2374);
                    array_descriptor102 = array_descriptor();
                    state._fsp--;

                    adaptor.addChild(root_0, array_descriptor102.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nonvoid_type_descriptor"


    public static class reference_type_descriptor_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "reference_type_descriptor"
    // smaliParser.g:609:1: reference_type_descriptor : ( CLASS_DESCRIPTOR | array_descriptor );
    public final smaliParser.reference_type_descriptor_return reference_type_descriptor() throws RecognitionException {
        smaliParser.reference_type_descriptor_return retval = new smaliParser.reference_type_descriptor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CLASS_DESCRIPTOR103 = null;
        ParserRuleReturnScope array_descriptor104 = null;

        CommonTree CLASS_DESCRIPTOR103_tree = null;

        try {
            // smaliParser.g:610:3: ( CLASS_DESCRIPTOR | array_descriptor )
            int alt17 = 2;
            int LA17_0 = input.LA(1);
            if ((LA17_0 == CLASS_DESCRIPTOR)) {
                alt17 = 1;
            } else if ((LA17_0 == ARRAY_TYPE_PREFIX)) {
                alt17 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 17, 0, input);
                throw nvae;
            }

            switch (alt17) {
                case 1:
                    // smaliParser.g:610:5: CLASS_DESCRIPTOR
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CLASS_DESCRIPTOR103 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_reference_type_descriptor2384);
                    CLASS_DESCRIPTOR103_tree = (CommonTree) adaptor.create(CLASS_DESCRIPTOR103);
                    adaptor.addChild(root_0, CLASS_DESCRIPTOR103_tree);

                }
                break;
                case 2:
                    // smaliParser.g:611:5: array_descriptor
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_array_descriptor_in_reference_type_descriptor2390);
                    array_descriptor104 = array_descriptor();
                    state._fsp--;

                    adaptor.addChild(root_0, array_descriptor104.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "reference_type_descriptor"


    public static class integer_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "integer_literal"
    // smaliParser.g:613:1: integer_literal : ( POSITIVE_INTEGER_LITERAL -> INTEGER_LITERAL[$POSITIVE_INTEGER_LITERAL] | NEGATIVE_INTEGER_LITERAL -> INTEGER_LITERAL[$NEGATIVE_INTEGER_LITERAL] );
    public final smaliParser.integer_literal_return integer_literal() throws RecognitionException {
        smaliParser.integer_literal_return retval = new smaliParser.integer_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POSITIVE_INTEGER_LITERAL105 = null;
        Token NEGATIVE_INTEGER_LITERAL106 = null;

        CommonTree POSITIVE_INTEGER_LITERAL105_tree = null;
        CommonTree NEGATIVE_INTEGER_LITERAL106_tree = null;
        RewriteRuleTokenStream stream_NEGATIVE_INTEGER_LITERAL = new RewriteRuleTokenStream(adaptor, "token NEGATIVE_INTEGER_LITERAL");
        RewriteRuleTokenStream stream_POSITIVE_INTEGER_LITERAL = new RewriteRuleTokenStream(adaptor, "token POSITIVE_INTEGER_LITERAL");

        try {
            // smaliParser.g:614:3: ( POSITIVE_INTEGER_LITERAL -> INTEGER_LITERAL[$POSITIVE_INTEGER_LITERAL] | NEGATIVE_INTEGER_LITERAL -> INTEGER_LITERAL[$NEGATIVE_INTEGER_LITERAL] )
            int alt18 = 2;
            int LA18_0 = input.LA(1);
            if ((LA18_0 == POSITIVE_INTEGER_LITERAL)) {
                alt18 = 1;
            } else if ((LA18_0 == NEGATIVE_INTEGER_LITERAL)) {
                alt18 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 18, 0, input);
                throw nvae;
            }

            switch (alt18) {
                case 1:
                    // smaliParser.g:614:5: POSITIVE_INTEGER_LITERAL
                {
                    POSITIVE_INTEGER_LITERAL105 = (Token) match(input, POSITIVE_INTEGER_LITERAL, FOLLOW_POSITIVE_INTEGER_LITERAL_in_integer_literal2400);
                    stream_POSITIVE_INTEGER_LITERAL.add(POSITIVE_INTEGER_LITERAL105);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 614:30: -> INTEGER_LITERAL[$POSITIVE_INTEGER_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(INTEGER_LITERAL, POSITIVE_INTEGER_LITERAL105));
                    }


                    retval.tree = root_0;

                }
                break;
                case 2:
                    // smaliParser.g:615:5: NEGATIVE_INTEGER_LITERAL
                {
                    NEGATIVE_INTEGER_LITERAL106 = (Token) match(input, NEGATIVE_INTEGER_LITERAL, FOLLOW_NEGATIVE_INTEGER_LITERAL_in_integer_literal2411);
                    stream_NEGATIVE_INTEGER_LITERAL.add(NEGATIVE_INTEGER_LITERAL106);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 615:30: -> INTEGER_LITERAL[$NEGATIVE_INTEGER_LITERAL]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(INTEGER_LITERAL, NEGATIVE_INTEGER_LITERAL106));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "integer_literal"


    public static class float_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "float_literal"
    // smaliParser.g:617:1: float_literal : ( FLOAT_LITERAL_OR_ID -> FLOAT_LITERAL[$FLOAT_LITERAL_OR_ID] | FLOAT_LITERAL );
    public final smaliParser.float_literal_return float_literal() throws RecognitionException {
        smaliParser.float_literal_return retval = new smaliParser.float_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FLOAT_LITERAL_OR_ID107 = null;
        Token FLOAT_LITERAL108 = null;

        CommonTree FLOAT_LITERAL_OR_ID107_tree = null;
        CommonTree FLOAT_LITERAL108_tree = null;
        RewriteRuleTokenStream stream_FLOAT_LITERAL_OR_ID = new RewriteRuleTokenStream(adaptor, "token FLOAT_LITERAL_OR_ID");

        try {
            // smaliParser.g:618:3: ( FLOAT_LITERAL_OR_ID -> FLOAT_LITERAL[$FLOAT_LITERAL_OR_ID] | FLOAT_LITERAL )
            int alt19 = 2;
            int LA19_0 = input.LA(1);
            if ((LA19_0 == FLOAT_LITERAL_OR_ID)) {
                alt19 = 1;
            } else if ((LA19_0 == FLOAT_LITERAL)) {
                alt19 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 19, 0, input);
                throw nvae;
            }

            switch (alt19) {
                case 1:
                    // smaliParser.g:618:5: FLOAT_LITERAL_OR_ID
                {
                    FLOAT_LITERAL_OR_ID107 = (Token) match(input, FLOAT_LITERAL_OR_ID, FOLLOW_FLOAT_LITERAL_OR_ID_in_float_literal2426);
                    stream_FLOAT_LITERAL_OR_ID.add(FLOAT_LITERAL_OR_ID107);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 618:25: -> FLOAT_LITERAL[$FLOAT_LITERAL_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(FLOAT_LITERAL, FLOAT_LITERAL_OR_ID107));
                    }


                    retval.tree = root_0;

                }
                break;
                case 2:
                    // smaliParser.g:619:5: FLOAT_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    FLOAT_LITERAL108 = (Token) match(input, FLOAT_LITERAL, FOLLOW_FLOAT_LITERAL_in_float_literal2437);
                    FLOAT_LITERAL108_tree = (CommonTree) adaptor.create(FLOAT_LITERAL108);
                    adaptor.addChild(root_0, FLOAT_LITERAL108_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "float_literal"


    public static class double_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "double_literal"
    // smaliParser.g:621:1: double_literal : ( DOUBLE_LITERAL_OR_ID -> DOUBLE_LITERAL[$DOUBLE_LITERAL_OR_ID] | DOUBLE_LITERAL );
    public final smaliParser.double_literal_return double_literal() throws RecognitionException {
        smaliParser.double_literal_return retval = new smaliParser.double_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOUBLE_LITERAL_OR_ID109 = null;
        Token DOUBLE_LITERAL110 = null;

        CommonTree DOUBLE_LITERAL_OR_ID109_tree = null;
        CommonTree DOUBLE_LITERAL110_tree = null;
        RewriteRuleTokenStream stream_DOUBLE_LITERAL_OR_ID = new RewriteRuleTokenStream(adaptor, "token DOUBLE_LITERAL_OR_ID");

        try {
            // smaliParser.g:622:3: ( DOUBLE_LITERAL_OR_ID -> DOUBLE_LITERAL[$DOUBLE_LITERAL_OR_ID] | DOUBLE_LITERAL )
            int alt20 = 2;
            int LA20_0 = input.LA(1);
            if ((LA20_0 == DOUBLE_LITERAL_OR_ID)) {
                alt20 = 1;
            } else if ((LA20_0 == DOUBLE_LITERAL)) {
                alt20 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 20, 0, input);
                throw nvae;
            }

            switch (alt20) {
                case 1:
                    // smaliParser.g:622:5: DOUBLE_LITERAL_OR_ID
                {
                    DOUBLE_LITERAL_OR_ID109 = (Token) match(input, DOUBLE_LITERAL_OR_ID, FOLLOW_DOUBLE_LITERAL_OR_ID_in_double_literal2447);
                    stream_DOUBLE_LITERAL_OR_ID.add(DOUBLE_LITERAL_OR_ID109);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 622:26: -> DOUBLE_LITERAL[$DOUBLE_LITERAL_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(DOUBLE_LITERAL, DOUBLE_LITERAL_OR_ID109));
                    }


                    retval.tree = root_0;

                }
                break;
                case 2:
                    // smaliParser.g:623:5: DOUBLE_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    DOUBLE_LITERAL110 = (Token) match(input, DOUBLE_LITERAL, FOLLOW_DOUBLE_LITERAL_in_double_literal2458);
                    DOUBLE_LITERAL110_tree = (CommonTree) adaptor.create(DOUBLE_LITERAL110);
                    adaptor.addChild(root_0, DOUBLE_LITERAL110_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "double_literal"


    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "literal"
    // smaliParser.g:625:1: literal : ( LONG_LITERAL | integer_literal | SHORT_LITERAL | BYTE_LITERAL | float_literal | double_literal | CHAR_LITERAL | STRING_LITERAL | BOOL_LITERAL | NULL_LITERAL | array_literal | subannotation | type_field_method_literal | enum_literal );
    public final smaliParser.literal_return literal() throws RecognitionException {
        smaliParser.literal_return retval = new smaliParser.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LONG_LITERAL111 = null;
        Token SHORT_LITERAL113 = null;
        Token BYTE_LITERAL114 = null;
        Token CHAR_LITERAL117 = null;
        Token STRING_LITERAL118 = null;
        Token BOOL_LITERAL119 = null;
        Token NULL_LITERAL120 = null;
        ParserRuleReturnScope integer_literal112 = null;
        ParserRuleReturnScope float_literal115 = null;
        ParserRuleReturnScope double_literal116 = null;
        ParserRuleReturnScope array_literal121 = null;
        ParserRuleReturnScope subannotation122 = null;
        ParserRuleReturnScope type_field_method_literal123 = null;
        ParserRuleReturnScope enum_literal124 = null;

        CommonTree LONG_LITERAL111_tree = null;
        CommonTree SHORT_LITERAL113_tree = null;
        CommonTree BYTE_LITERAL114_tree = null;
        CommonTree CHAR_LITERAL117_tree = null;
        CommonTree STRING_LITERAL118_tree = null;
        CommonTree BOOL_LITERAL119_tree = null;
        CommonTree NULL_LITERAL120_tree = null;

        try {
            // smaliParser.g:626:3: ( LONG_LITERAL | integer_literal | SHORT_LITERAL | BYTE_LITERAL | float_literal | double_literal | CHAR_LITERAL | STRING_LITERAL | BOOL_LITERAL | NULL_LITERAL | array_literal | subannotation | type_field_method_literal | enum_literal )
            int alt21 = 14;
            switch (input.LA(1)) {
                case LONG_LITERAL: {
                    alt21 = 1;
                }
                break;
                case POSITIVE_INTEGER_LITERAL: {
                    int LA21_2 = input.LA(2);
                    if ((LA21_2 == EOF || (LA21_2 >= ACCESS_SPEC && LA21_2 <= ANNOTATION_VISIBILITY) || LA21_2 == BOOL_LITERAL || (LA21_2 >= CLASS_DIRECTIVE && LA21_2 <= CLOSE_BRACE) || LA21_2 == COMMA || (LA21_2 >= DOUBLE_LITERAL_OR_ID && LA21_2 <= END_ANNOTATION_DIRECTIVE) || LA21_2 == END_FIELD_DIRECTIVE || LA21_2 == END_SUBANNOTATION_DIRECTIVE || LA21_2 == FIELD_DIRECTIVE || (LA21_2 >= FLOAT_LITERAL_OR_ID && LA21_2 <= IMPLEMENTS_DIRECTIVE) || (LA21_2 >= INSTRUCTION_FORMAT10t && LA21_2 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_2 == INSTRUCTION_FORMAT11x || LA21_2 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_2 >= INSTRUCTION_FORMAT21c_FIELD && LA21_2 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_2 == INSTRUCTION_FORMAT21t || (LA21_2 >= INSTRUCTION_FORMAT22c_FIELD && LA21_2 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_2 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_2 <= INSTRUCTION_FORMAT22t) || LA21_2 == INSTRUCTION_FORMAT23x || (LA21_2 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_2 <= INSTRUCTION_FORMAT31t) || (LA21_2 >= INSTRUCTION_FORMAT35c_METHOD && LA21_2 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_2 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_2 <= INSTRUCTION_FORMAT51l) || (LA21_2 >= METHOD_DIRECTIVE && LA21_2 <= NULL_LITERAL) || (LA21_2 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_2 <= PRIMITIVE_TYPE) || LA21_2 == REGISTER || (LA21_2 >= SIMPLE_NAME && LA21_2 <= SOURCE_DIRECTIVE) || (LA21_2 >= SUPER_DIRECTIVE && LA21_2 <= VOID_TYPE))) {
                        alt21 = 2;
                    } else if ((LA21_2 == COLON || LA21_2 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 2, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case NEGATIVE_INTEGER_LITERAL: {
                    int LA21_3 = input.LA(2);
                    if ((LA21_3 == EOF || (LA21_3 >= ACCESS_SPEC && LA21_3 <= ANNOTATION_VISIBILITY) || LA21_3 == BOOL_LITERAL || (LA21_3 >= CLASS_DIRECTIVE && LA21_3 <= CLOSE_BRACE) || LA21_3 == COMMA || (LA21_3 >= DOUBLE_LITERAL_OR_ID && LA21_3 <= END_ANNOTATION_DIRECTIVE) || LA21_3 == END_FIELD_DIRECTIVE || LA21_3 == END_SUBANNOTATION_DIRECTIVE || LA21_3 == FIELD_DIRECTIVE || (LA21_3 >= FLOAT_LITERAL_OR_ID && LA21_3 <= IMPLEMENTS_DIRECTIVE) || (LA21_3 >= INSTRUCTION_FORMAT10t && LA21_3 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_3 == INSTRUCTION_FORMAT11x || LA21_3 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_3 >= INSTRUCTION_FORMAT21c_FIELD && LA21_3 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_3 == INSTRUCTION_FORMAT21t || (LA21_3 >= INSTRUCTION_FORMAT22c_FIELD && LA21_3 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_3 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_3 <= INSTRUCTION_FORMAT22t) || LA21_3 == INSTRUCTION_FORMAT23x || (LA21_3 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_3 <= INSTRUCTION_FORMAT31t) || (LA21_3 >= INSTRUCTION_FORMAT35c_METHOD && LA21_3 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_3 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_3 <= INSTRUCTION_FORMAT51l) || (LA21_3 >= METHOD_DIRECTIVE && LA21_3 <= NULL_LITERAL) || (LA21_3 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_3 <= PRIMITIVE_TYPE) || LA21_3 == REGISTER || (LA21_3 >= SIMPLE_NAME && LA21_3 <= SOURCE_DIRECTIVE) || (LA21_3 >= SUPER_DIRECTIVE && LA21_3 <= VOID_TYPE))) {
                        alt21 = 2;
                    } else if ((LA21_3 == COLON || LA21_3 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 3, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case SHORT_LITERAL: {
                    alt21 = 3;
                }
                break;
                case BYTE_LITERAL: {
                    alt21 = 4;
                }
                break;
                case FLOAT_LITERAL_OR_ID: {
                    int LA21_6 = input.LA(2);
                    if ((LA21_6 == EOF || (LA21_6 >= ACCESS_SPEC && LA21_6 <= ANNOTATION_VISIBILITY) || LA21_6 == BOOL_LITERAL || (LA21_6 >= CLASS_DIRECTIVE && LA21_6 <= CLOSE_BRACE) || LA21_6 == COMMA || (LA21_6 >= DOUBLE_LITERAL_OR_ID && LA21_6 <= END_ANNOTATION_DIRECTIVE) || LA21_6 == END_FIELD_DIRECTIVE || LA21_6 == END_SUBANNOTATION_DIRECTIVE || LA21_6 == FIELD_DIRECTIVE || (LA21_6 >= FLOAT_LITERAL_OR_ID && LA21_6 <= IMPLEMENTS_DIRECTIVE) || (LA21_6 >= INSTRUCTION_FORMAT10t && LA21_6 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_6 == INSTRUCTION_FORMAT11x || LA21_6 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_6 >= INSTRUCTION_FORMAT21c_FIELD && LA21_6 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_6 == INSTRUCTION_FORMAT21t || (LA21_6 >= INSTRUCTION_FORMAT22c_FIELD && LA21_6 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_6 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_6 <= INSTRUCTION_FORMAT22t) || LA21_6 == INSTRUCTION_FORMAT23x || (LA21_6 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_6 <= INSTRUCTION_FORMAT31t) || (LA21_6 >= INSTRUCTION_FORMAT35c_METHOD && LA21_6 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_6 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_6 <= INSTRUCTION_FORMAT51l) || (LA21_6 >= METHOD_DIRECTIVE && LA21_6 <= NULL_LITERAL) || (LA21_6 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_6 <= PRIMITIVE_TYPE) || LA21_6 == REGISTER || (LA21_6 >= SIMPLE_NAME && LA21_6 <= SOURCE_DIRECTIVE) || (LA21_6 >= SUPER_DIRECTIVE && LA21_6 <= VOID_TYPE))) {
                        alt21 = 5;
                    } else if ((LA21_6 == COLON || LA21_6 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 6, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case FLOAT_LITERAL: {
                    alt21 = 5;
                }
                break;
                case DOUBLE_LITERAL_OR_ID: {
                    int LA21_8 = input.LA(2);
                    if ((LA21_8 == EOF || (LA21_8 >= ACCESS_SPEC && LA21_8 <= ANNOTATION_VISIBILITY) || LA21_8 == BOOL_LITERAL || (LA21_8 >= CLASS_DIRECTIVE && LA21_8 <= CLOSE_BRACE) || LA21_8 == COMMA || (LA21_8 >= DOUBLE_LITERAL_OR_ID && LA21_8 <= END_ANNOTATION_DIRECTIVE) || LA21_8 == END_FIELD_DIRECTIVE || LA21_8 == END_SUBANNOTATION_DIRECTIVE || LA21_8 == FIELD_DIRECTIVE || (LA21_8 >= FLOAT_LITERAL_OR_ID && LA21_8 <= IMPLEMENTS_DIRECTIVE) || (LA21_8 >= INSTRUCTION_FORMAT10t && LA21_8 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_8 == INSTRUCTION_FORMAT11x || LA21_8 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_8 >= INSTRUCTION_FORMAT21c_FIELD && LA21_8 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_8 == INSTRUCTION_FORMAT21t || (LA21_8 >= INSTRUCTION_FORMAT22c_FIELD && LA21_8 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_8 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_8 <= INSTRUCTION_FORMAT22t) || LA21_8 == INSTRUCTION_FORMAT23x || (LA21_8 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_8 <= INSTRUCTION_FORMAT31t) || (LA21_8 >= INSTRUCTION_FORMAT35c_METHOD && LA21_8 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_8 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_8 <= INSTRUCTION_FORMAT51l) || (LA21_8 >= METHOD_DIRECTIVE && LA21_8 <= NULL_LITERAL) || (LA21_8 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_8 <= PRIMITIVE_TYPE) || LA21_8 == REGISTER || (LA21_8 >= SIMPLE_NAME && LA21_8 <= SOURCE_DIRECTIVE) || (LA21_8 >= SUPER_DIRECTIVE && LA21_8 <= VOID_TYPE))) {
                        alt21 = 6;
                    } else if ((LA21_8 == COLON || LA21_8 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 8, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case DOUBLE_LITERAL: {
                    alt21 = 6;
                }
                break;
                case CHAR_LITERAL: {
                    alt21 = 7;
                }
                break;
                case STRING_LITERAL: {
                    alt21 = 8;
                }
                break;
                case BOOL_LITERAL: {
                    int LA21_12 = input.LA(2);
                    if ((LA21_12 == EOF || (LA21_12 >= ACCESS_SPEC && LA21_12 <= ANNOTATION_VISIBILITY) || LA21_12 == BOOL_LITERAL || (LA21_12 >= CLASS_DIRECTIVE && LA21_12 <= CLOSE_BRACE) || LA21_12 == COMMA || (LA21_12 >= DOUBLE_LITERAL_OR_ID && LA21_12 <= END_ANNOTATION_DIRECTIVE) || LA21_12 == END_FIELD_DIRECTIVE || LA21_12 == END_SUBANNOTATION_DIRECTIVE || LA21_12 == FIELD_DIRECTIVE || (LA21_12 >= FLOAT_LITERAL_OR_ID && LA21_12 <= IMPLEMENTS_DIRECTIVE) || (LA21_12 >= INSTRUCTION_FORMAT10t && LA21_12 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_12 == INSTRUCTION_FORMAT11x || LA21_12 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_12 >= INSTRUCTION_FORMAT21c_FIELD && LA21_12 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_12 == INSTRUCTION_FORMAT21t || (LA21_12 >= INSTRUCTION_FORMAT22c_FIELD && LA21_12 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_12 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_12 <= INSTRUCTION_FORMAT22t) || LA21_12 == INSTRUCTION_FORMAT23x || (LA21_12 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_12 <= INSTRUCTION_FORMAT31t) || (LA21_12 >= INSTRUCTION_FORMAT35c_METHOD && LA21_12 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_12 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_12 <= INSTRUCTION_FORMAT51l) || (LA21_12 >= METHOD_DIRECTIVE && LA21_12 <= NULL_LITERAL) || (LA21_12 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_12 <= PRIMITIVE_TYPE) || LA21_12 == REGISTER || (LA21_12 >= SIMPLE_NAME && LA21_12 <= SOURCE_DIRECTIVE) || (LA21_12 >= SUPER_DIRECTIVE && LA21_12 <= VOID_TYPE))) {
                        alt21 = 9;
                    } else if ((LA21_12 == COLON || LA21_12 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 12, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case NULL_LITERAL: {
                    int LA21_13 = input.LA(2);
                    if ((LA21_13 == EOF || (LA21_13 >= ACCESS_SPEC && LA21_13 <= ANNOTATION_VISIBILITY) || LA21_13 == BOOL_LITERAL || (LA21_13 >= CLASS_DIRECTIVE && LA21_13 <= CLOSE_BRACE) || LA21_13 == COMMA || (LA21_13 >= DOUBLE_LITERAL_OR_ID && LA21_13 <= END_ANNOTATION_DIRECTIVE) || LA21_13 == END_FIELD_DIRECTIVE || LA21_13 == END_SUBANNOTATION_DIRECTIVE || LA21_13 == FIELD_DIRECTIVE || (LA21_13 >= FLOAT_LITERAL_OR_ID && LA21_13 <= IMPLEMENTS_DIRECTIVE) || (LA21_13 >= INSTRUCTION_FORMAT10t && LA21_13 <= INSTRUCTION_FORMAT10x_ODEX) || LA21_13 == INSTRUCTION_FORMAT11x || LA21_13 == INSTRUCTION_FORMAT12x_OR_ID || (LA21_13 >= INSTRUCTION_FORMAT21c_FIELD && LA21_13 <= INSTRUCTION_FORMAT21c_TYPE) || LA21_13 == INSTRUCTION_FORMAT21t || (LA21_13 >= INSTRUCTION_FORMAT22c_FIELD && LA21_13 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA21_13 >= INSTRUCTION_FORMAT22s_OR_ID && LA21_13 <= INSTRUCTION_FORMAT22t) || LA21_13 == INSTRUCTION_FORMAT23x || (LA21_13 >= INSTRUCTION_FORMAT31i_OR_ID && LA21_13 <= INSTRUCTION_FORMAT31t) || (LA21_13 >= INSTRUCTION_FORMAT35c_METHOD && LA21_13 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA21_13 >= INSTRUCTION_FORMAT45cc_METHOD && LA21_13 <= INSTRUCTION_FORMAT51l) || (LA21_13 >= METHOD_DIRECTIVE && LA21_13 <= NULL_LITERAL) || (LA21_13 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA21_13 <= PRIMITIVE_TYPE) || LA21_13 == REGISTER || (LA21_13 >= SIMPLE_NAME && LA21_13 <= SOURCE_DIRECTIVE) || (LA21_13 >= SUPER_DIRECTIVE && LA21_13 <= VOID_TYPE))) {
                        alt21 = 10;
                    } else if ((LA21_13 == COLON || LA21_13 == OPEN_PAREN)) {
                        alt21 = 13;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 21, 13, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case OPEN_BRACE: {
                    alt21 = 11;
                }
                break;
                case SUBANNOTATION_DIRECTIVE: {
                    alt21 = 12;
                }
                break;
                case ACCESS_SPEC:
                case ANNOTATION_VISIBILITY:
                case ARRAY_TYPE_PREFIX:
                case CLASS_DESCRIPTOR:
                case INSTRUCTION_FORMAT10t:
                case INSTRUCTION_FORMAT10x:
                case INSTRUCTION_FORMAT10x_ODEX:
                case INSTRUCTION_FORMAT11x:
                case INSTRUCTION_FORMAT12x_OR_ID:
                case INSTRUCTION_FORMAT21c_FIELD:
                case INSTRUCTION_FORMAT21c_FIELD_ODEX:
                case INSTRUCTION_FORMAT21c_STRING:
                case INSTRUCTION_FORMAT21c_TYPE:
                case INSTRUCTION_FORMAT21t:
                case INSTRUCTION_FORMAT22c_FIELD:
                case INSTRUCTION_FORMAT22c_FIELD_ODEX:
                case INSTRUCTION_FORMAT22c_TYPE:
                case INSTRUCTION_FORMAT22cs_FIELD:
                case INSTRUCTION_FORMAT22s_OR_ID:
                case INSTRUCTION_FORMAT22t:
                case INSTRUCTION_FORMAT23x:
                case INSTRUCTION_FORMAT31i_OR_ID:
                case INSTRUCTION_FORMAT31t:
                case INSTRUCTION_FORMAT35c_METHOD:
                case INSTRUCTION_FORMAT35c_METHOD_ODEX:
                case INSTRUCTION_FORMAT35c_TYPE:
                case INSTRUCTION_FORMAT35mi_METHOD:
                case INSTRUCTION_FORMAT35ms_METHOD:
                case INSTRUCTION_FORMAT45cc_METHOD:
                case INSTRUCTION_FORMAT4rcc_METHOD:
                case INSTRUCTION_FORMAT51l:
                case MEMBER_NAME:
                case PARAM_LIST_OR_ID_PRIMITIVE_TYPE:
                case PRIMITIVE_TYPE:
                case REGISTER:
                case SIMPLE_NAME:
                case VERIFICATION_ERROR_TYPE:
                case VOID_TYPE: {
                    alt21 = 13;
                }
                break;
                case ENUM_DIRECTIVE: {
                    alt21 = 14;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);
                    throw nvae;
            }
            switch (alt21) {
                case 1:
                    // smaliParser.g:626:5: LONG_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    LONG_LITERAL111 = (Token) match(input, LONG_LITERAL, FOLLOW_LONG_LITERAL_in_literal2468);
                    LONG_LITERAL111_tree = (CommonTree) adaptor.create(LONG_LITERAL111);
                    adaptor.addChild(root_0, LONG_LITERAL111_tree);

                }
                break;
                case 2:
                    // smaliParser.g:627:5: integer_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_integer_literal_in_literal2474);
                    integer_literal112 = integer_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, integer_literal112.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:628:5: SHORT_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    SHORT_LITERAL113 = (Token) match(input, SHORT_LITERAL, FOLLOW_SHORT_LITERAL_in_literal2480);
                    SHORT_LITERAL113_tree = (CommonTree) adaptor.create(SHORT_LITERAL113);
                    adaptor.addChild(root_0, SHORT_LITERAL113_tree);

                }
                break;
                case 4:
                    // smaliParser.g:629:5: BYTE_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BYTE_LITERAL114 = (Token) match(input, BYTE_LITERAL, FOLLOW_BYTE_LITERAL_in_literal2486);
                    BYTE_LITERAL114_tree = (CommonTree) adaptor.create(BYTE_LITERAL114);
                    adaptor.addChild(root_0, BYTE_LITERAL114_tree);

                }
                break;
                case 5:
                    // smaliParser.g:630:5: float_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_float_literal_in_literal2492);
                    float_literal115 = float_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, float_literal115.getTree());

                }
                break;
                case 6:
                    // smaliParser.g:631:5: double_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_double_literal_in_literal2498);
                    double_literal116 = double_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, double_literal116.getTree());

                }
                break;
                case 7:
                    // smaliParser.g:632:5: CHAR_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CHAR_LITERAL117 = (Token) match(input, CHAR_LITERAL, FOLLOW_CHAR_LITERAL_in_literal2504);
                    CHAR_LITERAL117_tree = (CommonTree) adaptor.create(CHAR_LITERAL117);
                    adaptor.addChild(root_0, CHAR_LITERAL117_tree);

                }
                break;
                case 8:
                    // smaliParser.g:633:5: STRING_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    STRING_LITERAL118 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_literal2510);
                    STRING_LITERAL118_tree = (CommonTree) adaptor.create(STRING_LITERAL118);
                    adaptor.addChild(root_0, STRING_LITERAL118_tree);

                }
                break;
                case 9:
                    // smaliParser.g:634:5: BOOL_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BOOL_LITERAL119 = (Token) match(input, BOOL_LITERAL, FOLLOW_BOOL_LITERAL_in_literal2516);
                    BOOL_LITERAL119_tree = (CommonTree) adaptor.create(BOOL_LITERAL119);
                    adaptor.addChild(root_0, BOOL_LITERAL119_tree);

                }
                break;
                case 10:
                    // smaliParser.g:635:5: NULL_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    NULL_LITERAL120 = (Token) match(input, NULL_LITERAL, FOLLOW_NULL_LITERAL_in_literal2522);
                    NULL_LITERAL120_tree = (CommonTree) adaptor.create(NULL_LITERAL120);
                    adaptor.addChild(root_0, NULL_LITERAL120_tree);

                }
                break;
                case 11:
                    // smaliParser.g:636:5: array_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_array_literal_in_literal2528);
                    array_literal121 = array_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, array_literal121.getTree());

                }
                break;
                case 12:
                    // smaliParser.g:637:5: subannotation
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_subannotation_in_literal2534);
                    subannotation122 = subannotation();
                    state._fsp--;

                    adaptor.addChild(root_0, subannotation122.getTree());

                }
                break;
                case 13:
                    // smaliParser.g:638:5: type_field_method_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_type_field_method_literal_in_literal2540);
                    type_field_method_literal123 = type_field_method_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, type_field_method_literal123.getTree());

                }
                break;
                case 14:
                    // smaliParser.g:639:5: enum_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_enum_literal_in_literal2546);
                    enum_literal124 = enum_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, enum_literal124.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class parsed_integer_literal_return extends ParserRuleReturnScope {
        public int value;
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "parsed_integer_literal"
    // smaliParser.g:641:1: parsed_integer_literal returns [int value] : integer_literal ;
    public final smaliParser.parsed_integer_literal_return parsed_integer_literal() throws RecognitionException {
        smaliParser.parsed_integer_literal_return retval = new smaliParser.parsed_integer_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope integer_literal125 = null;


        try {
            // smaliParser.g:642:3: ( integer_literal )
            // smaliParser.g:642:5: integer_literal
            {
                root_0 = (CommonTree) adaptor.nil();


                pushFollow(FOLLOW_integer_literal_in_parsed_integer_literal2559);
                integer_literal125 = integer_literal();
                state._fsp--;

                adaptor.addChild(root_0, integer_literal125.getTree());

                retval.value = LiteralTools.parseInt((integer_literal125 != null ? input.toString(integer_literal125.start, integer_literal125.stop) : null));
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parsed_integer_literal"


    public static class integral_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "integral_literal"
    // smaliParser.g:644:1: integral_literal : ( LONG_LITERAL | integer_literal | SHORT_LITERAL | CHAR_LITERAL | BYTE_LITERAL );
    public final smaliParser.integral_literal_return integral_literal() throws RecognitionException {
        smaliParser.integral_literal_return retval = new smaliParser.integral_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LONG_LITERAL126 = null;
        Token SHORT_LITERAL128 = null;
        Token CHAR_LITERAL129 = null;
        Token BYTE_LITERAL130 = null;
        ParserRuleReturnScope integer_literal127 = null;

        CommonTree LONG_LITERAL126_tree = null;
        CommonTree SHORT_LITERAL128_tree = null;
        CommonTree CHAR_LITERAL129_tree = null;
        CommonTree BYTE_LITERAL130_tree = null;

        try {
            // smaliParser.g:645:3: ( LONG_LITERAL | integer_literal | SHORT_LITERAL | CHAR_LITERAL | BYTE_LITERAL )
            int alt22 = 5;
            switch (input.LA(1)) {
                case LONG_LITERAL: {
                    alt22 = 1;
                }
                break;
                case NEGATIVE_INTEGER_LITERAL:
                case POSITIVE_INTEGER_LITERAL: {
                    alt22 = 2;
                }
                break;
                case SHORT_LITERAL: {
                    alt22 = 3;
                }
                break;
                case CHAR_LITERAL: {
                    alt22 = 4;
                }
                break;
                case BYTE_LITERAL: {
                    alt22 = 5;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);
                    throw nvae;
            }
            switch (alt22) {
                case 1:
                    // smaliParser.g:645:5: LONG_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    LONG_LITERAL126 = (Token) match(input, LONG_LITERAL, FOLLOW_LONG_LITERAL_in_integral_literal2571);
                    LONG_LITERAL126_tree = (CommonTree) adaptor.create(LONG_LITERAL126);
                    adaptor.addChild(root_0, LONG_LITERAL126_tree);

                }
                break;
                case 2:
                    // smaliParser.g:646:5: integer_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_integer_literal_in_integral_literal2577);
                    integer_literal127 = integer_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, integer_literal127.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:647:5: SHORT_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    SHORT_LITERAL128 = (Token) match(input, SHORT_LITERAL, FOLLOW_SHORT_LITERAL_in_integral_literal2583);
                    SHORT_LITERAL128_tree = (CommonTree) adaptor.create(SHORT_LITERAL128);
                    adaptor.addChild(root_0, SHORT_LITERAL128_tree);

                }
                break;
                case 4:
                    // smaliParser.g:648:5: CHAR_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CHAR_LITERAL129 = (Token) match(input, CHAR_LITERAL, FOLLOW_CHAR_LITERAL_in_integral_literal2589);
                    CHAR_LITERAL129_tree = (CommonTree) adaptor.create(CHAR_LITERAL129);
                    adaptor.addChild(root_0, CHAR_LITERAL129_tree);

                }
                break;
                case 5:
                    // smaliParser.g:649:5: BYTE_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BYTE_LITERAL130 = (Token) match(input, BYTE_LITERAL, FOLLOW_BYTE_LITERAL_in_integral_literal2595);
                    BYTE_LITERAL130_tree = (CommonTree) adaptor.create(BYTE_LITERAL130);
                    adaptor.addChild(root_0, BYTE_LITERAL130_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "integral_literal"


    public static class fixed_32bit_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "fixed_32bit_literal"
    // smaliParser.g:651:1: fixed_32bit_literal : ( LONG_LITERAL | integer_literal | SHORT_LITERAL | BYTE_LITERAL | float_literal | CHAR_LITERAL | BOOL_LITERAL );
    public final smaliParser.fixed_32bit_literal_return fixed_32bit_literal() throws RecognitionException {
        smaliParser.fixed_32bit_literal_return retval = new smaliParser.fixed_32bit_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LONG_LITERAL131 = null;
        Token SHORT_LITERAL133 = null;
        Token BYTE_LITERAL134 = null;
        Token CHAR_LITERAL136 = null;
        Token BOOL_LITERAL137 = null;
        ParserRuleReturnScope integer_literal132 = null;
        ParserRuleReturnScope float_literal135 = null;

        CommonTree LONG_LITERAL131_tree = null;
        CommonTree SHORT_LITERAL133_tree = null;
        CommonTree BYTE_LITERAL134_tree = null;
        CommonTree CHAR_LITERAL136_tree = null;
        CommonTree BOOL_LITERAL137_tree = null;

        try {
            // smaliParser.g:652:3: ( LONG_LITERAL | integer_literal | SHORT_LITERAL | BYTE_LITERAL | float_literal | CHAR_LITERAL | BOOL_LITERAL )
            int alt23 = 7;
            switch (input.LA(1)) {
                case LONG_LITERAL: {
                    alt23 = 1;
                }
                break;
                case NEGATIVE_INTEGER_LITERAL:
                case POSITIVE_INTEGER_LITERAL: {
                    alt23 = 2;
                }
                break;
                case SHORT_LITERAL: {
                    alt23 = 3;
                }
                break;
                case BYTE_LITERAL: {
                    alt23 = 4;
                }
                break;
                case FLOAT_LITERAL:
                case FLOAT_LITERAL_OR_ID: {
                    alt23 = 5;
                }
                break;
                case CHAR_LITERAL: {
                    alt23 = 6;
                }
                break;
                case BOOL_LITERAL: {
                    alt23 = 7;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);
                    throw nvae;
            }
            switch (alt23) {
                case 1:
                    // smaliParser.g:652:5: LONG_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    LONG_LITERAL131 = (Token) match(input, LONG_LITERAL, FOLLOW_LONG_LITERAL_in_fixed_32bit_literal2605);
                    LONG_LITERAL131_tree = (CommonTree) adaptor.create(LONG_LITERAL131);
                    adaptor.addChild(root_0, LONG_LITERAL131_tree);

                }
                break;
                case 2:
                    // smaliParser.g:653:5: integer_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_integer_literal_in_fixed_32bit_literal2611);
                    integer_literal132 = integer_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, integer_literal132.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:654:5: SHORT_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    SHORT_LITERAL133 = (Token) match(input, SHORT_LITERAL, FOLLOW_SHORT_LITERAL_in_fixed_32bit_literal2617);
                    SHORT_LITERAL133_tree = (CommonTree) adaptor.create(SHORT_LITERAL133);
                    adaptor.addChild(root_0, SHORT_LITERAL133_tree);

                }
                break;
                case 4:
                    // smaliParser.g:655:5: BYTE_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BYTE_LITERAL134 = (Token) match(input, BYTE_LITERAL, FOLLOW_BYTE_LITERAL_in_fixed_32bit_literal2623);
                    BYTE_LITERAL134_tree = (CommonTree) adaptor.create(BYTE_LITERAL134);
                    adaptor.addChild(root_0, BYTE_LITERAL134_tree);

                }
                break;
                case 5:
                    // smaliParser.g:656:5: float_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_float_literal_in_fixed_32bit_literal2629);
                    float_literal135 = float_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, float_literal135.getTree());

                }
                break;
                case 6:
                    // smaliParser.g:657:5: CHAR_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CHAR_LITERAL136 = (Token) match(input, CHAR_LITERAL, FOLLOW_CHAR_LITERAL_in_fixed_32bit_literal2635);
                    CHAR_LITERAL136_tree = (CommonTree) adaptor.create(CHAR_LITERAL136);
                    adaptor.addChild(root_0, CHAR_LITERAL136_tree);

                }
                break;
                case 7:
                    // smaliParser.g:658:5: BOOL_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BOOL_LITERAL137 = (Token) match(input, BOOL_LITERAL, FOLLOW_BOOL_LITERAL_in_fixed_32bit_literal2641);
                    BOOL_LITERAL137_tree = (CommonTree) adaptor.create(BOOL_LITERAL137);
                    adaptor.addChild(root_0, BOOL_LITERAL137_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fixed_32bit_literal"


    public static class fixed_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "fixed_literal"
    // smaliParser.g:660:1: fixed_literal : ( integer_literal | LONG_LITERAL | SHORT_LITERAL | BYTE_LITERAL | float_literal | double_literal | CHAR_LITERAL | BOOL_LITERAL );
    public final smaliParser.fixed_literal_return fixed_literal() throws RecognitionException {
        smaliParser.fixed_literal_return retval = new smaliParser.fixed_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LONG_LITERAL139 = null;
        Token SHORT_LITERAL140 = null;
        Token BYTE_LITERAL141 = null;
        Token CHAR_LITERAL144 = null;
        Token BOOL_LITERAL145 = null;
        ParserRuleReturnScope integer_literal138 = null;
        ParserRuleReturnScope float_literal142 = null;
        ParserRuleReturnScope double_literal143 = null;

        CommonTree LONG_LITERAL139_tree = null;
        CommonTree SHORT_LITERAL140_tree = null;
        CommonTree BYTE_LITERAL141_tree = null;
        CommonTree CHAR_LITERAL144_tree = null;
        CommonTree BOOL_LITERAL145_tree = null;

        try {
            // smaliParser.g:661:3: ( integer_literal | LONG_LITERAL | SHORT_LITERAL | BYTE_LITERAL | float_literal | double_literal | CHAR_LITERAL | BOOL_LITERAL )
            int alt24 = 8;
            switch (input.LA(1)) {
                case NEGATIVE_INTEGER_LITERAL:
                case POSITIVE_INTEGER_LITERAL: {
                    alt24 = 1;
                }
                break;
                case LONG_LITERAL: {
                    alt24 = 2;
                }
                break;
                case SHORT_LITERAL: {
                    alt24 = 3;
                }
                break;
                case BYTE_LITERAL: {
                    alt24 = 4;
                }
                break;
                case FLOAT_LITERAL:
                case FLOAT_LITERAL_OR_ID: {
                    alt24 = 5;
                }
                break;
                case DOUBLE_LITERAL:
                case DOUBLE_LITERAL_OR_ID: {
                    alt24 = 6;
                }
                break;
                case CHAR_LITERAL: {
                    alt24 = 7;
                }
                break;
                case BOOL_LITERAL: {
                    alt24 = 8;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);
                    throw nvae;
            }
            switch (alt24) {
                case 1:
                    // smaliParser.g:661:5: integer_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_integer_literal_in_fixed_literal2651);
                    integer_literal138 = integer_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, integer_literal138.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:662:5: LONG_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    LONG_LITERAL139 = (Token) match(input, LONG_LITERAL, FOLLOW_LONG_LITERAL_in_fixed_literal2657);
                    LONG_LITERAL139_tree = (CommonTree) adaptor.create(LONG_LITERAL139);
                    adaptor.addChild(root_0, LONG_LITERAL139_tree);

                }
                break;
                case 3:
                    // smaliParser.g:663:5: SHORT_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    SHORT_LITERAL140 = (Token) match(input, SHORT_LITERAL, FOLLOW_SHORT_LITERAL_in_fixed_literal2663);
                    SHORT_LITERAL140_tree = (CommonTree) adaptor.create(SHORT_LITERAL140);
                    adaptor.addChild(root_0, SHORT_LITERAL140_tree);

                }
                break;
                case 4:
                    // smaliParser.g:664:5: BYTE_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BYTE_LITERAL141 = (Token) match(input, BYTE_LITERAL, FOLLOW_BYTE_LITERAL_in_fixed_literal2669);
                    BYTE_LITERAL141_tree = (CommonTree) adaptor.create(BYTE_LITERAL141);
                    adaptor.addChild(root_0, BYTE_LITERAL141_tree);

                }
                break;
                case 5:
                    // smaliParser.g:665:5: float_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_float_literal_in_fixed_literal2675);
                    float_literal142 = float_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, float_literal142.getTree());

                }
                break;
                case 6:
                    // smaliParser.g:666:5: double_literal
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_double_literal_in_fixed_literal2681);
                    double_literal143 = double_literal();
                    state._fsp--;

                    adaptor.addChild(root_0, double_literal143.getTree());

                }
                break;
                case 7:
                    // smaliParser.g:667:5: CHAR_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CHAR_LITERAL144 = (Token) match(input, CHAR_LITERAL, FOLLOW_CHAR_LITERAL_in_fixed_literal2687);
                    CHAR_LITERAL144_tree = (CommonTree) adaptor.create(CHAR_LITERAL144);
                    adaptor.addChild(root_0, CHAR_LITERAL144_tree);

                }
                break;
                case 8:
                    // smaliParser.g:668:5: BOOL_LITERAL
                {
                    root_0 = (CommonTree) adaptor.nil();


                    BOOL_LITERAL145 = (Token) match(input, BOOL_LITERAL, FOLLOW_BOOL_LITERAL_in_fixed_literal2693);
                    BOOL_LITERAL145_tree = (CommonTree) adaptor.create(BOOL_LITERAL145);
                    adaptor.addChild(root_0, BOOL_LITERAL145_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fixed_literal"


    public static class array_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "array_literal"
    // smaliParser.g:670:1: array_literal : OPEN_BRACE ( literal ( COMMA literal )* |) CLOSE_BRACE -> ^( I_ENCODED_ARRAY[$start, \"I_ENCODED_ARRAY\"] ( literal )* ) ;
    public final smaliParser.array_literal_return array_literal() throws RecognitionException {
        smaliParser.array_literal_return retval = new smaliParser.array_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OPEN_BRACE146 = null;
        Token COMMA148 = null;
        Token CLOSE_BRACE150 = null;
        ParserRuleReturnScope literal147 = null;
        ParserRuleReturnScope literal149 = null;

        CommonTree OPEN_BRACE146_tree = null;
        CommonTree COMMA148_tree = null;
        CommonTree CLOSE_BRACE150_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleSubtreeStream stream_literal = new RewriteRuleSubtreeStream(adaptor, "rule literal");

        try {
            // smaliParser.g:671:3: ( OPEN_BRACE ( literal ( COMMA literal )* |) CLOSE_BRACE -> ^( I_ENCODED_ARRAY[$start, \"I_ENCODED_ARRAY\"] ( literal )* ) )
            // smaliParser.g:671:5: OPEN_BRACE ( literal ( COMMA literal )* |) CLOSE_BRACE
            {
                OPEN_BRACE146 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_array_literal2703);
                stream_OPEN_BRACE.add(OPEN_BRACE146);

                // smaliParser.g:671:16: ( literal ( COMMA literal )* |)
                int alt26 = 2;
                int LA26_0 = input.LA(1);
                if ((LA26_0 == ACCESS_SPEC || LA26_0 == ANNOTATION_VISIBILITY || LA26_0 == ARRAY_TYPE_PREFIX || (LA26_0 >= BOOL_LITERAL && LA26_0 <= BYTE_LITERAL) || (LA26_0 >= CHAR_LITERAL && LA26_0 <= CLASS_DESCRIPTOR) || (LA26_0 >= DOUBLE_LITERAL && LA26_0 <= DOUBLE_LITERAL_OR_ID) || LA26_0 == ENUM_DIRECTIVE || (LA26_0 >= FLOAT_LITERAL && LA26_0 <= FLOAT_LITERAL_OR_ID) || (LA26_0 >= INSTRUCTION_FORMAT10t && LA26_0 <= INSTRUCTION_FORMAT10x_ODEX) || LA26_0 == INSTRUCTION_FORMAT11x || LA26_0 == INSTRUCTION_FORMAT12x_OR_ID || (LA26_0 >= INSTRUCTION_FORMAT21c_FIELD && LA26_0 <= INSTRUCTION_FORMAT21c_TYPE) || LA26_0 == INSTRUCTION_FORMAT21t || (LA26_0 >= INSTRUCTION_FORMAT22c_FIELD && LA26_0 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA26_0 >= INSTRUCTION_FORMAT22s_OR_ID && LA26_0 <= INSTRUCTION_FORMAT22t) || LA26_0 == INSTRUCTION_FORMAT23x || (LA26_0 >= INSTRUCTION_FORMAT31i_OR_ID && LA26_0 <= INSTRUCTION_FORMAT31t) || (LA26_0 >= INSTRUCTION_FORMAT35c_METHOD && LA26_0 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA26_0 >= INSTRUCTION_FORMAT45cc_METHOD && LA26_0 <= INSTRUCTION_FORMAT51l) || (LA26_0 >= LONG_LITERAL && LA26_0 <= MEMBER_NAME) || (LA26_0 >= NEGATIVE_INTEGER_LITERAL && LA26_0 <= OPEN_BRACE) || (LA26_0 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA26_0 <= PRIMITIVE_TYPE) || LA26_0 == REGISTER || (LA26_0 >= SHORT_LITERAL && LA26_0 <= SIMPLE_NAME) || (LA26_0 >= STRING_LITERAL && LA26_0 <= SUBANNOTATION_DIRECTIVE) || (LA26_0 >= VERIFICATION_ERROR_TYPE && LA26_0 <= VOID_TYPE))) {
                    alt26 = 1;
                } else if ((LA26_0 == CLOSE_BRACE)) {
                    alt26 = 2;
                } else {
                    NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);
                    throw nvae;
                }

                switch (alt26) {
                    case 1:
                        // smaliParser.g:671:17: literal ( COMMA literal )*
                    {
                        pushFollow(FOLLOW_literal_in_array_literal2706);
                        literal147 = literal();
                        state._fsp--;

                        stream_literal.add(literal147.getTree());
                        // smaliParser.g:671:25: ( COMMA literal )*
                        loop25:
                        while (true) {
                            int alt25 = 2;
                            int LA25_0 = input.LA(1);
                            if ((LA25_0 == COMMA)) {
                                alt25 = 1;
                            }

                            switch (alt25) {
                                case 1:
                                    // smaliParser.g:671:26: COMMA literal
                                {
                                    COMMA148 = (Token) match(input, COMMA, FOLLOW_COMMA_in_array_literal2709);
                                    stream_COMMA.add(COMMA148);

                                    pushFollow(FOLLOW_literal_in_array_literal2711);
                                    literal149 = literal();
                                    state._fsp--;

                                    stream_literal.add(literal149.getTree());
                                }
                                break;

                                default:
                                    break loop25;
                            }
                        }

                    }
                    break;
                    case 2:
                        // smaliParser.g:671:44:
                    {
                    }
                    break;

                }

                CLOSE_BRACE150 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_array_literal2719);
                stream_CLOSE_BRACE.add(CLOSE_BRACE150);

                // AST REWRITE
                // elements: literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 672:5: -> ^( I_ENCODED_ARRAY[$start, \"I_ENCODED_ARRAY\"] ( literal )* )
                {
                    // smaliParser.g:672:8: ^( I_ENCODED_ARRAY[$start, \"I_ENCODED_ARRAY\"] ( literal )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ENCODED_ARRAY, (retval.start), "I_ENCODED_ARRAY"), root_1);
                        // smaliParser.g:672:53: ( literal )*
                        while (stream_literal.hasNext()) {
                            adaptor.addChild(root_1, stream_literal.nextTree());
                        }
                        stream_literal.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_literal"


    public static class annotation_element_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "annotation_element"
    // smaliParser.g:674:1: annotation_element : simple_name EQUAL literal -> ^( I_ANNOTATION_ELEMENT[$start, \"I_ANNOTATION_ELEMENT\"] simple_name literal ) ;
    public final smaliParser.annotation_element_return annotation_element() throws RecognitionException {
        smaliParser.annotation_element_return retval = new smaliParser.annotation_element_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUAL152 = null;
        ParserRuleReturnScope simple_name151 = null;
        ParserRuleReturnScope literal153 = null;

        CommonTree EQUAL152_tree = null;
        RewriteRuleTokenStream stream_EQUAL = new RewriteRuleTokenStream(adaptor, "token EQUAL");
        RewriteRuleSubtreeStream stream_simple_name = new RewriteRuleSubtreeStream(adaptor, "rule simple_name");
        RewriteRuleSubtreeStream stream_literal = new RewriteRuleSubtreeStream(adaptor, "rule literal");

        try {
            // smaliParser.g:675:3: ( simple_name EQUAL literal -> ^( I_ANNOTATION_ELEMENT[$start, \"I_ANNOTATION_ELEMENT\"] simple_name literal ) )
            // smaliParser.g:675:5: simple_name EQUAL literal
            {
                pushFollow(FOLLOW_simple_name_in_annotation_element2743);
                simple_name151 = simple_name();
                state._fsp--;

                stream_simple_name.add(simple_name151.getTree());
                EQUAL152 = (Token) match(input, EQUAL, FOLLOW_EQUAL_in_annotation_element2745);
                stream_EQUAL.add(EQUAL152);

                pushFollow(FOLLOW_literal_in_annotation_element2747);
                literal153 = literal();
                state._fsp--;

                stream_literal.add(literal153.getTree());
                // AST REWRITE
                // elements: simple_name, literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 676:5: -> ^( I_ANNOTATION_ELEMENT[$start, \"I_ANNOTATION_ELEMENT\"] simple_name literal )
                {
                    // smaliParser.g:676:8: ^( I_ANNOTATION_ELEMENT[$start, \"I_ANNOTATION_ELEMENT\"] simple_name literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATION_ELEMENT, (retval.start), "I_ANNOTATION_ELEMENT"), root_1);
                        adaptor.addChild(root_1, stream_simple_name.nextTree());
                        adaptor.addChild(root_1, stream_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "annotation_element"


    public static class annotation_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "annotation"
    // smaliParser.g:678:1: annotation : ANNOTATION_DIRECTIVE ANNOTATION_VISIBILITY CLASS_DESCRIPTOR ( annotation_element )* END_ANNOTATION_DIRECTIVE -> ^( I_ANNOTATION[$start, \"I_ANNOTATION\"] ANNOTATION_VISIBILITY ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) ) ;
    public final smaliParser.annotation_return annotation() throws RecognitionException {
        smaliParser.annotation_return retval = new smaliParser.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ANNOTATION_DIRECTIVE154 = null;
        Token ANNOTATION_VISIBILITY155 = null;
        Token CLASS_DESCRIPTOR156 = null;
        Token END_ANNOTATION_DIRECTIVE158 = null;
        ParserRuleReturnScope annotation_element157 = null;

        CommonTree ANNOTATION_DIRECTIVE154_tree = null;
        CommonTree ANNOTATION_VISIBILITY155_tree = null;
        CommonTree CLASS_DESCRIPTOR156_tree = null;
        CommonTree END_ANNOTATION_DIRECTIVE158_tree = null;
        RewriteRuleTokenStream stream_ANNOTATION_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token ANNOTATION_DIRECTIVE");
        RewriteRuleTokenStream stream_ANNOTATION_VISIBILITY = new RewriteRuleTokenStream(adaptor, "token ANNOTATION_VISIBILITY");
        RewriteRuleTokenStream stream_CLASS_DESCRIPTOR = new RewriteRuleTokenStream(adaptor, "token CLASS_DESCRIPTOR");
        RewriteRuleTokenStream stream_END_ANNOTATION_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_ANNOTATION_DIRECTIVE");
        RewriteRuleSubtreeStream stream_annotation_element = new RewriteRuleSubtreeStream(adaptor, "rule annotation_element");

        try {
            // smaliParser.g:679:3: ( ANNOTATION_DIRECTIVE ANNOTATION_VISIBILITY CLASS_DESCRIPTOR ( annotation_element )* END_ANNOTATION_DIRECTIVE -> ^( I_ANNOTATION[$start, \"I_ANNOTATION\"] ANNOTATION_VISIBILITY ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) ) )
            // smaliParser.g:679:5: ANNOTATION_DIRECTIVE ANNOTATION_VISIBILITY CLASS_DESCRIPTOR ( annotation_element )* END_ANNOTATION_DIRECTIVE
            {
                ANNOTATION_DIRECTIVE154 = (Token) match(input, ANNOTATION_DIRECTIVE, FOLLOW_ANNOTATION_DIRECTIVE_in_annotation2772);
                stream_ANNOTATION_DIRECTIVE.add(ANNOTATION_DIRECTIVE154);

                ANNOTATION_VISIBILITY155 = (Token) match(input, ANNOTATION_VISIBILITY, FOLLOW_ANNOTATION_VISIBILITY_in_annotation2774);
                stream_ANNOTATION_VISIBILITY.add(ANNOTATION_VISIBILITY155);

                CLASS_DESCRIPTOR156 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_annotation2776);
                stream_CLASS_DESCRIPTOR.add(CLASS_DESCRIPTOR156);

                // smaliParser.g:680:5: ( annotation_element )*
                loop27:
                while (true) {
                    int alt27 = 2;
                    int LA27_0 = input.LA(1);
                    if ((LA27_0 == ACCESS_SPEC || LA27_0 == ANNOTATION_VISIBILITY || LA27_0 == BOOL_LITERAL || LA27_0 == DOUBLE_LITERAL_OR_ID || LA27_0 == FLOAT_LITERAL_OR_ID || (LA27_0 >= INSTRUCTION_FORMAT10t && LA27_0 <= INSTRUCTION_FORMAT10x_ODEX) || LA27_0 == INSTRUCTION_FORMAT11x || LA27_0 == INSTRUCTION_FORMAT12x_OR_ID || (LA27_0 >= INSTRUCTION_FORMAT21c_FIELD && LA27_0 <= INSTRUCTION_FORMAT21c_TYPE) || LA27_0 == INSTRUCTION_FORMAT21t || (LA27_0 >= INSTRUCTION_FORMAT22c_FIELD && LA27_0 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA27_0 >= INSTRUCTION_FORMAT22s_OR_ID && LA27_0 <= INSTRUCTION_FORMAT22t) || LA27_0 == INSTRUCTION_FORMAT23x || (LA27_0 >= INSTRUCTION_FORMAT31i_OR_ID && LA27_0 <= INSTRUCTION_FORMAT31t) || (LA27_0 >= INSTRUCTION_FORMAT35c_METHOD && LA27_0 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA27_0 >= INSTRUCTION_FORMAT45cc_METHOD && LA27_0 <= INSTRUCTION_FORMAT51l) || (LA27_0 >= NEGATIVE_INTEGER_LITERAL && LA27_0 <= NULL_LITERAL) || (LA27_0 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA27_0 <= PRIMITIVE_TYPE) || LA27_0 == REGISTER || LA27_0 == SIMPLE_NAME || (LA27_0 >= VERIFICATION_ERROR_TYPE && LA27_0 <= VOID_TYPE))) {
                        alt27 = 1;
                    }

                    switch (alt27) {
                        case 1:
                            // smaliParser.g:680:5: annotation_element
                        {
                            pushFollow(FOLLOW_annotation_element_in_annotation2782);
                            annotation_element157 = annotation_element();
                            state._fsp--;

                            stream_annotation_element.add(annotation_element157.getTree());
                        }
                        break;

                        default:
                            break loop27;
                    }
                }

                END_ANNOTATION_DIRECTIVE158 = (Token) match(input, END_ANNOTATION_DIRECTIVE, FOLLOW_END_ANNOTATION_DIRECTIVE_in_annotation2785);
                stream_END_ANNOTATION_DIRECTIVE.add(END_ANNOTATION_DIRECTIVE158);

                // AST REWRITE
                // elements: annotation_element, ANNOTATION_VISIBILITY, CLASS_DESCRIPTOR
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 681:5: -> ^( I_ANNOTATION[$start, \"I_ANNOTATION\"] ANNOTATION_VISIBILITY ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) )
                {
                    // smaliParser.g:681:8: ^( I_ANNOTATION[$start, \"I_ANNOTATION\"] ANNOTATION_VISIBILITY ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATION, (retval.start), "I_ANNOTATION"), root_1);
                        adaptor.addChild(root_1, stream_ANNOTATION_VISIBILITY.nextNode());
                        // smaliParser.g:681:69: ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SUBANNOTATION, (retval.start), "I_SUBANNOTATION"), root_2);
                            adaptor.addChild(root_2, stream_CLASS_DESCRIPTOR.nextNode());
                            // smaliParser.g:681:131: ( annotation_element )*
                            while (stream_annotation_element.hasNext()) {
                                adaptor.addChild(root_2, stream_annotation_element.nextTree());
                            }
                            stream_annotation_element.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "annotation"


    public static class subannotation_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "subannotation"
    // smaliParser.g:683:1: subannotation : SUBANNOTATION_DIRECTIVE CLASS_DESCRIPTOR ( annotation_element )* END_SUBANNOTATION_DIRECTIVE -> ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) ;
    public final smaliParser.subannotation_return subannotation() throws RecognitionException {
        smaliParser.subannotation_return retval = new smaliParser.subannotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUBANNOTATION_DIRECTIVE159 = null;
        Token CLASS_DESCRIPTOR160 = null;
        Token END_SUBANNOTATION_DIRECTIVE162 = null;
        ParserRuleReturnScope annotation_element161 = null;

        CommonTree SUBANNOTATION_DIRECTIVE159_tree = null;
        CommonTree CLASS_DESCRIPTOR160_tree = null;
        CommonTree END_SUBANNOTATION_DIRECTIVE162_tree = null;
        RewriteRuleTokenStream stream_SUBANNOTATION_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token SUBANNOTATION_DIRECTIVE");
        RewriteRuleTokenStream stream_CLASS_DESCRIPTOR = new RewriteRuleTokenStream(adaptor, "token CLASS_DESCRIPTOR");
        RewriteRuleTokenStream stream_END_SUBANNOTATION_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_SUBANNOTATION_DIRECTIVE");
        RewriteRuleSubtreeStream stream_annotation_element = new RewriteRuleSubtreeStream(adaptor, "rule annotation_element");

        try {
            // smaliParser.g:684:3: ( SUBANNOTATION_DIRECTIVE CLASS_DESCRIPTOR ( annotation_element )* END_SUBANNOTATION_DIRECTIVE -> ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* ) )
            // smaliParser.g:684:5: SUBANNOTATION_DIRECTIVE CLASS_DESCRIPTOR ( annotation_element )* END_SUBANNOTATION_DIRECTIVE
            {
                SUBANNOTATION_DIRECTIVE159 = (Token) match(input, SUBANNOTATION_DIRECTIVE, FOLLOW_SUBANNOTATION_DIRECTIVE_in_subannotation2818);
                stream_SUBANNOTATION_DIRECTIVE.add(SUBANNOTATION_DIRECTIVE159);

                CLASS_DESCRIPTOR160 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_subannotation2820);
                stream_CLASS_DESCRIPTOR.add(CLASS_DESCRIPTOR160);

                // smaliParser.g:684:46: ( annotation_element )*
                loop28:
                while (true) {
                    int alt28 = 2;
                    int LA28_0 = input.LA(1);
                    if ((LA28_0 == ACCESS_SPEC || LA28_0 == ANNOTATION_VISIBILITY || LA28_0 == BOOL_LITERAL || LA28_0 == DOUBLE_LITERAL_OR_ID || LA28_0 == FLOAT_LITERAL_OR_ID || (LA28_0 >= INSTRUCTION_FORMAT10t && LA28_0 <= INSTRUCTION_FORMAT10x_ODEX) || LA28_0 == INSTRUCTION_FORMAT11x || LA28_0 == INSTRUCTION_FORMAT12x_OR_ID || (LA28_0 >= INSTRUCTION_FORMAT21c_FIELD && LA28_0 <= INSTRUCTION_FORMAT21c_TYPE) || LA28_0 == INSTRUCTION_FORMAT21t || (LA28_0 >= INSTRUCTION_FORMAT22c_FIELD && LA28_0 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA28_0 >= INSTRUCTION_FORMAT22s_OR_ID && LA28_0 <= INSTRUCTION_FORMAT22t) || LA28_0 == INSTRUCTION_FORMAT23x || (LA28_0 >= INSTRUCTION_FORMAT31i_OR_ID && LA28_0 <= INSTRUCTION_FORMAT31t) || (LA28_0 >= INSTRUCTION_FORMAT35c_METHOD && LA28_0 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA28_0 >= INSTRUCTION_FORMAT45cc_METHOD && LA28_0 <= INSTRUCTION_FORMAT51l) || (LA28_0 >= NEGATIVE_INTEGER_LITERAL && LA28_0 <= NULL_LITERAL) || (LA28_0 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA28_0 <= PRIMITIVE_TYPE) || LA28_0 == REGISTER || LA28_0 == SIMPLE_NAME || (LA28_0 >= VERIFICATION_ERROR_TYPE && LA28_0 <= VOID_TYPE))) {
                        alt28 = 1;
                    }

                    switch (alt28) {
                        case 1:
                            // smaliParser.g:684:46: annotation_element
                        {
                            pushFollow(FOLLOW_annotation_element_in_subannotation2822);
                            annotation_element161 = annotation_element();
                            state._fsp--;

                            stream_annotation_element.add(annotation_element161.getTree());
                        }
                        break;

                        default:
                            break loop28;
                    }
                }

                END_SUBANNOTATION_DIRECTIVE162 = (Token) match(input, END_SUBANNOTATION_DIRECTIVE, FOLLOW_END_SUBANNOTATION_DIRECTIVE_in_subannotation2825);
                stream_END_SUBANNOTATION_DIRECTIVE.add(END_SUBANNOTATION_DIRECTIVE162);

                // AST REWRITE
                // elements: CLASS_DESCRIPTOR, annotation_element
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 685:5: -> ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* )
                {
                    // smaliParser.g:685:8: ^( I_SUBANNOTATION[$start, \"I_SUBANNOTATION\"] CLASS_DESCRIPTOR ( annotation_element )* )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SUBANNOTATION, (retval.start), "I_SUBANNOTATION"), root_1);
                        adaptor.addChild(root_1, stream_CLASS_DESCRIPTOR.nextNode());
                        // smaliParser.g:685:70: ( annotation_element )*
                        while (stream_annotation_element.hasNext()) {
                            adaptor.addChild(root_1, stream_annotation_element.nextTree());
                        }
                        stream_annotation_element.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "subannotation"


    public static class enum_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "enum_literal"
    // smaliParser.g:688:1: enum_literal : ENUM_DIRECTIVE field_reference -> ^( I_ENCODED_ENUM field_reference ) ;
    public final smaliParser.enum_literal_return enum_literal() throws RecognitionException {
        smaliParser.enum_literal_return retval = new smaliParser.enum_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ENUM_DIRECTIVE163 = null;
        ParserRuleReturnScope field_reference164 = null;

        CommonTree ENUM_DIRECTIVE163_tree = null;
        RewriteRuleTokenStream stream_ENUM_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token ENUM_DIRECTIVE");
        RewriteRuleSubtreeStream stream_field_reference = new RewriteRuleSubtreeStream(adaptor, "rule field_reference");

        try {
            // smaliParser.g:689:3: ( ENUM_DIRECTIVE field_reference -> ^( I_ENCODED_ENUM field_reference ) )
            // smaliParser.g:689:5: ENUM_DIRECTIVE field_reference
            {
                ENUM_DIRECTIVE163 = (Token) match(input, ENUM_DIRECTIVE, FOLLOW_ENUM_DIRECTIVE_in_enum_literal2852);
                stream_ENUM_DIRECTIVE.add(ENUM_DIRECTIVE163);

                pushFollow(FOLLOW_field_reference_in_enum_literal2854);
                field_reference164 = field_reference();
                state._fsp--;

                stream_field_reference.add(field_reference164.getTree());
                // AST REWRITE
                // elements: field_reference
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 690:3: -> ^( I_ENCODED_ENUM field_reference )
                {
                    // smaliParser.g:690:6: ^( I_ENCODED_ENUM field_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ENCODED_ENUM, "I_ENCODED_ENUM"), root_1);
                        adaptor.addChild(root_1, stream_field_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "enum_literal"


    public static class type_field_method_literal_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "type_field_method_literal"
    // smaliParser.g:692:1: type_field_method_literal : ( reference_type_descriptor | ( ( reference_type_descriptor ARROW )? ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) ) ) | PRIMITIVE_TYPE | VOID_TYPE );
    public final smaliParser.type_field_method_literal_return type_field_method_literal() throws RecognitionException {
        smaliParser.type_field_method_literal_return retval = new smaliParser.type_field_method_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARROW167 = null;
        Token COLON169 = null;
        Token PRIMITIVE_TYPE173 = null;
        Token VOID_TYPE174 = null;
        ParserRuleReturnScope reference_type_descriptor165 = null;
        ParserRuleReturnScope reference_type_descriptor166 = null;
        ParserRuleReturnScope member_name168 = null;
        ParserRuleReturnScope nonvoid_type_descriptor170 = null;
        ParserRuleReturnScope member_name171 = null;
        ParserRuleReturnScope method_prototype172 = null;

        CommonTree ARROW167_tree = null;
        CommonTree COLON169_tree = null;
        CommonTree PRIMITIVE_TYPE173_tree = null;
        CommonTree VOID_TYPE174_tree = null;
        RewriteRuleTokenStream stream_ARROW = new RewriteRuleTokenStream(adaptor, "token ARROW");
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleSubtreeStream stream_method_prototype = new RewriteRuleSubtreeStream(adaptor, "rule method_prototype");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");
        RewriteRuleSubtreeStream stream_member_name = new RewriteRuleSubtreeStream(adaptor, "rule member_name");
        RewriteRuleSubtreeStream stream_reference_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule reference_type_descriptor");

        try {
            // smaliParser.g:693:3: ( reference_type_descriptor | ( ( reference_type_descriptor ARROW )? ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) ) ) | PRIMITIVE_TYPE | VOID_TYPE )
            int alt31 = 4;
            switch (input.LA(1)) {
                case CLASS_DESCRIPTOR: {
                    int LA31_1 = input.LA(2);
                    if ((LA31_1 == EOF || (LA31_1 >= ACCESS_SPEC && LA31_1 <= ANNOTATION_VISIBILITY) || LA31_1 == BOOL_LITERAL || (LA31_1 >= CLASS_DIRECTIVE && LA31_1 <= CLOSE_BRACE) || LA31_1 == COMMA || (LA31_1 >= DOUBLE_LITERAL_OR_ID && LA31_1 <= END_ANNOTATION_DIRECTIVE) || LA31_1 == END_FIELD_DIRECTIVE || LA31_1 == END_SUBANNOTATION_DIRECTIVE || LA31_1 == FIELD_DIRECTIVE || (LA31_1 >= FLOAT_LITERAL_OR_ID && LA31_1 <= IMPLEMENTS_DIRECTIVE) || (LA31_1 >= INSTRUCTION_FORMAT10t && LA31_1 <= INSTRUCTION_FORMAT10x_ODEX) || LA31_1 == INSTRUCTION_FORMAT11x || LA31_1 == INSTRUCTION_FORMAT12x_OR_ID || (LA31_1 >= INSTRUCTION_FORMAT21c_FIELD && LA31_1 <= INSTRUCTION_FORMAT21c_TYPE) || LA31_1 == INSTRUCTION_FORMAT21t || (LA31_1 >= INSTRUCTION_FORMAT22c_FIELD && LA31_1 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA31_1 >= INSTRUCTION_FORMAT22s_OR_ID && LA31_1 <= INSTRUCTION_FORMAT22t) || LA31_1 == INSTRUCTION_FORMAT23x || (LA31_1 >= INSTRUCTION_FORMAT31i_OR_ID && LA31_1 <= INSTRUCTION_FORMAT31t) || (LA31_1 >= INSTRUCTION_FORMAT35c_METHOD && LA31_1 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA31_1 >= INSTRUCTION_FORMAT45cc_METHOD && LA31_1 <= INSTRUCTION_FORMAT51l) || (LA31_1 >= METHOD_DIRECTIVE && LA31_1 <= NULL_LITERAL) || (LA31_1 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA31_1 <= PRIMITIVE_TYPE) || LA31_1 == REGISTER || (LA31_1 >= SIMPLE_NAME && LA31_1 <= SOURCE_DIRECTIVE) || (LA31_1 >= SUPER_DIRECTIVE && LA31_1 <= VOID_TYPE))) {
                        alt31 = 1;
                    } else if ((LA31_1 == ARROW)) {
                        alt31 = 2;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 31, 1, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case ARRAY_TYPE_PREFIX: {
                    int LA31_2 = input.LA(2);
                    if ((LA31_2 == CLASS_DESCRIPTOR || LA31_2 == PRIMITIVE_TYPE)) {
                        int LA31_7 = input.LA(3);
                        if ((LA31_7 == EOF || (LA31_7 >= ACCESS_SPEC && LA31_7 <= ANNOTATION_VISIBILITY) || LA31_7 == BOOL_LITERAL || (LA31_7 >= CLASS_DIRECTIVE && LA31_7 <= CLOSE_BRACE) || LA31_7 == COMMA || (LA31_7 >= DOUBLE_LITERAL_OR_ID && LA31_7 <= END_ANNOTATION_DIRECTIVE) || LA31_7 == END_FIELD_DIRECTIVE || LA31_7 == END_SUBANNOTATION_DIRECTIVE || LA31_7 == FIELD_DIRECTIVE || (LA31_7 >= FLOAT_LITERAL_OR_ID && LA31_7 <= IMPLEMENTS_DIRECTIVE) || (LA31_7 >= INSTRUCTION_FORMAT10t && LA31_7 <= INSTRUCTION_FORMAT10x_ODEX) || LA31_7 == INSTRUCTION_FORMAT11x || LA31_7 == INSTRUCTION_FORMAT12x_OR_ID || (LA31_7 >= INSTRUCTION_FORMAT21c_FIELD && LA31_7 <= INSTRUCTION_FORMAT21c_TYPE) || LA31_7 == INSTRUCTION_FORMAT21t || (LA31_7 >= INSTRUCTION_FORMAT22c_FIELD && LA31_7 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA31_7 >= INSTRUCTION_FORMAT22s_OR_ID && LA31_7 <= INSTRUCTION_FORMAT22t) || LA31_7 == INSTRUCTION_FORMAT23x || (LA31_7 >= INSTRUCTION_FORMAT31i_OR_ID && LA31_7 <= INSTRUCTION_FORMAT31t) || (LA31_7 >= INSTRUCTION_FORMAT35c_METHOD && LA31_7 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA31_7 >= INSTRUCTION_FORMAT45cc_METHOD && LA31_7 <= INSTRUCTION_FORMAT51l) || (LA31_7 >= METHOD_DIRECTIVE && LA31_7 <= NULL_LITERAL) || (LA31_7 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA31_7 <= PRIMITIVE_TYPE) || LA31_7 == REGISTER || (LA31_7 >= SIMPLE_NAME && LA31_7 <= SOURCE_DIRECTIVE) || (LA31_7 >= SUPER_DIRECTIVE && LA31_7 <= VOID_TYPE))) {
                            alt31 = 1;
                        } else if ((LA31_7 == ARROW)) {
                            alt31 = 2;
                        } else {
                            int nvaeMark = input.mark();
                            try {
                                for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
                                    input.consume();
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 31, 7, input);
                                throw nvae;
                            } finally {
                                input.rewind(nvaeMark);
                            }
                        }

                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 31, 2, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case ACCESS_SPEC:
                case ANNOTATION_VISIBILITY:
                case BOOL_LITERAL:
                case DOUBLE_LITERAL_OR_ID:
                case FLOAT_LITERAL_OR_ID:
                case INSTRUCTION_FORMAT10t:
                case INSTRUCTION_FORMAT10x:
                case INSTRUCTION_FORMAT10x_ODEX:
                case INSTRUCTION_FORMAT11x:
                case INSTRUCTION_FORMAT12x_OR_ID:
                case INSTRUCTION_FORMAT21c_FIELD:
                case INSTRUCTION_FORMAT21c_FIELD_ODEX:
                case INSTRUCTION_FORMAT21c_STRING:
                case INSTRUCTION_FORMAT21c_TYPE:
                case INSTRUCTION_FORMAT21t:
                case INSTRUCTION_FORMAT22c_FIELD:
                case INSTRUCTION_FORMAT22c_FIELD_ODEX:
                case INSTRUCTION_FORMAT22c_TYPE:
                case INSTRUCTION_FORMAT22cs_FIELD:
                case INSTRUCTION_FORMAT22s_OR_ID:
                case INSTRUCTION_FORMAT22t:
                case INSTRUCTION_FORMAT23x:
                case INSTRUCTION_FORMAT31i_OR_ID:
                case INSTRUCTION_FORMAT31t:
                case INSTRUCTION_FORMAT35c_METHOD:
                case INSTRUCTION_FORMAT35c_METHOD_ODEX:
                case INSTRUCTION_FORMAT35c_TYPE:
                case INSTRUCTION_FORMAT35mi_METHOD:
                case INSTRUCTION_FORMAT35ms_METHOD:
                case INSTRUCTION_FORMAT45cc_METHOD:
                case INSTRUCTION_FORMAT4rcc_METHOD:
                case INSTRUCTION_FORMAT51l:
                case MEMBER_NAME:
                case NEGATIVE_INTEGER_LITERAL:
                case NULL_LITERAL:
                case PARAM_LIST_OR_ID_PRIMITIVE_TYPE:
                case POSITIVE_INTEGER_LITERAL:
                case REGISTER:
                case SIMPLE_NAME:
                case VERIFICATION_ERROR_TYPE: {
                    alt31 = 2;
                }
                break;
                case PRIMITIVE_TYPE: {
                    int LA31_4 = input.LA(2);
                    if ((LA31_4 == COLON || LA31_4 == OPEN_PAREN)) {
                        alt31 = 2;
                    } else if ((LA31_4 == EOF || (LA31_4 >= ACCESS_SPEC && LA31_4 <= ANNOTATION_VISIBILITY) || LA31_4 == BOOL_LITERAL || (LA31_4 >= CLASS_DIRECTIVE && LA31_4 <= CLOSE_BRACE) || LA31_4 == COMMA || (LA31_4 >= DOUBLE_LITERAL_OR_ID && LA31_4 <= END_ANNOTATION_DIRECTIVE) || LA31_4 == END_FIELD_DIRECTIVE || LA31_4 == END_SUBANNOTATION_DIRECTIVE || LA31_4 == FIELD_DIRECTIVE || (LA31_4 >= FLOAT_LITERAL_OR_ID && LA31_4 <= IMPLEMENTS_DIRECTIVE) || (LA31_4 >= INSTRUCTION_FORMAT10t && LA31_4 <= INSTRUCTION_FORMAT10x_ODEX) || LA31_4 == INSTRUCTION_FORMAT11x || LA31_4 == INSTRUCTION_FORMAT12x_OR_ID || (LA31_4 >= INSTRUCTION_FORMAT21c_FIELD && LA31_4 <= INSTRUCTION_FORMAT21c_TYPE) || LA31_4 == INSTRUCTION_FORMAT21t || (LA31_4 >= INSTRUCTION_FORMAT22c_FIELD && LA31_4 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA31_4 >= INSTRUCTION_FORMAT22s_OR_ID && LA31_4 <= INSTRUCTION_FORMAT22t) || LA31_4 == INSTRUCTION_FORMAT23x || (LA31_4 >= INSTRUCTION_FORMAT31i_OR_ID && LA31_4 <= INSTRUCTION_FORMAT31t) || (LA31_4 >= INSTRUCTION_FORMAT35c_METHOD && LA31_4 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA31_4 >= INSTRUCTION_FORMAT45cc_METHOD && LA31_4 <= INSTRUCTION_FORMAT51l) || (LA31_4 >= METHOD_DIRECTIVE && LA31_4 <= NULL_LITERAL) || (LA31_4 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA31_4 <= PRIMITIVE_TYPE) || LA31_4 == REGISTER || (LA31_4 >= SIMPLE_NAME && LA31_4 <= SOURCE_DIRECTIVE) || (LA31_4 >= SUPER_DIRECTIVE && LA31_4 <= VOID_TYPE))) {
                        alt31 = 3;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 31, 4, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                case VOID_TYPE: {
                    int LA31_5 = input.LA(2);
                    if ((LA31_5 == COLON || LA31_5 == OPEN_PAREN)) {
                        alt31 = 2;
                    } else if ((LA31_5 == EOF || (LA31_5 >= ACCESS_SPEC && LA31_5 <= ANNOTATION_VISIBILITY) || LA31_5 == BOOL_LITERAL || (LA31_5 >= CLASS_DIRECTIVE && LA31_5 <= CLOSE_BRACE) || LA31_5 == COMMA || (LA31_5 >= DOUBLE_LITERAL_OR_ID && LA31_5 <= END_ANNOTATION_DIRECTIVE) || LA31_5 == END_FIELD_DIRECTIVE || LA31_5 == END_SUBANNOTATION_DIRECTIVE || LA31_5 == FIELD_DIRECTIVE || (LA31_5 >= FLOAT_LITERAL_OR_ID && LA31_5 <= IMPLEMENTS_DIRECTIVE) || (LA31_5 >= INSTRUCTION_FORMAT10t && LA31_5 <= INSTRUCTION_FORMAT10x_ODEX) || LA31_5 == INSTRUCTION_FORMAT11x || LA31_5 == INSTRUCTION_FORMAT12x_OR_ID || (LA31_5 >= INSTRUCTION_FORMAT21c_FIELD && LA31_5 <= INSTRUCTION_FORMAT21c_TYPE) || LA31_5 == INSTRUCTION_FORMAT21t || (LA31_5 >= INSTRUCTION_FORMAT22c_FIELD && LA31_5 <= INSTRUCTION_FORMAT22cs_FIELD) || (LA31_5 >= INSTRUCTION_FORMAT22s_OR_ID && LA31_5 <= INSTRUCTION_FORMAT22t) || LA31_5 == INSTRUCTION_FORMAT23x || (LA31_5 >= INSTRUCTION_FORMAT31i_OR_ID && LA31_5 <= INSTRUCTION_FORMAT31t) || (LA31_5 >= INSTRUCTION_FORMAT35c_METHOD && LA31_5 <= INSTRUCTION_FORMAT35ms_METHOD) || (LA31_5 >= INSTRUCTION_FORMAT45cc_METHOD && LA31_5 <= INSTRUCTION_FORMAT51l) || (LA31_5 >= METHOD_DIRECTIVE && LA31_5 <= NULL_LITERAL) || (LA31_5 >= PARAM_LIST_OR_ID_PRIMITIVE_TYPE && LA31_5 <= PRIMITIVE_TYPE) || LA31_5 == REGISTER || (LA31_5 >= SIMPLE_NAME && LA31_5 <= SOURCE_DIRECTIVE) || (LA31_5 >= SUPER_DIRECTIVE && LA31_5 <= VOID_TYPE))) {
                        alt31 = 4;
                    } else {
                        int nvaeMark = input.mark();
                        try {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 31, 5, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);
                    throw nvae;
            }
            switch (alt31) {
                case 1:
                    // smaliParser.g:693:5: reference_type_descriptor
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_reference_type_descriptor_in_type_field_method_literal2874);
                    reference_type_descriptor165 = reference_type_descriptor();
                    state._fsp--;

                    adaptor.addChild(root_0, reference_type_descriptor165.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:694:5: ( ( reference_type_descriptor ARROW )? ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) ) )
                {
                    // smaliParser.g:694:5: ( ( reference_type_descriptor ARROW )? ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) ) )
                    // smaliParser.g:694:7: ( reference_type_descriptor ARROW )? ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) )
                    {
                        // smaliParser.g:694:7: ( reference_type_descriptor ARROW )?
                        int alt29 = 2;
                        int LA29_0 = input.LA(1);
                        if ((LA29_0 == ARRAY_TYPE_PREFIX || LA29_0 == CLASS_DESCRIPTOR)) {
                            alt29 = 1;
                        }
                        switch (alt29) {
                            case 1:
                                // smaliParser.g:694:8: reference_type_descriptor ARROW
                            {
                                pushFollow(FOLLOW_reference_type_descriptor_in_type_field_method_literal2883);
                                reference_type_descriptor166 = reference_type_descriptor();
                                state._fsp--;

                                stream_reference_type_descriptor.add(reference_type_descriptor166.getTree());
                                ARROW167 = (Token) match(input, ARROW, FOLLOW_ARROW_in_type_field_method_literal2885);
                                stream_ARROW.add(ARROW167);

                            }
                            break;

                        }

                        // smaliParser.g:695:7: ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) )
                        int alt30 = 2;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                            case 1:
                                // smaliParser.g:695:9: member_name COLON nonvoid_type_descriptor
                            {
                                pushFollow(FOLLOW_member_name_in_type_field_method_literal2897);
                                member_name168 = member_name();
                                state._fsp--;

                                stream_member_name.add(member_name168.getTree());
                                COLON169 = (Token) match(input, COLON, FOLLOW_COLON_in_type_field_method_literal2899);
                                stream_COLON.add(COLON169);

                                pushFollow(FOLLOW_nonvoid_type_descriptor_in_type_field_method_literal2901);
                                nonvoid_type_descriptor170 = nonvoid_type_descriptor();
                                state._fsp--;

                                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor170.getTree());
                                // AST REWRITE
                                // elements: member_name, reference_type_descriptor, nonvoid_type_descriptor
                                // token labels:
                                // rule labels: retval
                                // token list labels:
                                // rule list labels:
                                // wildcard labels:
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                                root_0 = (CommonTree) adaptor.nil();
                                // 695:51: -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor )
                                {
                                    // smaliParser.g:695:54: ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor )
                                    {
                                        CommonTree root_1 = (CommonTree) adaptor.nil();
                                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ENCODED_FIELD, "I_ENCODED_FIELD"), root_1);
                                        // smaliParser.g:695:72: ( reference_type_descriptor )?
                                        if (stream_reference_type_descriptor.hasNext()) {
                                            adaptor.addChild(root_1, stream_reference_type_descriptor.nextTree());
                                        }
                                        stream_reference_type_descriptor.reset();

                                        adaptor.addChild(root_1, stream_member_name.nextTree());
                                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                                        adaptor.addChild(root_0, root_1);
                                    }

                                }


                                retval.tree = root_0;

                            }
                            break;
                            case 2:
                                // smaliParser.g:696:9: member_name method_prototype
                            {
                                pushFollow(FOLLOW_member_name_in_type_field_method_literal2924);
                                member_name171 = member_name();
                                state._fsp--;

                                stream_member_name.add(member_name171.getTree());
                                pushFollow(FOLLOW_method_prototype_in_type_field_method_literal2926);
                                method_prototype172 = method_prototype();
                                state._fsp--;

                                stream_method_prototype.add(method_prototype172.getTree());
                                // AST REWRITE
                                // elements: method_prototype, member_name, reference_type_descriptor
                                // token labels:
                                // rule labels: retval
                                // token list labels:
                                // rule list labels:
                                // wildcard labels:
                                retval.tree = root_0;
                                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                                root_0 = (CommonTree) adaptor.nil();
                                // 696:38: -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype )
                                {
                                    // smaliParser.g:696:41: ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype )
                                    {
                                        CommonTree root_1 = (CommonTree) adaptor.nil();
                                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ENCODED_METHOD, "I_ENCODED_METHOD"), root_1);
                                        // smaliParser.g:696:60: ( reference_type_descriptor )?
                                        if (stream_reference_type_descriptor.hasNext()) {
                                            adaptor.addChild(root_1, stream_reference_type_descriptor.nextTree());
                                        }
                                        stream_reference_type_descriptor.reset();

                                        adaptor.addChild(root_1, stream_member_name.nextTree());
                                        adaptor.addChild(root_1, stream_method_prototype.nextTree());
                                        adaptor.addChild(root_0, root_1);
                                    }

                                }


                                retval.tree = root_0;

                            }
                            break;

                        }

                    }

                }
                break;
                case 3:
                    // smaliParser.g:699:5: PRIMITIVE_TYPE
                {
                    root_0 = (CommonTree) adaptor.nil();


                    PRIMITIVE_TYPE173 = (Token) match(input, PRIMITIVE_TYPE, FOLLOW_PRIMITIVE_TYPE_in_type_field_method_literal2959);
                    PRIMITIVE_TYPE173_tree = (CommonTree) adaptor.create(PRIMITIVE_TYPE173);
                    adaptor.addChild(root_0, PRIMITIVE_TYPE173_tree);

                }
                break;
                case 4:
                    // smaliParser.g:700:5: VOID_TYPE
                {
                    root_0 = (CommonTree) adaptor.nil();


                    VOID_TYPE174 = (Token) match(input, VOID_TYPE, FOLLOW_VOID_TYPE_in_type_field_method_literal2965);
                    VOID_TYPE174_tree = (CommonTree) adaptor.create(VOID_TYPE174);
                    adaptor.addChild(root_0, VOID_TYPE174_tree);

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_field_method_literal"


    public static class method_reference_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "method_reference"
    // smaliParser.g:702:1: method_reference : ( reference_type_descriptor ARROW )? member_name method_prototype -> ( reference_type_descriptor )? member_name method_prototype ;
    public final smaliParser.method_reference_return method_reference() throws RecognitionException {
        smaliParser.method_reference_return retval = new smaliParser.method_reference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARROW176 = null;
        ParserRuleReturnScope reference_type_descriptor175 = null;
        ParserRuleReturnScope member_name177 = null;
        ParserRuleReturnScope method_prototype178 = null;

        CommonTree ARROW176_tree = null;
        RewriteRuleTokenStream stream_ARROW = new RewriteRuleTokenStream(adaptor, "token ARROW");
        RewriteRuleSubtreeStream stream_method_prototype = new RewriteRuleSubtreeStream(adaptor, "rule method_prototype");
        RewriteRuleSubtreeStream stream_member_name = new RewriteRuleSubtreeStream(adaptor, "rule member_name");
        RewriteRuleSubtreeStream stream_reference_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule reference_type_descriptor");

        try {
            // smaliParser.g:703:3: ( ( reference_type_descriptor ARROW )? member_name method_prototype -> ( reference_type_descriptor )? member_name method_prototype )
            // smaliParser.g:703:5: ( reference_type_descriptor ARROW )? member_name method_prototype
            {
                // smaliParser.g:703:5: ( reference_type_descriptor ARROW )?
                int alt32 = 2;
                int LA32_0 = input.LA(1);
                if ((LA32_0 == ARRAY_TYPE_PREFIX || LA32_0 == CLASS_DESCRIPTOR)) {
                    alt32 = 1;
                }
                switch (alt32) {
                    case 1:
                        // smaliParser.g:703:6: reference_type_descriptor ARROW
                    {
                        pushFollow(FOLLOW_reference_type_descriptor_in_method_reference2976);
                        reference_type_descriptor175 = reference_type_descriptor();
                        state._fsp--;

                        stream_reference_type_descriptor.add(reference_type_descriptor175.getTree());
                        ARROW176 = (Token) match(input, ARROW, FOLLOW_ARROW_in_method_reference2978);
                        stream_ARROW.add(ARROW176);

                    }
                    break;

                }

                pushFollow(FOLLOW_member_name_in_method_reference2982);
                member_name177 = member_name();
                state._fsp--;

                stream_member_name.add(member_name177.getTree());
                pushFollow(FOLLOW_method_prototype_in_method_reference2984);
                method_prototype178 = method_prototype();
                state._fsp--;

                stream_method_prototype.add(method_prototype178.getTree());
                // AST REWRITE
                // elements: method_prototype, reference_type_descriptor, member_name
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 704:3: -> ( reference_type_descriptor )? member_name method_prototype
                {
                    // smaliParser.g:704:6: ( reference_type_descriptor )?
                    if (stream_reference_type_descriptor.hasNext()) {
                        adaptor.addChild(root_0, stream_reference_type_descriptor.nextTree());
                    }
                    stream_reference_type_descriptor.reset();

                    adaptor.addChild(root_0, stream_member_name.nextTree());
                    adaptor.addChild(root_0, stream_method_prototype.nextTree());
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "method_reference"


    public static class field_reference_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "field_reference"
    // smaliParser.g:706:1: field_reference : ( reference_type_descriptor ARROW )? member_name COLON nonvoid_type_descriptor -> ( reference_type_descriptor )? member_name nonvoid_type_descriptor ;
    public final smaliParser.field_reference_return field_reference() throws RecognitionException {
        smaliParser.field_reference_return retval = new smaliParser.field_reference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARROW180 = null;
        Token COLON182 = null;
        ParserRuleReturnScope reference_type_descriptor179 = null;
        ParserRuleReturnScope member_name181 = null;
        ParserRuleReturnScope nonvoid_type_descriptor183 = null;

        CommonTree ARROW180_tree = null;
        CommonTree COLON182_tree = null;
        RewriteRuleTokenStream stream_ARROW = new RewriteRuleTokenStream(adaptor, "token ARROW");
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");
        RewriteRuleSubtreeStream stream_member_name = new RewriteRuleSubtreeStream(adaptor, "rule member_name");
        RewriteRuleSubtreeStream stream_reference_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule reference_type_descriptor");

        try {
            // smaliParser.g:707:3: ( ( reference_type_descriptor ARROW )? member_name COLON nonvoid_type_descriptor -> ( reference_type_descriptor )? member_name nonvoid_type_descriptor )
            // smaliParser.g:707:5: ( reference_type_descriptor ARROW )? member_name COLON nonvoid_type_descriptor
            {
                // smaliParser.g:707:5: ( reference_type_descriptor ARROW )?
                int alt33 = 2;
                int LA33_0 = input.LA(1);
                if ((LA33_0 == ARRAY_TYPE_PREFIX || LA33_0 == CLASS_DESCRIPTOR)) {
                    alt33 = 1;
                }
                switch (alt33) {
                    case 1:
                        // smaliParser.g:707:6: reference_type_descriptor ARROW
                    {
                        pushFollow(FOLLOW_reference_type_descriptor_in_field_reference3006);
                        reference_type_descriptor179 = reference_type_descriptor();
                        state._fsp--;

                        stream_reference_type_descriptor.add(reference_type_descriptor179.getTree());
                        ARROW180 = (Token) match(input, ARROW, FOLLOW_ARROW_in_field_reference3008);
                        stream_ARROW.add(ARROW180);

                    }
                    break;

                }

                pushFollow(FOLLOW_member_name_in_field_reference3012);
                member_name181 = member_name();
                state._fsp--;

                stream_member_name.add(member_name181.getTree());
                COLON182 = (Token) match(input, COLON, FOLLOW_COLON_in_field_reference3014);
                stream_COLON.add(COLON182);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_field_reference3016);
                nonvoid_type_descriptor183 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor183.getTree());
                // AST REWRITE
                // elements: member_name, reference_type_descriptor, nonvoid_type_descriptor
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 708:3: -> ( reference_type_descriptor )? member_name nonvoid_type_descriptor
                {
                    // smaliParser.g:708:6: ( reference_type_descriptor )?
                    if (stream_reference_type_descriptor.hasNext()) {
                        adaptor.addChild(root_0, stream_reference_type_descriptor.nextTree());
                    }
                    stream_reference_type_descriptor.reset();

                    adaptor.addChild(root_0, stream_member_name.nextTree());
                    adaptor.addChild(root_0, stream_nonvoid_type_descriptor.nextTree());
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_reference"


    public static class label_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "label"
    // smaliParser.g:710:1: label : COLON simple_name -> ^( I_LABEL[$COLON, \"I_LABEL\"] simple_name ) ;
    public final smaliParser.label_return label() throws RecognitionException {
        smaliParser.label_return retval = new smaliParser.label_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON184 = null;
        ParserRuleReturnScope simple_name185 = null;

        CommonTree COLON184_tree = null;
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleSubtreeStream stream_simple_name = new RewriteRuleSubtreeStream(adaptor, "rule simple_name");

        try {
            // smaliParser.g:711:3: ( COLON simple_name -> ^( I_LABEL[$COLON, \"I_LABEL\"] simple_name ) )
            // smaliParser.g:711:5: COLON simple_name
            {
                COLON184 = (Token) match(input, COLON, FOLLOW_COLON_in_label3037);
                stream_COLON.add(COLON184);

                pushFollow(FOLLOW_simple_name_in_label3039);
                simple_name185 = simple_name();
                state._fsp--;

                stream_simple_name.add(simple_name185.getTree());
                // AST REWRITE
                // elements: simple_name
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 711:23: -> ^( I_LABEL[$COLON, \"I_LABEL\"] simple_name )
                {
                    // smaliParser.g:711:26: ^( I_LABEL[$COLON, \"I_LABEL\"] simple_name )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_LABEL, COLON184, "I_LABEL"), root_1);
                        adaptor.addChild(root_1, stream_simple_name.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "label"


    public static class label_ref_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "label_ref"
    // smaliParser.g:713:1: label_ref : COLON simple_name -> simple_name ;
    public final smaliParser.label_ref_return label_ref() throws RecognitionException {
        smaliParser.label_ref_return retval = new smaliParser.label_ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON186 = null;
        ParserRuleReturnScope simple_name187 = null;

        CommonTree COLON186_tree = null;
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleSubtreeStream stream_simple_name = new RewriteRuleSubtreeStream(adaptor, "rule simple_name");

        try {
            // smaliParser.g:714:3: ( COLON simple_name -> simple_name )
            // smaliParser.g:714:5: COLON simple_name
            {
                COLON186 = (Token) match(input, COLON, FOLLOW_COLON_in_label_ref3058);
                stream_COLON.add(COLON186);

                pushFollow(FOLLOW_simple_name_in_label_ref3060);
                simple_name187 = simple_name();
                state._fsp--;

                stream_simple_name.add(simple_name187.getTree());
                // AST REWRITE
                // elements: simple_name
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 714:23: -> simple_name
                {
                    adaptor.addChild(root_0, stream_simple_name.nextTree());
                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "label_ref"


    public static class register_list_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "register_list"
    // smaliParser.g:716:1: register_list : ( REGISTER ( COMMA REGISTER )* -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ( REGISTER )* ) | -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ) );
    public final smaliParser.register_list_return register_list() throws RecognitionException {
        smaliParser.register_list_return retval = new smaliParser.register_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REGISTER188 = null;
        Token COMMA189 = null;
        Token REGISTER190 = null;

        CommonTree REGISTER188_tree = null;
        CommonTree COMMA189_tree = null;
        CommonTree REGISTER190_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");

        try {
            // smaliParser.g:717:3: ( REGISTER ( COMMA REGISTER )* -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ( REGISTER )* ) | -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ) )
            int alt35 = 2;
            int LA35_0 = input.LA(1);
            if ((LA35_0 == REGISTER)) {
                alt35 = 1;
            } else if ((LA35_0 == CLOSE_BRACE)) {
                alt35 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 35, 0, input);
                throw nvae;
            }

            switch (alt35) {
                case 1:
                    // smaliParser.g:717:5: REGISTER ( COMMA REGISTER )*
                {
                    REGISTER188 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_register_list3074);
                    stream_REGISTER.add(REGISTER188);

                    // smaliParser.g:717:14: ( COMMA REGISTER )*
                    loop34:
                    while (true) {
                        int alt34 = 2;
                        int LA34_0 = input.LA(1);
                        if ((LA34_0 == COMMA)) {
                            alt34 = 1;
                        }

                        switch (alt34) {
                            case 1:
                                // smaliParser.g:717:15: COMMA REGISTER
                            {
                                COMMA189 = (Token) match(input, COMMA, FOLLOW_COMMA_in_register_list3077);
                                stream_COMMA.add(COMMA189);

                                REGISTER190 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_register_list3079);
                                stream_REGISTER.add(REGISTER190);

                            }
                            break;

                            default:
                                break loop34;
                        }
                    }

                    // AST REWRITE
                    // elements: REGISTER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 717:32: -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ( REGISTER )* )
                    {
                        // smaliParser.g:717:35: ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] ( REGISTER )* )
                        {
                            CommonTree root_1 = (CommonTree) adaptor.nil();
                            root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_REGISTER_LIST, (retval.start), "I_REGISTER_LIST"), root_1);
                            // smaliParser.g:717:80: ( REGISTER )*
                            while (stream_REGISTER.hasNext()) {
                                adaptor.addChild(root_1, stream_REGISTER.nextNode());
                            }
                            stream_REGISTER.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                }
                break;
                case 2:
                    // smaliParser.g:718:5:
                {
                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 718:5: -> ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] )
                    {
                        // smaliParser.g:718:7: ^( I_REGISTER_LIST[$start, \"I_REGISTER_LIST\"] )
                        {
                            CommonTree root_1 = (CommonTree) adaptor.nil();
                            root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_REGISTER_LIST, (retval.start), "I_REGISTER_LIST"), root_1);
                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_list"


    public static class register_range_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "register_range"
    // smaliParser.g:720:1: register_range : (startreg= REGISTER ( DOTDOT endreg= REGISTER )? )? -> ^( I_REGISTER_RANGE[$start, \"I_REGISTER_RANGE\"] ( $startreg)? ( $endreg)? ) ;
    public final smaliParser.register_range_return register_range() throws RecognitionException {
        smaliParser.register_range_return retval = new smaliParser.register_range_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token startreg = null;
        Token endreg = null;
        Token DOTDOT191 = null;

        CommonTree startreg_tree = null;
        CommonTree endreg_tree = null;
        CommonTree DOTDOT191_tree = null;
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_DOTDOT = new RewriteRuleTokenStream(adaptor, "token DOTDOT");

        try {
            // smaliParser.g:721:3: ( (startreg= REGISTER ( DOTDOT endreg= REGISTER )? )? -> ^( I_REGISTER_RANGE[$start, \"I_REGISTER_RANGE\"] ( $startreg)? ( $endreg)? ) )
            // smaliParser.g:721:5: (startreg= REGISTER ( DOTDOT endreg= REGISTER )? )?
            {
                // smaliParser.g:721:5: (startreg= REGISTER ( DOTDOT endreg= REGISTER )? )?
                int alt37 = 2;
                int LA37_0 = input.LA(1);
                if ((LA37_0 == REGISTER)) {
                    alt37 = 1;
                }
                switch (alt37) {
                    case 1:
                        // smaliParser.g:721:6: startreg= REGISTER ( DOTDOT endreg= REGISTER )?
                    {
                        startreg = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_register_range3114);
                        stream_REGISTER.add(startreg);

                        // smaliParser.g:721:24: ( DOTDOT endreg= REGISTER )?
                        int alt36 = 2;
                        int LA36_0 = input.LA(1);
                        if ((LA36_0 == DOTDOT)) {
                            alt36 = 1;
                        }
                        switch (alt36) {
                            case 1:
                                // smaliParser.g:721:25: DOTDOT endreg= REGISTER
                            {
                                DOTDOT191 = (Token) match(input, DOTDOT, FOLLOW_DOTDOT_in_register_range3117);
                                stream_DOTDOT.add(DOTDOT191);

                                endreg = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_register_range3121);
                                stream_REGISTER.add(endreg);

                            }
                            break;

                        }

                    }
                    break;

                }

                // AST REWRITE
                // elements: startreg, endreg
                // token labels: startreg, endreg
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleTokenStream stream_startreg = new RewriteRuleTokenStream(adaptor, "token startreg", startreg);
                RewriteRuleTokenStream stream_endreg = new RewriteRuleTokenStream(adaptor, "token endreg", endreg);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 721:52: -> ^( I_REGISTER_RANGE[$start, \"I_REGISTER_RANGE\"] ( $startreg)? ( $endreg)? )
                {
                    // smaliParser.g:721:55: ^( I_REGISTER_RANGE[$start, \"I_REGISTER_RANGE\"] ( $startreg)? ( $endreg)? )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_REGISTER_RANGE, (retval.start), "I_REGISTER_RANGE"), root_1);
                        // smaliParser.g:721:103: ( $startreg)?
                        if (stream_startreg.hasNext()) {
                            adaptor.addChild(root_1, stream_startreg.nextNode());
                        }
                        stream_startreg.reset();

                        // smaliParser.g:721:114: ( $endreg)?
                        if (stream_endreg.hasNext()) {
                            adaptor.addChild(root_1, stream_endreg.nextNode());
                        }
                        stream_endreg.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_range"


    public static class verification_error_reference_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "verification_error_reference"
    // smaliParser.g:723:1: verification_error_reference : ( CLASS_DESCRIPTOR | field_reference | method_reference );
    public final smaliParser.verification_error_reference_return verification_error_reference() throws RecognitionException {
        smaliParser.verification_error_reference_return retval = new smaliParser.verification_error_reference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CLASS_DESCRIPTOR192 = null;
        ParserRuleReturnScope field_reference193 = null;
        ParserRuleReturnScope method_reference194 = null;

        CommonTree CLASS_DESCRIPTOR192_tree = null;

        try {
            // smaliParser.g:724:3: ( CLASS_DESCRIPTOR | field_reference | method_reference )
            int alt38 = 3;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1:
                    // smaliParser.g:724:5: CLASS_DESCRIPTOR
                {
                    root_0 = (CommonTree) adaptor.nil();


                    CLASS_DESCRIPTOR192 = (Token) match(input, CLASS_DESCRIPTOR, FOLLOW_CLASS_DESCRIPTOR_in_verification_error_reference3150);
                    CLASS_DESCRIPTOR192_tree = (CommonTree) adaptor.create(CLASS_DESCRIPTOR192);
                    adaptor.addChild(root_0, CLASS_DESCRIPTOR192_tree);

                }
                break;
                case 2:
                    // smaliParser.g:724:24: field_reference
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_field_reference_in_verification_error_reference3154);
                    field_reference193 = field_reference();
                    state._fsp--;

                    adaptor.addChild(root_0, field_reference193.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:724:42: method_reference
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_method_reference_in_verification_error_reference3158);
                    method_reference194 = method_reference();
                    state._fsp--;

                    adaptor.addChild(root_0, method_reference194.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "verification_error_reference"


    public static class catch_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "catch_directive"
    // smaliParser.g:726:1: catch_directive : CATCH_DIRECTIVE nonvoid_type_descriptor OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref -> ^( I_CATCH[$start, \"I_CATCH\"] nonvoid_type_descriptor $from $to $using) ;
    public final smaliParser.catch_directive_return catch_directive() throws RecognitionException {
        smaliParser.catch_directive_return retval = new smaliParser.catch_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CATCH_DIRECTIVE195 = null;
        Token OPEN_BRACE197 = null;
        Token DOTDOT198 = null;
        Token CLOSE_BRACE199 = null;
        ParserRuleReturnScope from = null;
        ParserRuleReturnScope to = null;
        ParserRuleReturnScope using = null;
        ParserRuleReturnScope nonvoid_type_descriptor196 = null;

        CommonTree CATCH_DIRECTIVE195_tree = null;
        CommonTree OPEN_BRACE197_tree = null;
        CommonTree DOTDOT198_tree = null;
        CommonTree CLOSE_BRACE199_tree = null;
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleTokenStream stream_DOTDOT = new RewriteRuleTokenStream(adaptor, "token DOTDOT");
        RewriteRuleTokenStream stream_CATCH_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token CATCH_DIRECTIVE");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");

        try {
            // smaliParser.g:727:3: ( CATCH_DIRECTIVE nonvoid_type_descriptor OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref -> ^( I_CATCH[$start, \"I_CATCH\"] nonvoid_type_descriptor $from $to $using) )
            // smaliParser.g:727:5: CATCH_DIRECTIVE nonvoid_type_descriptor OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref
            {
                CATCH_DIRECTIVE195 = (Token) match(input, CATCH_DIRECTIVE, FOLLOW_CATCH_DIRECTIVE_in_catch_directive3168);
                stream_CATCH_DIRECTIVE.add(CATCH_DIRECTIVE195);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_catch_directive3170);
                nonvoid_type_descriptor196 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor196.getTree());
                OPEN_BRACE197 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_catch_directive3172);
                stream_OPEN_BRACE.add(OPEN_BRACE197);

                pushFollow(FOLLOW_label_ref_in_catch_directive3176);
                from = label_ref();
                state._fsp--;

                stream_label_ref.add(from.getTree());
                DOTDOT198 = (Token) match(input, DOTDOT, FOLLOW_DOTDOT_in_catch_directive3178);
                stream_DOTDOT.add(DOTDOT198);

                pushFollow(FOLLOW_label_ref_in_catch_directive3182);
                to = label_ref();
                state._fsp--;

                stream_label_ref.add(to.getTree());
                CLOSE_BRACE199 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_catch_directive3184);
                stream_CLOSE_BRACE.add(CLOSE_BRACE199);

                pushFollow(FOLLOW_label_ref_in_catch_directive3188);
                using = label_ref();
                state._fsp--;

                stream_label_ref.add(using.getTree());
                // AST REWRITE
                // elements: to, using, nonvoid_type_descriptor, from
                // token labels:
                // rule labels: using, from, to, retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_using = new RewriteRuleSubtreeStream(adaptor, "rule using", using != null ? using.getTree() : null);
                RewriteRuleSubtreeStream stream_from = new RewriteRuleSubtreeStream(adaptor, "rule from", from != null ? from.getTree() : null);
                RewriteRuleSubtreeStream stream_to = new RewriteRuleSubtreeStream(adaptor, "rule to", to != null ? to.getTree() : null);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 728:5: -> ^( I_CATCH[$start, \"I_CATCH\"] nonvoid_type_descriptor $from $to $using)
                {
                    // smaliParser.g:728:8: ^( I_CATCH[$start, \"I_CATCH\"] nonvoid_type_descriptor $from $to $using)
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_CATCH, (retval.start), "I_CATCH"), root_1);
                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        adaptor.addChild(root_1, stream_from.nextTree());
                        adaptor.addChild(root_1, stream_to.nextTree());
                        adaptor.addChild(root_1, stream_using.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "catch_directive"


    public static class catchall_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "catchall_directive"
    // smaliParser.g:730:1: catchall_directive : CATCHALL_DIRECTIVE OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref -> ^( I_CATCHALL[$start, \"I_CATCHALL\"] $from $to $using) ;
    public final smaliParser.catchall_directive_return catchall_directive() throws RecognitionException {
        smaliParser.catchall_directive_return retval = new smaliParser.catchall_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CATCHALL_DIRECTIVE200 = null;
        Token OPEN_BRACE201 = null;
        Token DOTDOT202 = null;
        Token CLOSE_BRACE203 = null;
        ParserRuleReturnScope from = null;
        ParserRuleReturnScope to = null;
        ParserRuleReturnScope using = null;

        CommonTree CATCHALL_DIRECTIVE200_tree = null;
        CommonTree OPEN_BRACE201_tree = null;
        CommonTree DOTDOT202_tree = null;
        CommonTree CLOSE_BRACE203_tree = null;
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleTokenStream stream_DOTDOT = new RewriteRuleTokenStream(adaptor, "token DOTDOT");
        RewriteRuleTokenStream stream_CATCHALL_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token CATCHALL_DIRECTIVE");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:731:3: ( CATCHALL_DIRECTIVE OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref -> ^( I_CATCHALL[$start, \"I_CATCHALL\"] $from $to $using) )
            // smaliParser.g:731:5: CATCHALL_DIRECTIVE OPEN_BRACE from= label_ref DOTDOT to= label_ref CLOSE_BRACE using= label_ref
            {
                CATCHALL_DIRECTIVE200 = (Token) match(input, CATCHALL_DIRECTIVE, FOLLOW_CATCHALL_DIRECTIVE_in_catchall_directive3220);
                stream_CATCHALL_DIRECTIVE.add(CATCHALL_DIRECTIVE200);

                OPEN_BRACE201 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_catchall_directive3222);
                stream_OPEN_BRACE.add(OPEN_BRACE201);

                pushFollow(FOLLOW_label_ref_in_catchall_directive3226);
                from = label_ref();
                state._fsp--;

                stream_label_ref.add(from.getTree());
                DOTDOT202 = (Token) match(input, DOTDOT, FOLLOW_DOTDOT_in_catchall_directive3228);
                stream_DOTDOT.add(DOTDOT202);

                pushFollow(FOLLOW_label_ref_in_catchall_directive3232);
                to = label_ref();
                state._fsp--;

                stream_label_ref.add(to.getTree());
                CLOSE_BRACE203 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_catchall_directive3234);
                stream_CLOSE_BRACE.add(CLOSE_BRACE203);

                pushFollow(FOLLOW_label_ref_in_catchall_directive3238);
                using = label_ref();
                state._fsp--;

                stream_label_ref.add(using.getTree());
                // AST REWRITE
                // elements: from, using, to
                // token labels:
                // rule labels: using, from, to, retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_using = new RewriteRuleSubtreeStream(adaptor, "rule using", using != null ? using.getTree() : null);
                RewriteRuleSubtreeStream stream_from = new RewriteRuleSubtreeStream(adaptor, "rule from", from != null ? from.getTree() : null);
                RewriteRuleSubtreeStream stream_to = new RewriteRuleSubtreeStream(adaptor, "rule to", to != null ? to.getTree() : null);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 732:5: -> ^( I_CATCHALL[$start, \"I_CATCHALL\"] $from $to $using)
                {
                    // smaliParser.g:732:8: ^( I_CATCHALL[$start, \"I_CATCHALL\"] $from $to $using)
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_CATCHALL, (retval.start), "I_CATCHALL"), root_1);
                        adaptor.addChild(root_1, stream_from.nextTree());
                        adaptor.addChild(root_1, stream_to.nextTree());
                        adaptor.addChild(root_1, stream_using.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "catchall_directive"


    public static class parameter_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "parameter_directive"
    // smaliParser.g:738:1: parameter_directive : PARAMETER_DIRECTIVE REGISTER ( COMMA STRING_LITERAL )? ({...}? annotation )* ( END_PARAMETER_DIRECTIVE -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) ) ) ;
    public final smaliParser.parameter_directive_return parameter_directive() throws RecognitionException {
        smaliParser.parameter_directive_return retval = new smaliParser.parameter_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PARAMETER_DIRECTIVE204 = null;
        Token REGISTER205 = null;
        Token COMMA206 = null;
        Token STRING_LITERAL207 = null;
        Token END_PARAMETER_DIRECTIVE209 = null;
        ParserRuleReturnScope annotation208 = null;

        CommonTree PARAMETER_DIRECTIVE204_tree = null;
        CommonTree REGISTER205_tree = null;
        CommonTree COMMA206_tree = null;
        CommonTree STRING_LITERAL207_tree = null;
        CommonTree END_PARAMETER_DIRECTIVE209_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_PARAMETER_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token PARAMETER_DIRECTIVE");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");
        RewriteRuleTokenStream stream_END_PARAMETER_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_PARAMETER_DIRECTIVE");
        RewriteRuleSubtreeStream stream_annotation = new RewriteRuleSubtreeStream(adaptor, "rule annotation");

        List<CommonTree> annotations = new ArrayList<CommonTree>();
        try {
            // smaliParser.g:740:3: ( PARAMETER_DIRECTIVE REGISTER ( COMMA STRING_LITERAL )? ({...}? annotation )* ( END_PARAMETER_DIRECTIVE -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) ) ) )
            // smaliParser.g:740:5: PARAMETER_DIRECTIVE REGISTER ( COMMA STRING_LITERAL )? ({...}? annotation )* ( END_PARAMETER_DIRECTIVE -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) ) )
            {
                PARAMETER_DIRECTIVE204 = (Token) match(input, PARAMETER_DIRECTIVE, FOLLOW_PARAMETER_DIRECTIVE_in_parameter_directive3277);
                stream_PARAMETER_DIRECTIVE.add(PARAMETER_DIRECTIVE204);

                REGISTER205 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_parameter_directive3279);
                stream_REGISTER.add(REGISTER205);

                // smaliParser.g:740:34: ( COMMA STRING_LITERAL )?
                int alt39 = 2;
                int LA39_0 = input.LA(1);
                if ((LA39_0 == COMMA)) {
                    alt39 = 1;
                }
                switch (alt39) {
                    case 1:
                        // smaliParser.g:740:35: COMMA STRING_LITERAL
                    {
                        COMMA206 = (Token) match(input, COMMA, FOLLOW_COMMA_in_parameter_directive3282);
                        stream_COMMA.add(COMMA206);

                        STRING_LITERAL207 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_parameter_directive3284);
                        stream_STRING_LITERAL.add(STRING_LITERAL207);

                    }
                    break;

                }

                // smaliParser.g:741:5: ({...}? annotation )*
                loop40:
                while (true) {
                    int alt40 = 2;
                    alt40 = dfa40.predict(input);
                    switch (alt40) {
                        case 1:
                            // smaliParser.g:741:6: {...}? annotation
                        {
                            if (!((input.LA(1) == ANNOTATION_DIRECTIVE))) {
                                throw new FailedPredicateException(input, "parameter_directive", "input.LA(1) == ANNOTATION_DIRECTIVE");
                            }
                            pushFollow(FOLLOW_annotation_in_parameter_directive3295);
                            annotation208 = annotation();
                            state._fsp--;

                            stream_annotation.add(annotation208.getTree());
                            annotations.add((annotation208 != null ? ((CommonTree) annotation208.getTree()) : null));
                        }
                        break;

                        default:
                            break loop40;
                    }
                }

                // smaliParser.g:743:5: ( END_PARAMETER_DIRECTIVE -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) ) | -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) ) )
                int alt41 = 2;
                int LA41_0 = input.LA(1);
                if ((LA41_0 == END_PARAMETER_DIRECTIVE)) {
                    alt41 = 1;
                } else if ((LA41_0 == ANNOTATION_DIRECTIVE || LA41_0 == ARRAY_DATA_DIRECTIVE || (LA41_0 >= CATCHALL_DIRECTIVE && LA41_0 <= CATCH_DIRECTIVE) || LA41_0 == COLON || (LA41_0 >= END_LOCAL_DIRECTIVE && LA41_0 <= END_METHOD_DIRECTIVE) || LA41_0 == EPILOGUE_DIRECTIVE || (LA41_0 >= INSTRUCTION_FORMAT10t && LA41_0 <= INSTRUCTION_FORMAT51l) || (LA41_0 >= LINE_DIRECTIVE && LA41_0 <= LOCAL_DIRECTIVE) || (LA41_0 >= PACKED_SWITCH_DIRECTIVE && LA41_0 <= PARAMETER_DIRECTIVE) || LA41_0 == PROLOGUE_DIRECTIVE || (LA41_0 >= REGISTERS_DIRECTIVE && LA41_0 <= RESTART_LOCAL_DIRECTIVE) || (LA41_0 >= SOURCE_DIRECTIVE && LA41_0 <= SPARSE_SWITCH_DIRECTIVE))) {
                    alt41 = 2;
                } else {
                    NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);
                    throw nvae;
                }

                switch (alt41) {
                    case 1:
                        // smaliParser.g:743:7: END_PARAMETER_DIRECTIVE
                    {
                        END_PARAMETER_DIRECTIVE209 = (Token) match(input, END_PARAMETER_DIRECTIVE, FOLLOW_END_PARAMETER_DIRECTIVE_in_parameter_directive3308);
                        stream_END_PARAMETER_DIRECTIVE.add(END_PARAMETER_DIRECTIVE209);

                        // AST REWRITE
                        // elements: annotation, STRING_LITERAL, REGISTER
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                        root_0 = (CommonTree) adaptor.nil();
                        // 744:7: -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) )
                        {
                            // smaliParser.g:744:10: ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ( annotation )* ) )
                            {
                                CommonTree root_1 = (CommonTree) adaptor.nil();
                                root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PARAMETER, (retval.start), "I_PARAMETER"), root_1);
                                adaptor.addChild(root_1, stream_REGISTER.nextNode());
                                // smaliParser.g:744:56: ( STRING_LITERAL )?
                                if (stream_STRING_LITERAL.hasNext()) {
                                    adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                                }
                                stream_STRING_LITERAL.reset();

                                // smaliParser.g:744:72: ^( I_ANNOTATIONS ( annotation )* )
                                {
                                    CommonTree root_2 = (CommonTree) adaptor.nil();
                                    root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATIONS, "I_ANNOTATIONS"), root_2);
                                    // smaliParser.g:744:88: ( annotation )*
                                    while (stream_annotation.hasNext()) {
                                        adaptor.addChild(root_2, stream_annotation.nextTree());
                                    }
                                    stream_annotation.reset();

                                    adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;

                    }
                    break;
                    case 2:
                        // smaliParser.g:745:19:
                    {
                        statements_and_directives_stack.peek().methodAnnotations.addAll(annotations);
                        // AST REWRITE
                        // elements: REGISTER, STRING_LITERAL
                        // token labels:
                        // rule labels: retval
                        // token list labels:
                        // rule list labels:
                        // wildcard labels:
                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                        root_0 = (CommonTree) adaptor.nil();
                        // 746:7: -> ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) )
                        {
                            // smaliParser.g:746:10: ^( I_PARAMETER[$start, \"I_PARAMETER\"] REGISTER ( STRING_LITERAL )? ^( I_ANNOTATIONS ) )
                            {
                                CommonTree root_1 = (CommonTree) adaptor.nil();
                                root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PARAMETER, (retval.start), "I_PARAMETER"), root_1);
                                adaptor.addChild(root_1, stream_REGISTER.nextNode());
                                // smaliParser.g:746:56: ( STRING_LITERAL )?
                                if (stream_STRING_LITERAL.hasNext()) {
                                    adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                                }
                                stream_STRING_LITERAL.reset();

                                // smaliParser.g:746:72: ^( I_ANNOTATIONS )
                                {
                                    CommonTree root_2 = (CommonTree) adaptor.nil();
                                    root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ANNOTATIONS, "I_ANNOTATIONS"), root_2);
                                    adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;

                    }
                    break;

                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameter_directive"


    public static class debug_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "debug_directive"
    // smaliParser.g:749:1: debug_directive : ( line_directive | local_directive | end_local_directive | restart_local_directive | prologue_directive | epilogue_directive | source_directive );
    public final smaliParser.debug_directive_return debug_directive() throws RecognitionException {
        smaliParser.debug_directive_return retval = new smaliParser.debug_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope line_directive210 = null;
        ParserRuleReturnScope local_directive211 = null;
        ParserRuleReturnScope end_local_directive212 = null;
        ParserRuleReturnScope restart_local_directive213 = null;
        ParserRuleReturnScope prologue_directive214 = null;
        ParserRuleReturnScope epilogue_directive215 = null;
        ParserRuleReturnScope source_directive216 = null;


        try {
            // smaliParser.g:750:3: ( line_directive | local_directive | end_local_directive | restart_local_directive | prologue_directive | epilogue_directive | source_directive )
            int alt42 = 7;
            switch (input.LA(1)) {
                case LINE_DIRECTIVE: {
                    alt42 = 1;
                }
                break;
                case LOCAL_DIRECTIVE: {
                    alt42 = 2;
                }
                break;
                case END_LOCAL_DIRECTIVE: {
                    alt42 = 3;
                }
                break;
                case RESTART_LOCAL_DIRECTIVE: {
                    alt42 = 4;
                }
                break;
                case PROLOGUE_DIRECTIVE: {
                    alt42 = 5;
                }
                break;
                case EPILOGUE_DIRECTIVE: {
                    alt42 = 6;
                }
                break;
                case SOURCE_DIRECTIVE: {
                    alt42 = 7;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);
                    throw nvae;
            }
            switch (alt42) {
                case 1:
                    // smaliParser.g:750:5: line_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_line_directive_in_debug_directive3381);
                    line_directive210 = line_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, line_directive210.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:751:5: local_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_local_directive_in_debug_directive3387);
                    local_directive211 = local_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, local_directive211.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:752:5: end_local_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_end_local_directive_in_debug_directive3393);
                    end_local_directive212 = end_local_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, end_local_directive212.getTree());

                }
                break;
                case 4:
                    // smaliParser.g:753:5: restart_local_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_restart_local_directive_in_debug_directive3399);
                    restart_local_directive213 = restart_local_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, restart_local_directive213.getTree());

                }
                break;
                case 5:
                    // smaliParser.g:754:5: prologue_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_prologue_directive_in_debug_directive3405);
                    prologue_directive214 = prologue_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, prologue_directive214.getTree());

                }
                break;
                case 6:
                    // smaliParser.g:755:5: epilogue_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_epilogue_directive_in_debug_directive3411);
                    epilogue_directive215 = epilogue_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, epilogue_directive215.getTree());

                }
                break;
                case 7:
                    // smaliParser.g:756:5: source_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_source_directive_in_debug_directive3417);
                    source_directive216 = source_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, source_directive216.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "debug_directive"


    public static class line_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "line_directive"
    // smaliParser.g:758:1: line_directive : LINE_DIRECTIVE integral_literal -> ^( I_LINE[$start, \"I_LINE\"] integral_literal ) ;
    public final smaliParser.line_directive_return line_directive() throws RecognitionException {
        smaliParser.line_directive_return retval = new smaliParser.line_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LINE_DIRECTIVE217 = null;
        ParserRuleReturnScope integral_literal218 = null;

        CommonTree LINE_DIRECTIVE217_tree = null;
        RewriteRuleTokenStream stream_LINE_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token LINE_DIRECTIVE");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:759:3: ( LINE_DIRECTIVE integral_literal -> ^( I_LINE[$start, \"I_LINE\"] integral_literal ) )
            // smaliParser.g:759:5: LINE_DIRECTIVE integral_literal
            {
                LINE_DIRECTIVE217 = (Token) match(input, LINE_DIRECTIVE, FOLLOW_LINE_DIRECTIVE_in_line_directive3427);
                stream_LINE_DIRECTIVE.add(LINE_DIRECTIVE217);

                pushFollow(FOLLOW_integral_literal_in_line_directive3429);
                integral_literal218 = integral_literal();
                state._fsp--;

                stream_integral_literal.add(integral_literal218.getTree());
                // AST REWRITE
                // elements: integral_literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 760:5: -> ^( I_LINE[$start, \"I_LINE\"] integral_literal )
                {
                    // smaliParser.g:760:8: ^( I_LINE[$start, \"I_LINE\"] integral_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_LINE, (retval.start), "I_LINE"), root_1);
                        adaptor.addChild(root_1, stream_integral_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "line_directive"


    public static class local_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "local_directive"
    // smaliParser.g:762:1: local_directive : LOCAL_DIRECTIVE REGISTER ( COMMA ( NULL_LITERAL |name= STRING_LITERAL ) COLON ( VOID_TYPE | nonvoid_type_descriptor ) ( COMMA signature= STRING_LITERAL )? )? -> ^( I_LOCAL[$start, \"I_LOCAL\"] REGISTER ( NULL_LITERAL )? ( $name)? ( nonvoid_type_descriptor )? ( $signature)? ) ;
    public final smaliParser.local_directive_return local_directive() throws RecognitionException {
        smaliParser.local_directive_return retval = new smaliParser.local_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token name = null;
        Token signature = null;
        Token LOCAL_DIRECTIVE219 = null;
        Token REGISTER220 = null;
        Token COMMA221 = null;
        Token NULL_LITERAL222 = null;
        Token COLON223 = null;
        Token VOID_TYPE224 = null;
        Token COMMA226 = null;
        ParserRuleReturnScope nonvoid_type_descriptor225 = null;

        CommonTree name_tree = null;
        CommonTree signature_tree = null;
        CommonTree LOCAL_DIRECTIVE219_tree = null;
        CommonTree REGISTER220_tree = null;
        CommonTree COMMA221_tree = null;
        CommonTree NULL_LITERAL222_tree = null;
        CommonTree COLON223_tree = null;
        CommonTree VOID_TYPE224_tree = null;
        CommonTree COMMA226_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_LOCAL_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token LOCAL_DIRECTIVE");
        RewriteRuleTokenStream stream_VOID_TYPE = new RewriteRuleTokenStream(adaptor, "token VOID_TYPE");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");
        RewriteRuleTokenStream stream_COLON = new RewriteRuleTokenStream(adaptor, "token COLON");
        RewriteRuleTokenStream stream_NULL_LITERAL = new RewriteRuleTokenStream(adaptor, "token NULL_LITERAL");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");

        try {
            // smaliParser.g:763:3: ( LOCAL_DIRECTIVE REGISTER ( COMMA ( NULL_LITERAL |name= STRING_LITERAL ) COLON ( VOID_TYPE | nonvoid_type_descriptor ) ( COMMA signature= STRING_LITERAL )? )? -> ^( I_LOCAL[$start, \"I_LOCAL\"] REGISTER ( NULL_LITERAL )? ( $name)? ( nonvoid_type_descriptor )? ( $signature)? ) )
            // smaliParser.g:763:5: LOCAL_DIRECTIVE REGISTER ( COMMA ( NULL_LITERAL |name= STRING_LITERAL ) COLON ( VOID_TYPE | nonvoid_type_descriptor ) ( COMMA signature= STRING_LITERAL )? )?
            {
                LOCAL_DIRECTIVE219 = (Token) match(input, LOCAL_DIRECTIVE, FOLLOW_LOCAL_DIRECTIVE_in_local_directive3452);
                stream_LOCAL_DIRECTIVE.add(LOCAL_DIRECTIVE219);

                REGISTER220 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_local_directive3454);
                stream_REGISTER.add(REGISTER220);

                // smaliParser.g:763:30: ( COMMA ( NULL_LITERAL |name= STRING_LITERAL ) COLON ( VOID_TYPE | nonvoid_type_descriptor ) ( COMMA signature= STRING_LITERAL )? )?
                int alt46 = 2;
                int LA46_0 = input.LA(1);
                if ((LA46_0 == COMMA)) {
                    alt46 = 1;
                }
                switch (alt46) {
                    case 1:
                        // smaliParser.g:763:31: COMMA ( NULL_LITERAL |name= STRING_LITERAL ) COLON ( VOID_TYPE | nonvoid_type_descriptor ) ( COMMA signature= STRING_LITERAL )?
                    {
                        COMMA221 = (Token) match(input, COMMA, FOLLOW_COMMA_in_local_directive3457);
                        stream_COMMA.add(COMMA221);

                        // smaliParser.g:763:37: ( NULL_LITERAL |name= STRING_LITERAL )
                        int alt43 = 2;
                        int LA43_0 = input.LA(1);
                        if ((LA43_0 == NULL_LITERAL)) {
                            alt43 = 1;
                        } else if ((LA43_0 == STRING_LITERAL)) {
                            alt43 = 2;
                        } else {
                            NoViableAltException nvae =
                                    new NoViableAltException("", 43, 0, input);
                            throw nvae;
                        }

                        switch (alt43) {
                            case 1:
                                // smaliParser.g:763:38: NULL_LITERAL
                            {
                                NULL_LITERAL222 = (Token) match(input, NULL_LITERAL, FOLLOW_NULL_LITERAL_in_local_directive3460);
                                stream_NULL_LITERAL.add(NULL_LITERAL222);

                            }
                            break;
                            case 2:
                                // smaliParser.g:763:53: name= STRING_LITERAL
                            {
                                name = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_local_directive3466);
                                stream_STRING_LITERAL.add(name);

                            }
                            break;

                        }

                        COLON223 = (Token) match(input, COLON, FOLLOW_COLON_in_local_directive3469);
                        stream_COLON.add(COLON223);

                        // smaliParser.g:763:80: ( VOID_TYPE | nonvoid_type_descriptor )
                        int alt44 = 2;
                        int LA44_0 = input.LA(1);
                        if ((LA44_0 == VOID_TYPE)) {
                            alt44 = 1;
                        } else if ((LA44_0 == ARRAY_TYPE_PREFIX || LA44_0 == CLASS_DESCRIPTOR || LA44_0 == PRIMITIVE_TYPE)) {
                            alt44 = 2;
                        } else {
                            NoViableAltException nvae =
                                    new NoViableAltException("", 44, 0, input);
                            throw nvae;
                        }

                        switch (alt44) {
                            case 1:
                                // smaliParser.g:763:81: VOID_TYPE
                            {
                                VOID_TYPE224 = (Token) match(input, VOID_TYPE, FOLLOW_VOID_TYPE_in_local_directive3472);
                                stream_VOID_TYPE.add(VOID_TYPE224);

                            }
                            break;
                            case 2:
                                // smaliParser.g:763:93: nonvoid_type_descriptor
                            {
                                pushFollow(FOLLOW_nonvoid_type_descriptor_in_local_directive3476);
                                nonvoid_type_descriptor225 = nonvoid_type_descriptor();
                                state._fsp--;

                                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor225.getTree());
                            }
                            break;

                        }

                        // smaliParser.g:764:31: ( COMMA signature= STRING_LITERAL )?
                        int alt45 = 2;
                        int LA45_0 = input.LA(1);
                        if ((LA45_0 == COMMA)) {
                            alt45 = 1;
                        }
                        switch (alt45) {
                            case 1:
                                // smaliParser.g:764:32: COMMA signature= STRING_LITERAL
                            {
                                COMMA226 = (Token) match(input, COMMA, FOLLOW_COMMA_in_local_directive3510);
                                stream_COMMA.add(COMMA226);

                                signature = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_local_directive3514);
                                stream_STRING_LITERAL.add(signature);

                            }
                            break;

                        }

                    }
                    break;

                }

                // AST REWRITE
                // elements: NULL_LITERAL, REGISTER, name, signature, nonvoid_type_descriptor
                // token labels: signature, name
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleTokenStream stream_signature = new RewriteRuleTokenStream(adaptor, "token signature", signature);
                RewriteRuleTokenStream stream_name = new RewriteRuleTokenStream(adaptor, "token name", name);
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 765:5: -> ^( I_LOCAL[$start, \"I_LOCAL\"] REGISTER ( NULL_LITERAL )? ( $name)? ( nonvoid_type_descriptor )? ( $signature)? )
                {
                    // smaliParser.g:765:8: ^( I_LOCAL[$start, \"I_LOCAL\"] REGISTER ( NULL_LITERAL )? ( $name)? ( nonvoid_type_descriptor )? ( $signature)? )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_LOCAL, (retval.start), "I_LOCAL"), root_1);
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        // smaliParser.g:765:46: ( NULL_LITERAL )?
                        if (stream_NULL_LITERAL.hasNext()) {
                            adaptor.addChild(root_1, stream_NULL_LITERAL.nextNode());
                        }
                        stream_NULL_LITERAL.reset();

                        // smaliParser.g:765:61: ( $name)?
                        if (stream_name.hasNext()) {
                            adaptor.addChild(root_1, stream_name.nextNode());
                        }
                        stream_name.reset();

                        // smaliParser.g:765:67: ( nonvoid_type_descriptor )?
                        if (stream_nonvoid_type_descriptor.hasNext()) {
                            adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        }
                        stream_nonvoid_type_descriptor.reset();

                        // smaliParser.g:765:93: ( $signature)?
                        if (stream_signature.hasNext()) {
                            adaptor.addChild(root_1, stream_signature.nextNode());
                        }
                        stream_signature.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "local_directive"


    public static class end_local_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "end_local_directive"
    // smaliParser.g:767:1: end_local_directive : END_LOCAL_DIRECTIVE REGISTER -> ^( I_END_LOCAL[$start, \"I_END_LOCAL\"] REGISTER ) ;
    public final smaliParser.end_local_directive_return end_local_directive() throws RecognitionException {
        smaliParser.end_local_directive_return retval = new smaliParser.end_local_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_LOCAL_DIRECTIVE227 = null;
        Token REGISTER228 = null;

        CommonTree END_LOCAL_DIRECTIVE227_tree = null;
        CommonTree REGISTER228_tree = null;
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_END_LOCAL_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_LOCAL_DIRECTIVE");

        try {
            // smaliParser.g:768:3: ( END_LOCAL_DIRECTIVE REGISTER -> ^( I_END_LOCAL[$start, \"I_END_LOCAL\"] REGISTER ) )
            // smaliParser.g:768:5: END_LOCAL_DIRECTIVE REGISTER
            {
                END_LOCAL_DIRECTIVE227 = (Token) match(input, END_LOCAL_DIRECTIVE, FOLLOW_END_LOCAL_DIRECTIVE_in_end_local_directive3556);
                stream_END_LOCAL_DIRECTIVE.add(END_LOCAL_DIRECTIVE227);

                REGISTER228 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_end_local_directive3558);
                stream_REGISTER.add(REGISTER228);

                // AST REWRITE
                // elements: REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 769:5: -> ^( I_END_LOCAL[$start, \"I_END_LOCAL\"] REGISTER )
                {
                    // smaliParser.g:769:8: ^( I_END_LOCAL[$start, \"I_END_LOCAL\"] REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_END_LOCAL, (retval.start), "I_END_LOCAL"), root_1);
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "end_local_directive"


    public static class restart_local_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "restart_local_directive"
    // smaliParser.g:771:1: restart_local_directive : RESTART_LOCAL_DIRECTIVE REGISTER -> ^( I_RESTART_LOCAL[$start, \"I_RESTART_LOCAL\"] REGISTER ) ;
    public final smaliParser.restart_local_directive_return restart_local_directive() throws RecognitionException {
        smaliParser.restart_local_directive_return retval = new smaliParser.restart_local_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RESTART_LOCAL_DIRECTIVE229 = null;
        Token REGISTER230 = null;

        CommonTree RESTART_LOCAL_DIRECTIVE229_tree = null;
        CommonTree REGISTER230_tree = null;
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_RESTART_LOCAL_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token RESTART_LOCAL_DIRECTIVE");

        try {
            // smaliParser.g:772:3: ( RESTART_LOCAL_DIRECTIVE REGISTER -> ^( I_RESTART_LOCAL[$start, \"I_RESTART_LOCAL\"] REGISTER ) )
            // smaliParser.g:772:5: RESTART_LOCAL_DIRECTIVE REGISTER
            {
                RESTART_LOCAL_DIRECTIVE229 = (Token) match(input, RESTART_LOCAL_DIRECTIVE, FOLLOW_RESTART_LOCAL_DIRECTIVE_in_restart_local_directive3581);
                stream_RESTART_LOCAL_DIRECTIVE.add(RESTART_LOCAL_DIRECTIVE229);

                REGISTER230 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_restart_local_directive3583);
                stream_REGISTER.add(REGISTER230);

                // AST REWRITE
                // elements: REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 773:5: -> ^( I_RESTART_LOCAL[$start, \"I_RESTART_LOCAL\"] REGISTER )
                {
                    // smaliParser.g:773:8: ^( I_RESTART_LOCAL[$start, \"I_RESTART_LOCAL\"] REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_RESTART_LOCAL, (retval.start), "I_RESTART_LOCAL"), root_1);
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "restart_local_directive"


    public static class prologue_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "prologue_directive"
    // smaliParser.g:775:1: prologue_directive : PROLOGUE_DIRECTIVE -> ^( I_PROLOGUE[$start, \"I_PROLOGUE\"] ) ;
    public final smaliParser.prologue_directive_return prologue_directive() throws RecognitionException {
        smaliParser.prologue_directive_return retval = new smaliParser.prologue_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROLOGUE_DIRECTIVE231 = null;

        CommonTree PROLOGUE_DIRECTIVE231_tree = null;
        RewriteRuleTokenStream stream_PROLOGUE_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token PROLOGUE_DIRECTIVE");

        try {
            // smaliParser.g:776:3: ( PROLOGUE_DIRECTIVE -> ^( I_PROLOGUE[$start, \"I_PROLOGUE\"] ) )
            // smaliParser.g:776:5: PROLOGUE_DIRECTIVE
            {
                PROLOGUE_DIRECTIVE231 = (Token) match(input, PROLOGUE_DIRECTIVE, FOLLOW_PROLOGUE_DIRECTIVE_in_prologue_directive3606);
                stream_PROLOGUE_DIRECTIVE.add(PROLOGUE_DIRECTIVE231);

                // AST REWRITE
                // elements:
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 777:5: -> ^( I_PROLOGUE[$start, \"I_PROLOGUE\"] )
                {
                    // smaliParser.g:777:8: ^( I_PROLOGUE[$start, \"I_PROLOGUE\"] )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PROLOGUE, (retval.start), "I_PROLOGUE"), root_1);
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prologue_directive"


    public static class epilogue_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "epilogue_directive"
    // smaliParser.g:779:1: epilogue_directive : EPILOGUE_DIRECTIVE -> ^( I_EPILOGUE[$start, \"I_EPILOGUE\"] ) ;
    public final smaliParser.epilogue_directive_return epilogue_directive() throws RecognitionException {
        smaliParser.epilogue_directive_return retval = new smaliParser.epilogue_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EPILOGUE_DIRECTIVE232 = null;

        CommonTree EPILOGUE_DIRECTIVE232_tree = null;
        RewriteRuleTokenStream stream_EPILOGUE_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token EPILOGUE_DIRECTIVE");

        try {
            // smaliParser.g:780:3: ( EPILOGUE_DIRECTIVE -> ^( I_EPILOGUE[$start, \"I_EPILOGUE\"] ) )
            // smaliParser.g:780:5: EPILOGUE_DIRECTIVE
            {
                EPILOGUE_DIRECTIVE232 = (Token) match(input, EPILOGUE_DIRECTIVE, FOLLOW_EPILOGUE_DIRECTIVE_in_epilogue_directive3627);
                stream_EPILOGUE_DIRECTIVE.add(EPILOGUE_DIRECTIVE232);

                // AST REWRITE
                // elements:
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 781:5: -> ^( I_EPILOGUE[$start, \"I_EPILOGUE\"] )
                {
                    // smaliParser.g:781:8: ^( I_EPILOGUE[$start, \"I_EPILOGUE\"] )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_EPILOGUE, (retval.start), "I_EPILOGUE"), root_1);
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "epilogue_directive"


    public static class source_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "source_directive"
    // smaliParser.g:783:1: source_directive : SOURCE_DIRECTIVE ( STRING_LITERAL )? -> ^( I_SOURCE[$start, \"I_SOURCE\"] ( STRING_LITERAL )? ) ;
    public final smaliParser.source_directive_return source_directive() throws RecognitionException {
        smaliParser.source_directive_return retval = new smaliParser.source_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SOURCE_DIRECTIVE233 = null;
        Token STRING_LITERAL234 = null;

        CommonTree SOURCE_DIRECTIVE233_tree = null;
        CommonTree STRING_LITERAL234_tree = null;
        RewriteRuleTokenStream stream_SOURCE_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token SOURCE_DIRECTIVE");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");

        try {
            // smaliParser.g:784:3: ( SOURCE_DIRECTIVE ( STRING_LITERAL )? -> ^( I_SOURCE[$start, \"I_SOURCE\"] ( STRING_LITERAL )? ) )
            // smaliParser.g:784:5: SOURCE_DIRECTIVE ( STRING_LITERAL )?
            {
                SOURCE_DIRECTIVE233 = (Token) match(input, SOURCE_DIRECTIVE, FOLLOW_SOURCE_DIRECTIVE_in_source_directive3648);
                stream_SOURCE_DIRECTIVE.add(SOURCE_DIRECTIVE233);

                // smaliParser.g:784:22: ( STRING_LITERAL )?
                int alt47 = 2;
                int LA47_0 = input.LA(1);
                if ((LA47_0 == STRING_LITERAL)) {
                    alt47 = 1;
                }
                switch (alt47) {
                    case 1:
                        // smaliParser.g:784:22: STRING_LITERAL
                    {
                        STRING_LITERAL234 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_source_directive3650);
                        stream_STRING_LITERAL.add(STRING_LITERAL234);

                    }
                    break;

                }

                // AST REWRITE
                // elements: STRING_LITERAL
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 785:5: -> ^( I_SOURCE[$start, \"I_SOURCE\"] ( STRING_LITERAL )? )
                {
                    // smaliParser.g:785:8: ^( I_SOURCE[$start, \"I_SOURCE\"] ( STRING_LITERAL )? )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SOURCE, (retval.start), "I_SOURCE"), root_1);
                        // smaliParser.g:785:39: ( STRING_LITERAL )?
                        if (stream_STRING_LITERAL.hasNext()) {
                            adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                        }
                        stream_STRING_LITERAL.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "source_directive"


    public static class instruction_format12x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "instruction_format12x"
    // smaliParser.g:787:1: instruction_format12x : ( INSTRUCTION_FORMAT12x | INSTRUCTION_FORMAT12x_OR_ID -> INSTRUCTION_FORMAT12x[$INSTRUCTION_FORMAT12x_OR_ID] );
    public final smaliParser.instruction_format12x_return instruction_format12x() throws RecognitionException {
        smaliParser.instruction_format12x_return retval = new smaliParser.instruction_format12x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT12x235 = null;
        Token INSTRUCTION_FORMAT12x_OR_ID236 = null;

        CommonTree INSTRUCTION_FORMAT12x235_tree = null;
        CommonTree INSTRUCTION_FORMAT12x_OR_ID236_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT12x_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT12x_OR_ID");

        try {
            // smaliParser.g:788:3: ( INSTRUCTION_FORMAT12x | INSTRUCTION_FORMAT12x_OR_ID -> INSTRUCTION_FORMAT12x[$INSTRUCTION_FORMAT12x_OR_ID] )
            int alt48 = 2;
            int LA48_0 = input.LA(1);
            if ((LA48_0 == INSTRUCTION_FORMAT12x)) {
                alt48 = 1;
            } else if ((LA48_0 == INSTRUCTION_FORMAT12x_OR_ID)) {
                alt48 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 48, 0, input);
                throw nvae;
            }

            switch (alt48) {
                case 1:
                    // smaliParser.g:788:5: INSTRUCTION_FORMAT12x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    INSTRUCTION_FORMAT12x235 = (Token) match(input, INSTRUCTION_FORMAT12x, FOLLOW_INSTRUCTION_FORMAT12x_in_instruction_format12x3675);
                    INSTRUCTION_FORMAT12x235_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT12x235);
                    adaptor.addChild(root_0, INSTRUCTION_FORMAT12x235_tree);

                }
                break;
                case 2:
                    // smaliParser.g:789:5: INSTRUCTION_FORMAT12x_OR_ID
                {
                    INSTRUCTION_FORMAT12x_OR_ID236 = (Token) match(input, INSTRUCTION_FORMAT12x_OR_ID, FOLLOW_INSTRUCTION_FORMAT12x_OR_ID_in_instruction_format12x3681);
                    stream_INSTRUCTION_FORMAT12x_OR_ID.add(INSTRUCTION_FORMAT12x_OR_ID236);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 789:33: -> INSTRUCTION_FORMAT12x[$INSTRUCTION_FORMAT12x_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(INSTRUCTION_FORMAT12x, INSTRUCTION_FORMAT12x_OR_ID236));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instruction_format12x"


    public static class instruction_format22s_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "instruction_format22s"
    // smaliParser.g:791:1: instruction_format22s : ( INSTRUCTION_FORMAT22s | INSTRUCTION_FORMAT22s_OR_ID -> INSTRUCTION_FORMAT22s[$INSTRUCTION_FORMAT22s_OR_ID] );
    public final smaliParser.instruction_format22s_return instruction_format22s() throws RecognitionException {
        smaliParser.instruction_format22s_return retval = new smaliParser.instruction_format22s_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22s237 = null;
        Token INSTRUCTION_FORMAT22s_OR_ID238 = null;

        CommonTree INSTRUCTION_FORMAT22s237_tree = null;
        CommonTree INSTRUCTION_FORMAT22s_OR_ID238_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22s_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22s_OR_ID");

        try {
            // smaliParser.g:792:3: ( INSTRUCTION_FORMAT22s | INSTRUCTION_FORMAT22s_OR_ID -> INSTRUCTION_FORMAT22s[$INSTRUCTION_FORMAT22s_OR_ID] )
            int alt49 = 2;
            int LA49_0 = input.LA(1);
            if ((LA49_0 == INSTRUCTION_FORMAT22s)) {
                alt49 = 1;
            } else if ((LA49_0 == INSTRUCTION_FORMAT22s_OR_ID)) {
                alt49 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 49, 0, input);
                throw nvae;
            }

            switch (alt49) {
                case 1:
                    // smaliParser.g:792:5: INSTRUCTION_FORMAT22s
                {
                    root_0 = (CommonTree) adaptor.nil();


                    INSTRUCTION_FORMAT22s237 = (Token) match(input, INSTRUCTION_FORMAT22s, FOLLOW_INSTRUCTION_FORMAT22s_in_instruction_format22s3696);
                    INSTRUCTION_FORMAT22s237_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT22s237);
                    adaptor.addChild(root_0, INSTRUCTION_FORMAT22s237_tree);

                }
                break;
                case 2:
                    // smaliParser.g:793:5: INSTRUCTION_FORMAT22s_OR_ID
                {
                    INSTRUCTION_FORMAT22s_OR_ID238 = (Token) match(input, INSTRUCTION_FORMAT22s_OR_ID, FOLLOW_INSTRUCTION_FORMAT22s_OR_ID_in_instruction_format22s3702);
                    stream_INSTRUCTION_FORMAT22s_OR_ID.add(INSTRUCTION_FORMAT22s_OR_ID238);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 793:33: -> INSTRUCTION_FORMAT22s[$INSTRUCTION_FORMAT22s_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(INSTRUCTION_FORMAT22s, INSTRUCTION_FORMAT22s_OR_ID238));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instruction_format22s"


    public static class instruction_format31i_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "instruction_format31i"
    // smaliParser.g:795:1: instruction_format31i : ( INSTRUCTION_FORMAT31i | INSTRUCTION_FORMAT31i_OR_ID -> INSTRUCTION_FORMAT31i[$INSTRUCTION_FORMAT31i_OR_ID] );
    public final smaliParser.instruction_format31i_return instruction_format31i() throws RecognitionException {
        smaliParser.instruction_format31i_return retval = new smaliParser.instruction_format31i_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT31i239 = null;
        Token INSTRUCTION_FORMAT31i_OR_ID240 = null;

        CommonTree INSTRUCTION_FORMAT31i239_tree = null;
        CommonTree INSTRUCTION_FORMAT31i_OR_ID240_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT31i_OR_ID = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT31i_OR_ID");

        try {
            // smaliParser.g:796:3: ( INSTRUCTION_FORMAT31i | INSTRUCTION_FORMAT31i_OR_ID -> INSTRUCTION_FORMAT31i[$INSTRUCTION_FORMAT31i_OR_ID] )
            int alt50 = 2;
            int LA50_0 = input.LA(1);
            if ((LA50_0 == INSTRUCTION_FORMAT31i)) {
                alt50 = 1;
            } else if ((LA50_0 == INSTRUCTION_FORMAT31i_OR_ID)) {
                alt50 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 50, 0, input);
                throw nvae;
            }

            switch (alt50) {
                case 1:
                    // smaliParser.g:796:5: INSTRUCTION_FORMAT31i
                {
                    root_0 = (CommonTree) adaptor.nil();


                    INSTRUCTION_FORMAT31i239 = (Token) match(input, INSTRUCTION_FORMAT31i, FOLLOW_INSTRUCTION_FORMAT31i_in_instruction_format31i3717);
                    INSTRUCTION_FORMAT31i239_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT31i239);
                    adaptor.addChild(root_0, INSTRUCTION_FORMAT31i239_tree);

                }
                break;
                case 2:
                    // smaliParser.g:797:5: INSTRUCTION_FORMAT31i_OR_ID
                {
                    INSTRUCTION_FORMAT31i_OR_ID240 = (Token) match(input, INSTRUCTION_FORMAT31i_OR_ID, FOLLOW_INSTRUCTION_FORMAT31i_OR_ID_in_instruction_format31i3723);
                    stream_INSTRUCTION_FORMAT31i_OR_ID.add(INSTRUCTION_FORMAT31i_OR_ID240);

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 797:33: -> INSTRUCTION_FORMAT31i[$INSTRUCTION_FORMAT31i_OR_ID]
                    {
                        adaptor.addChild(root_0, (CommonTree) adaptor.create(INSTRUCTION_FORMAT31i, INSTRUCTION_FORMAT31i_OR_ID240));
                    }


                    retval.tree = root_0;

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instruction_format31i"


    public static class instruction_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "instruction"
    // smaliParser.g:801:1: instruction : ( insn_format10t | insn_format10x | insn_format10x_odex | insn_format11n | insn_format11x | insn_format12x | insn_format20bc | insn_format20t | insn_format21c_field | insn_format21c_field_odex | insn_format21c_string | insn_format21c_type | insn_format21ih | insn_format21lh | insn_format21s | insn_format21t | insn_format22b | insn_format22c_field | insn_format22c_field_odex | insn_format22c_type | insn_format22cs_field | insn_format22s | insn_format22t | insn_format22x | insn_format23x | insn_format30t | insn_format31c | insn_format31i | insn_format31t | insn_format32x | insn_format35c_method | insn_format35c_type | insn_format35c_method_odex | insn_format35mi_method | insn_format35ms_method | insn_format3rc_method | insn_format3rc_method_odex | insn_format3rc_type | insn_format3rmi_method | insn_format3rms_method | insn_format45cc_method | insn_format4rcc_method | insn_format51l | insn_array_data_directive | insn_packed_switch_directive | insn_sparse_switch_directive );
    public final smaliParser.instruction_return instruction() throws RecognitionException {
        smaliParser.instruction_return retval = new smaliParser.instruction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ParserRuleReturnScope insn_format10t241 = null;
        ParserRuleReturnScope insn_format10x242 = null;
        ParserRuleReturnScope insn_format10x_odex243 = null;
        ParserRuleReturnScope insn_format11n244 = null;
        ParserRuleReturnScope insn_format11x245 = null;
        ParserRuleReturnScope insn_format12x246 = null;
        ParserRuleReturnScope insn_format20bc247 = null;
        ParserRuleReturnScope insn_format20t248 = null;
        ParserRuleReturnScope insn_format21c_field249 = null;
        ParserRuleReturnScope insn_format21c_field_odex250 = null;
        ParserRuleReturnScope insn_format21c_string251 = null;
        ParserRuleReturnScope insn_format21c_type252 = null;
        ParserRuleReturnScope insn_format21ih253 = null;
        ParserRuleReturnScope insn_format21lh254 = null;
        ParserRuleReturnScope insn_format21s255 = null;
        ParserRuleReturnScope insn_format21t256 = null;
        ParserRuleReturnScope insn_format22b257 = null;
        ParserRuleReturnScope insn_format22c_field258 = null;
        ParserRuleReturnScope insn_format22c_field_odex259 = null;
        ParserRuleReturnScope insn_format22c_type260 = null;
        ParserRuleReturnScope insn_format22cs_field261 = null;
        ParserRuleReturnScope insn_format22s262 = null;
        ParserRuleReturnScope insn_format22t263 = null;
        ParserRuleReturnScope insn_format22x264 = null;
        ParserRuleReturnScope insn_format23x265 = null;
        ParserRuleReturnScope insn_format30t266 = null;
        ParserRuleReturnScope insn_format31c267 = null;
        ParserRuleReturnScope insn_format31i268 = null;
        ParserRuleReturnScope insn_format31t269 = null;
        ParserRuleReturnScope insn_format32x270 = null;
        ParserRuleReturnScope insn_format35c_method271 = null;
        ParserRuleReturnScope insn_format35c_type272 = null;
        ParserRuleReturnScope insn_format35c_method_odex273 = null;
        ParserRuleReturnScope insn_format35mi_method274 = null;
        ParserRuleReturnScope insn_format35ms_method275 = null;
        ParserRuleReturnScope insn_format3rc_method276 = null;
        ParserRuleReturnScope insn_format3rc_method_odex277 = null;
        ParserRuleReturnScope insn_format3rc_type278 = null;
        ParserRuleReturnScope insn_format3rmi_method279 = null;
        ParserRuleReturnScope insn_format3rms_method280 = null;
        ParserRuleReturnScope insn_format45cc_method281 = null;
        ParserRuleReturnScope insn_format4rcc_method282 = null;
        ParserRuleReturnScope insn_format51l283 = null;
        ParserRuleReturnScope insn_array_data_directive284 = null;
        ParserRuleReturnScope insn_packed_switch_directive285 = null;
        ParserRuleReturnScope insn_sparse_switch_directive286 = null;


        try {
            // smaliParser.g:802:3: ( insn_format10t | insn_format10x | insn_format10x_odex | insn_format11n | insn_format11x | insn_format12x | insn_format20bc | insn_format20t | insn_format21c_field | insn_format21c_field_odex | insn_format21c_string | insn_format21c_type | insn_format21ih | insn_format21lh | insn_format21s | insn_format21t | insn_format22b | insn_format22c_field | insn_format22c_field_odex | insn_format22c_type | insn_format22cs_field | insn_format22s | insn_format22t | insn_format22x | insn_format23x | insn_format30t | insn_format31c | insn_format31i | insn_format31t | insn_format32x | insn_format35c_method | insn_format35c_type | insn_format35c_method_odex | insn_format35mi_method | insn_format35ms_method | insn_format3rc_method | insn_format3rc_method_odex | insn_format3rc_type | insn_format3rmi_method | insn_format3rms_method | insn_format45cc_method | insn_format4rcc_method | insn_format51l | insn_array_data_directive | insn_packed_switch_directive | insn_sparse_switch_directive )
            int alt51 = 46;
            switch (input.LA(1)) {
                case INSTRUCTION_FORMAT10t: {
                    alt51 = 1;
                }
                break;
                case INSTRUCTION_FORMAT10x: {
                    alt51 = 2;
                }
                break;
                case INSTRUCTION_FORMAT10x_ODEX: {
                    alt51 = 3;
                }
                break;
                case INSTRUCTION_FORMAT11n: {
                    alt51 = 4;
                }
                break;
                case INSTRUCTION_FORMAT11x: {
                    alt51 = 5;
                }
                break;
                case INSTRUCTION_FORMAT12x:
                case INSTRUCTION_FORMAT12x_OR_ID: {
                    alt51 = 6;
                }
                break;
                case INSTRUCTION_FORMAT20bc: {
                    alt51 = 7;
                }
                break;
                case INSTRUCTION_FORMAT20t: {
                    alt51 = 8;
                }
                break;
                case INSTRUCTION_FORMAT21c_FIELD: {
                    alt51 = 9;
                }
                break;
                case INSTRUCTION_FORMAT21c_FIELD_ODEX: {
                    alt51 = 10;
                }
                break;
                case INSTRUCTION_FORMAT21c_STRING: {
                    alt51 = 11;
                }
                break;
                case INSTRUCTION_FORMAT21c_TYPE: {
                    alt51 = 12;
                }
                break;
                case INSTRUCTION_FORMAT21ih: {
                    alt51 = 13;
                }
                break;
                case INSTRUCTION_FORMAT21lh: {
                    alt51 = 14;
                }
                break;
                case INSTRUCTION_FORMAT21s: {
                    alt51 = 15;
                }
                break;
                case INSTRUCTION_FORMAT21t: {
                    alt51 = 16;
                }
                break;
                case INSTRUCTION_FORMAT22b: {
                    alt51 = 17;
                }
                break;
                case INSTRUCTION_FORMAT22c_FIELD: {
                    alt51 = 18;
                }
                break;
                case INSTRUCTION_FORMAT22c_FIELD_ODEX: {
                    alt51 = 19;
                }
                break;
                case INSTRUCTION_FORMAT22c_TYPE: {
                    alt51 = 20;
                }
                break;
                case INSTRUCTION_FORMAT22cs_FIELD: {
                    alt51 = 21;
                }
                break;
                case INSTRUCTION_FORMAT22s:
                case INSTRUCTION_FORMAT22s_OR_ID: {
                    alt51 = 22;
                }
                break;
                case INSTRUCTION_FORMAT22t: {
                    alt51 = 23;
                }
                break;
                case INSTRUCTION_FORMAT22x: {
                    alt51 = 24;
                }
                break;
                case INSTRUCTION_FORMAT23x: {
                    alt51 = 25;
                }
                break;
                case INSTRUCTION_FORMAT30t: {
                    alt51 = 26;
                }
                break;
                case INSTRUCTION_FORMAT31c: {
                    alt51 = 27;
                }
                break;
                case INSTRUCTION_FORMAT31i:
                case INSTRUCTION_FORMAT31i_OR_ID: {
                    alt51 = 28;
                }
                break;
                case INSTRUCTION_FORMAT31t: {
                    alt51 = 29;
                }
                break;
                case INSTRUCTION_FORMAT32x: {
                    alt51 = 30;
                }
                break;
                case INSTRUCTION_FORMAT35c_METHOD: {
                    alt51 = 31;
                }
                break;
                case INSTRUCTION_FORMAT35c_TYPE: {
                    alt51 = 32;
                }
                break;
                case INSTRUCTION_FORMAT35c_METHOD_ODEX: {
                    alt51 = 33;
                }
                break;
                case INSTRUCTION_FORMAT35mi_METHOD: {
                    alt51 = 34;
                }
                break;
                case INSTRUCTION_FORMAT35ms_METHOD: {
                    alt51 = 35;
                }
                break;
                case INSTRUCTION_FORMAT3rc_METHOD: {
                    alt51 = 36;
                }
                break;
                case INSTRUCTION_FORMAT3rc_METHOD_ODEX: {
                    alt51 = 37;
                }
                break;
                case INSTRUCTION_FORMAT3rc_TYPE: {
                    alt51 = 38;
                }
                break;
                case INSTRUCTION_FORMAT3rmi_METHOD: {
                    alt51 = 39;
                }
                break;
                case INSTRUCTION_FORMAT3rms_METHOD: {
                    alt51 = 40;
                }
                break;
                case INSTRUCTION_FORMAT45cc_METHOD: {
                    alt51 = 41;
                }
                break;
                case INSTRUCTION_FORMAT4rcc_METHOD: {
                    alt51 = 42;
                }
                break;
                case INSTRUCTION_FORMAT51l: {
                    alt51 = 43;
                }
                break;
                case ARRAY_DATA_DIRECTIVE: {
                    alt51 = 44;
                }
                break;
                case PACKED_SWITCH_DIRECTIVE: {
                    alt51 = 45;
                }
                break;
                case SPARSE_SWITCH_DIRECTIVE: {
                    alt51 = 46;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);
                    throw nvae;
            }
            switch (alt51) {
                case 1:
                    // smaliParser.g:802:5: insn_format10t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format10t_in_instruction3740);
                    insn_format10t241 = insn_format10t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format10t241.getTree());

                }
                break;
                case 2:
                    // smaliParser.g:803:5: insn_format10x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format10x_in_instruction3746);
                    insn_format10x242 = insn_format10x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format10x242.getTree());

                }
                break;
                case 3:
                    // smaliParser.g:804:5: insn_format10x_odex
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format10x_odex_in_instruction3752);
                    insn_format10x_odex243 = insn_format10x_odex();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format10x_odex243.getTree());

                }
                break;
                case 4:
                    // smaliParser.g:805:5: insn_format11n
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format11n_in_instruction3758);
                    insn_format11n244 = insn_format11n();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format11n244.getTree());

                }
                break;
                case 5:
                    // smaliParser.g:806:5: insn_format11x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format11x_in_instruction3764);
                    insn_format11x245 = insn_format11x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format11x245.getTree());

                }
                break;
                case 6:
                    // smaliParser.g:807:5: insn_format12x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format12x_in_instruction3770);
                    insn_format12x246 = insn_format12x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format12x246.getTree());

                }
                break;
                case 7:
                    // smaliParser.g:808:5: insn_format20bc
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format20bc_in_instruction3776);
                    insn_format20bc247 = insn_format20bc();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format20bc247.getTree());

                }
                break;
                case 8:
                    // smaliParser.g:809:5: insn_format20t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format20t_in_instruction3782);
                    insn_format20t248 = insn_format20t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format20t248.getTree());

                }
                break;
                case 9:
                    // smaliParser.g:810:5: insn_format21c_field
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21c_field_in_instruction3788);
                    insn_format21c_field249 = insn_format21c_field();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21c_field249.getTree());

                }
                break;
                case 10:
                    // smaliParser.g:811:5: insn_format21c_field_odex
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21c_field_odex_in_instruction3794);
                    insn_format21c_field_odex250 = insn_format21c_field_odex();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21c_field_odex250.getTree());

                }
                break;
                case 11:
                    // smaliParser.g:812:5: insn_format21c_string
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21c_string_in_instruction3800);
                    insn_format21c_string251 = insn_format21c_string();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21c_string251.getTree());

                }
                break;
                case 12:
                    // smaliParser.g:813:5: insn_format21c_type
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21c_type_in_instruction3806);
                    insn_format21c_type252 = insn_format21c_type();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21c_type252.getTree());

                }
                break;
                case 13:
                    // smaliParser.g:814:5: insn_format21ih
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21ih_in_instruction3812);
                    insn_format21ih253 = insn_format21ih();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21ih253.getTree());

                }
                break;
                case 14:
                    // smaliParser.g:815:5: insn_format21lh
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21lh_in_instruction3818);
                    insn_format21lh254 = insn_format21lh();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21lh254.getTree());

                }
                break;
                case 15:
                    // smaliParser.g:816:5: insn_format21s
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21s_in_instruction3824);
                    insn_format21s255 = insn_format21s();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21s255.getTree());

                }
                break;
                case 16:
                    // smaliParser.g:817:5: insn_format21t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format21t_in_instruction3830);
                    insn_format21t256 = insn_format21t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format21t256.getTree());

                }
                break;
                case 17:
                    // smaliParser.g:818:5: insn_format22b
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22b_in_instruction3836);
                    insn_format22b257 = insn_format22b();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22b257.getTree());

                }
                break;
                case 18:
                    // smaliParser.g:819:5: insn_format22c_field
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22c_field_in_instruction3842);
                    insn_format22c_field258 = insn_format22c_field();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22c_field258.getTree());

                }
                break;
                case 19:
                    // smaliParser.g:820:5: insn_format22c_field_odex
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22c_field_odex_in_instruction3848);
                    insn_format22c_field_odex259 = insn_format22c_field_odex();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22c_field_odex259.getTree());

                }
                break;
                case 20:
                    // smaliParser.g:821:5: insn_format22c_type
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22c_type_in_instruction3854);
                    insn_format22c_type260 = insn_format22c_type();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22c_type260.getTree());

                }
                break;
                case 21:
                    // smaliParser.g:822:5: insn_format22cs_field
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22cs_field_in_instruction3860);
                    insn_format22cs_field261 = insn_format22cs_field();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22cs_field261.getTree());

                }
                break;
                case 22:
                    // smaliParser.g:823:5: insn_format22s
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22s_in_instruction3866);
                    insn_format22s262 = insn_format22s();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22s262.getTree());

                }
                break;
                case 23:
                    // smaliParser.g:824:5: insn_format22t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22t_in_instruction3872);
                    insn_format22t263 = insn_format22t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22t263.getTree());

                }
                break;
                case 24:
                    // smaliParser.g:825:5: insn_format22x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format22x_in_instruction3878);
                    insn_format22x264 = insn_format22x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format22x264.getTree());

                }
                break;
                case 25:
                    // smaliParser.g:826:5: insn_format23x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format23x_in_instruction3884);
                    insn_format23x265 = insn_format23x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format23x265.getTree());

                }
                break;
                case 26:
                    // smaliParser.g:827:5: insn_format30t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format30t_in_instruction3890);
                    insn_format30t266 = insn_format30t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format30t266.getTree());

                }
                break;
                case 27:
                    // smaliParser.g:828:5: insn_format31c
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format31c_in_instruction3896);
                    insn_format31c267 = insn_format31c();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format31c267.getTree());

                }
                break;
                case 28:
                    // smaliParser.g:829:5: insn_format31i
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format31i_in_instruction3902);
                    insn_format31i268 = insn_format31i();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format31i268.getTree());

                }
                break;
                case 29:
                    // smaliParser.g:830:5: insn_format31t
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format31t_in_instruction3908);
                    insn_format31t269 = insn_format31t();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format31t269.getTree());

                }
                break;
                case 30:
                    // smaliParser.g:831:5: insn_format32x
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format32x_in_instruction3914);
                    insn_format32x270 = insn_format32x();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format32x270.getTree());

                }
                break;
                case 31:
                    // smaliParser.g:832:5: insn_format35c_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format35c_method_in_instruction3920);
                    insn_format35c_method271 = insn_format35c_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format35c_method271.getTree());

                }
                break;
                case 32:
                    // smaliParser.g:833:5: insn_format35c_type
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format35c_type_in_instruction3926);
                    insn_format35c_type272 = insn_format35c_type();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format35c_type272.getTree());

                }
                break;
                case 33:
                    // smaliParser.g:834:5: insn_format35c_method_odex
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format35c_method_odex_in_instruction3932);
                    insn_format35c_method_odex273 = insn_format35c_method_odex();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format35c_method_odex273.getTree());

                }
                break;
                case 34:
                    // smaliParser.g:835:5: insn_format35mi_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format35mi_method_in_instruction3938);
                    insn_format35mi_method274 = insn_format35mi_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format35mi_method274.getTree());

                }
                break;
                case 35:
                    // smaliParser.g:836:5: insn_format35ms_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format35ms_method_in_instruction3944);
                    insn_format35ms_method275 = insn_format35ms_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format35ms_method275.getTree());

                }
                break;
                case 36:
                    // smaliParser.g:837:5: insn_format3rc_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format3rc_method_in_instruction3950);
                    insn_format3rc_method276 = insn_format3rc_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format3rc_method276.getTree());

                }
                break;
                case 37:
                    // smaliParser.g:838:5: insn_format3rc_method_odex
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format3rc_method_odex_in_instruction3956);
                    insn_format3rc_method_odex277 = insn_format3rc_method_odex();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format3rc_method_odex277.getTree());

                }
                break;
                case 38:
                    // smaliParser.g:839:5: insn_format3rc_type
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format3rc_type_in_instruction3962);
                    insn_format3rc_type278 = insn_format3rc_type();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format3rc_type278.getTree());

                }
                break;
                case 39:
                    // smaliParser.g:840:5: insn_format3rmi_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format3rmi_method_in_instruction3968);
                    insn_format3rmi_method279 = insn_format3rmi_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format3rmi_method279.getTree());

                }
                break;
                case 40:
                    // smaliParser.g:841:5: insn_format3rms_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format3rms_method_in_instruction3974);
                    insn_format3rms_method280 = insn_format3rms_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format3rms_method280.getTree());

                }
                break;
                case 41:
                    // smaliParser.g:842:5: insn_format45cc_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format45cc_method_in_instruction3980);
                    insn_format45cc_method281 = insn_format45cc_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format45cc_method281.getTree());

                }
                break;
                case 42:
                    // smaliParser.g:843:5: insn_format4rcc_method
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format4rcc_method_in_instruction3986);
                    insn_format4rcc_method282 = insn_format4rcc_method();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format4rcc_method282.getTree());

                }
                break;
                case 43:
                    // smaliParser.g:844:5: insn_format51l
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_format51l_in_instruction3992);
                    insn_format51l283 = insn_format51l();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_format51l283.getTree());

                }
                break;
                case 44:
                    // smaliParser.g:845:5: insn_array_data_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_array_data_directive_in_instruction3998);
                    insn_array_data_directive284 = insn_array_data_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_array_data_directive284.getTree());

                }
                break;
                case 45:
                    // smaliParser.g:846:5: insn_packed_switch_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_packed_switch_directive_in_instruction4004);
                    insn_packed_switch_directive285 = insn_packed_switch_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_packed_switch_directive285.getTree());

                }
                break;
                case 46:
                    // smaliParser.g:847:5: insn_sparse_switch_directive
                {
                    root_0 = (CommonTree) adaptor.nil();


                    pushFollow(FOLLOW_insn_sparse_switch_directive_in_instruction4010);
                    insn_sparse_switch_directive286 = insn_sparse_switch_directive();
                    state._fsp--;

                    adaptor.addChild(root_0, insn_sparse_switch_directive286.getTree());

                }
                break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instruction"


    public static class insn_format10t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format10t"
    // smaliParser.g:849:1: insn_format10t : INSTRUCTION_FORMAT10t label_ref -> ^( I_STATEMENT_FORMAT10t[$start, \"I_STATEMENT_FORMAT10t\"] INSTRUCTION_FORMAT10t label_ref ) ;
    public final smaliParser.insn_format10t_return insn_format10t() throws RecognitionException {
        smaliParser.insn_format10t_return retval = new smaliParser.insn_format10t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT10t287 = null;
        ParserRuleReturnScope label_ref288 = null;

        CommonTree INSTRUCTION_FORMAT10t287_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT10t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT10t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:850:3: ( INSTRUCTION_FORMAT10t label_ref -> ^( I_STATEMENT_FORMAT10t[$start, \"I_STATEMENT_FORMAT10t\"] INSTRUCTION_FORMAT10t label_ref ) )
            // smaliParser.g:852:5: INSTRUCTION_FORMAT10t label_ref
            {
                INSTRUCTION_FORMAT10t287 = (Token) match(input, INSTRUCTION_FORMAT10t, FOLLOW_INSTRUCTION_FORMAT10t_in_insn_format10t4030);
                stream_INSTRUCTION_FORMAT10t.add(INSTRUCTION_FORMAT10t287);

                pushFollow(FOLLOW_label_ref_in_insn_format10t4032);
                label_ref288 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref288.getTree());
                // AST REWRITE
                // elements: label_ref, INSTRUCTION_FORMAT10t
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 853:5: -> ^( I_STATEMENT_FORMAT10t[$start, \"I_STATEMENT_FORMAT10t\"] INSTRUCTION_FORMAT10t label_ref )
                {
                    // smaliParser.g:853:8: ^( I_STATEMENT_FORMAT10t[$start, \"I_STATEMENT_FORMAT10t\"] INSTRUCTION_FORMAT10t label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT10t, (retval.start), "I_STATEMENT_FORMAT10t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT10t.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format10t"


    public static class insn_format10x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format10x"
    // smaliParser.g:855:1: insn_format10x : INSTRUCTION_FORMAT10x -> ^( I_STATEMENT_FORMAT10x[$start, \"I_STATEMENT_FORMAT10x\"] INSTRUCTION_FORMAT10x ) ;
    public final smaliParser.insn_format10x_return insn_format10x() throws RecognitionException {
        smaliParser.insn_format10x_return retval = new smaliParser.insn_format10x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT10x289 = null;

        CommonTree INSTRUCTION_FORMAT10x289_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT10x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT10x");

        try {
            // smaliParser.g:856:3: ( INSTRUCTION_FORMAT10x -> ^( I_STATEMENT_FORMAT10x[$start, \"I_STATEMENT_FORMAT10x\"] INSTRUCTION_FORMAT10x ) )
            // smaliParser.g:857:5: INSTRUCTION_FORMAT10x
            {
                INSTRUCTION_FORMAT10x289 = (Token) match(input, INSTRUCTION_FORMAT10x, FOLLOW_INSTRUCTION_FORMAT10x_in_insn_format10x4062);
                stream_INSTRUCTION_FORMAT10x.add(INSTRUCTION_FORMAT10x289);

                // AST REWRITE
                // elements: INSTRUCTION_FORMAT10x
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 858:5: -> ^( I_STATEMENT_FORMAT10x[$start, \"I_STATEMENT_FORMAT10x\"] INSTRUCTION_FORMAT10x )
                {
                    // smaliParser.g:858:8: ^( I_STATEMENT_FORMAT10x[$start, \"I_STATEMENT_FORMAT10x\"] INSTRUCTION_FORMAT10x )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT10x, (retval.start), "I_STATEMENT_FORMAT10x"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT10x.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format10x"


    public static class insn_format10x_odex_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format10x_odex"
    // smaliParser.g:860:1: insn_format10x_odex : INSTRUCTION_FORMAT10x_ODEX ;
    public final smaliParser.insn_format10x_odex_return insn_format10x_odex() throws RecognitionException {
        smaliParser.insn_format10x_odex_return retval = new smaliParser.insn_format10x_odex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT10x_ODEX290 = null;

        CommonTree INSTRUCTION_FORMAT10x_ODEX290_tree = null;

        try {
            // smaliParser.g:861:3: ( INSTRUCTION_FORMAT10x_ODEX )
            // smaliParser.g:862:5: INSTRUCTION_FORMAT10x_ODEX
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT10x_ODEX290 = (Token) match(input, INSTRUCTION_FORMAT10x_ODEX, FOLLOW_INSTRUCTION_FORMAT10x_ODEX_in_insn_format10x_odex4090);
                INSTRUCTION_FORMAT10x_ODEX290_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT10x_ODEX290);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT10x_ODEX290_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT10x_ODEX290 != null ? INSTRUCTION_FORMAT10x_ODEX290.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format10x_odex"


    public static class insn_format11n_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format11n"
    // smaliParser.g:867:1: insn_format11n : INSTRUCTION_FORMAT11n REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT11n[$start, \"I_STATEMENT_FORMAT11n\"] INSTRUCTION_FORMAT11n REGISTER integral_literal ) ;
    public final smaliParser.insn_format11n_return insn_format11n() throws RecognitionException {
        smaliParser.insn_format11n_return retval = new smaliParser.insn_format11n_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT11n291 = null;
        Token REGISTER292 = null;
        Token COMMA293 = null;
        ParserRuleReturnScope integral_literal294 = null;

        CommonTree INSTRUCTION_FORMAT11n291_tree = null;
        CommonTree REGISTER292_tree = null;
        CommonTree COMMA293_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT11n = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT11n");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:868:3: ( INSTRUCTION_FORMAT11n REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT11n[$start, \"I_STATEMENT_FORMAT11n\"] INSTRUCTION_FORMAT11n REGISTER integral_literal ) )
            // smaliParser.g:869:5: INSTRUCTION_FORMAT11n REGISTER COMMA integral_literal
            {
                INSTRUCTION_FORMAT11n291 = (Token) match(input, INSTRUCTION_FORMAT11n, FOLLOW_INSTRUCTION_FORMAT11n_in_insn_format11n4111);
                stream_INSTRUCTION_FORMAT11n.add(INSTRUCTION_FORMAT11n291);

                REGISTER292 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format11n4113);
                stream_REGISTER.add(REGISTER292);

                COMMA293 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format11n4115);
                stream_COMMA.add(COMMA293);

                pushFollow(FOLLOW_integral_literal_in_insn_format11n4117);
                integral_literal294 = integral_literal();
                state._fsp--;

                stream_integral_literal.add(integral_literal294.getTree());
                // AST REWRITE
                // elements: REGISTER, INSTRUCTION_FORMAT11n, integral_literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 870:5: -> ^( I_STATEMENT_FORMAT11n[$start, \"I_STATEMENT_FORMAT11n\"] INSTRUCTION_FORMAT11n REGISTER integral_literal )
                {
                    // smaliParser.g:870:8: ^( I_STATEMENT_FORMAT11n[$start, \"I_STATEMENT_FORMAT11n\"] INSTRUCTION_FORMAT11n REGISTER integral_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT11n, (retval.start), "I_STATEMENT_FORMAT11n"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT11n.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_integral_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format11n"


    public static class insn_format11x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format11x"
    // smaliParser.g:872:1: insn_format11x : INSTRUCTION_FORMAT11x REGISTER -> ^( I_STATEMENT_FORMAT11x[$start, \"I_STATEMENT_FORMAT11x\"] INSTRUCTION_FORMAT11x REGISTER ) ;
    public final smaliParser.insn_format11x_return insn_format11x() throws RecognitionException {
        smaliParser.insn_format11x_return retval = new smaliParser.insn_format11x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT11x295 = null;
        Token REGISTER296 = null;

        CommonTree INSTRUCTION_FORMAT11x295_tree = null;
        CommonTree REGISTER296_tree = null;
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT11x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT11x");

        try {
            // smaliParser.g:873:3: ( INSTRUCTION_FORMAT11x REGISTER -> ^( I_STATEMENT_FORMAT11x[$start, \"I_STATEMENT_FORMAT11x\"] INSTRUCTION_FORMAT11x REGISTER ) )
            // smaliParser.g:874:5: INSTRUCTION_FORMAT11x REGISTER
            {
                INSTRUCTION_FORMAT11x295 = (Token) match(input, INSTRUCTION_FORMAT11x, FOLLOW_INSTRUCTION_FORMAT11x_in_insn_format11x4149);
                stream_INSTRUCTION_FORMAT11x.add(INSTRUCTION_FORMAT11x295);

                REGISTER296 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format11x4151);
                stream_REGISTER.add(REGISTER296);

                // AST REWRITE
                // elements: REGISTER, INSTRUCTION_FORMAT11x
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 875:5: -> ^( I_STATEMENT_FORMAT11x[$start, \"I_STATEMENT_FORMAT11x\"] INSTRUCTION_FORMAT11x REGISTER )
                {
                    // smaliParser.g:875:8: ^( I_STATEMENT_FORMAT11x[$start, \"I_STATEMENT_FORMAT11x\"] INSTRUCTION_FORMAT11x REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT11x, (retval.start), "I_STATEMENT_FORMAT11x"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT11x.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format11x"


    public static class insn_format12x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format12x"
    // smaliParser.g:877:1: insn_format12x : instruction_format12x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT12x[$start, \"I_STATEMENT_FORMAT12x\"] instruction_format12x REGISTER REGISTER ) ;
    public final smaliParser.insn_format12x_return insn_format12x() throws RecognitionException {
        smaliParser.insn_format12x_return retval = new smaliParser.insn_format12x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REGISTER298 = null;
        Token COMMA299 = null;
        Token REGISTER300 = null;
        ParserRuleReturnScope instruction_format12x297 = null;

        CommonTree REGISTER298_tree = null;
        CommonTree COMMA299_tree = null;
        CommonTree REGISTER300_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleSubtreeStream stream_instruction_format12x = new RewriteRuleSubtreeStream(adaptor, "rule instruction_format12x");

        try {
            // smaliParser.g:878:3: ( instruction_format12x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT12x[$start, \"I_STATEMENT_FORMAT12x\"] instruction_format12x REGISTER REGISTER ) )
            // smaliParser.g:879:5: instruction_format12x REGISTER COMMA REGISTER
            {
                pushFollow(FOLLOW_instruction_format12x_in_insn_format12x4181);
                instruction_format12x297 = instruction_format12x();
                state._fsp--;

                stream_instruction_format12x.add(instruction_format12x297.getTree());
                REGISTER298 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format12x4183);
                stream_REGISTER.add(REGISTER298);

                COMMA299 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format12x4185);
                stream_COMMA.add(COMMA299);

                REGISTER300 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format12x4187);
                stream_REGISTER.add(REGISTER300);

                // AST REWRITE
                // elements: instruction_format12x, REGISTER, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 880:5: -> ^( I_STATEMENT_FORMAT12x[$start, \"I_STATEMENT_FORMAT12x\"] instruction_format12x REGISTER REGISTER )
                {
                    // smaliParser.g:880:8: ^( I_STATEMENT_FORMAT12x[$start, \"I_STATEMENT_FORMAT12x\"] instruction_format12x REGISTER REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT12x, (retval.start), "I_STATEMENT_FORMAT12x"), root_1);
                        adaptor.addChild(root_1, stream_instruction_format12x.nextTree());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format12x"


    public static class insn_format20bc_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format20bc"
    // smaliParser.g:882:1: insn_format20bc : INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE COMMA verification_error_reference -> ^( I_STATEMENT_FORMAT20bc INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE verification_error_reference ) ;
    public final smaliParser.insn_format20bc_return insn_format20bc() throws RecognitionException {
        smaliParser.insn_format20bc_return retval = new smaliParser.insn_format20bc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT20bc301 = null;
        Token VERIFICATION_ERROR_TYPE302 = null;
        Token COMMA303 = null;
        ParserRuleReturnScope verification_error_reference304 = null;

        CommonTree INSTRUCTION_FORMAT20bc301_tree = null;
        CommonTree VERIFICATION_ERROR_TYPE302_tree = null;
        CommonTree COMMA303_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_VERIFICATION_ERROR_TYPE = new RewriteRuleTokenStream(adaptor, "token VERIFICATION_ERROR_TYPE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT20bc = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT20bc");
        RewriteRuleSubtreeStream stream_verification_error_reference = new RewriteRuleSubtreeStream(adaptor, "rule verification_error_reference");

        try {
            // smaliParser.g:883:3: ( INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE COMMA verification_error_reference -> ^( I_STATEMENT_FORMAT20bc INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE verification_error_reference ) )
            // smaliParser.g:884:5: INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE COMMA verification_error_reference
            {
                INSTRUCTION_FORMAT20bc301 = (Token) match(input, INSTRUCTION_FORMAT20bc, FOLLOW_INSTRUCTION_FORMAT20bc_in_insn_format20bc4219);
                stream_INSTRUCTION_FORMAT20bc.add(INSTRUCTION_FORMAT20bc301);

                VERIFICATION_ERROR_TYPE302 = (Token) match(input, VERIFICATION_ERROR_TYPE, FOLLOW_VERIFICATION_ERROR_TYPE_in_insn_format20bc4221);
                stream_VERIFICATION_ERROR_TYPE.add(VERIFICATION_ERROR_TYPE302);

                COMMA303 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format20bc4223);
                stream_COMMA.add(COMMA303);

                pushFollow(FOLLOW_verification_error_reference_in_insn_format20bc4225);
                verification_error_reference304 = verification_error_reference();
                state._fsp--;

                stream_verification_error_reference.add(verification_error_reference304.getTree());

                if (!allowOdex || opcodes.getOpcodeByName((INSTRUCTION_FORMAT20bc301 != null ? INSTRUCTION_FORMAT20bc301.getText() : null)) == null || apiLevel >= 14) {
                    throwOdexedInstructionException(input, (INSTRUCTION_FORMAT20bc301 != null ? INSTRUCTION_FORMAT20bc301.getText() : null));
                }

                // AST REWRITE
                // elements: INSTRUCTION_FORMAT20bc, VERIFICATION_ERROR_TYPE, verification_error_reference
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 890:5: -> ^( I_STATEMENT_FORMAT20bc INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE verification_error_reference )
                {
                    // smaliParser.g:890:8: ^( I_STATEMENT_FORMAT20bc INSTRUCTION_FORMAT20bc VERIFICATION_ERROR_TYPE verification_error_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT20bc, "I_STATEMENT_FORMAT20bc"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT20bc.nextNode());
                        adaptor.addChild(root_1, stream_VERIFICATION_ERROR_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_verification_error_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format20bc"


    public static class insn_format20t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format20t"
    // smaliParser.g:892:1: insn_format20t : INSTRUCTION_FORMAT20t label_ref -> ^( I_STATEMENT_FORMAT20t[$start, \"I_STATEMENT_FORMAT20t\"] INSTRUCTION_FORMAT20t label_ref ) ;
    public final smaliParser.insn_format20t_return insn_format20t() throws RecognitionException {
        smaliParser.insn_format20t_return retval = new smaliParser.insn_format20t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT20t305 = null;
        ParserRuleReturnScope label_ref306 = null;

        CommonTree INSTRUCTION_FORMAT20t305_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT20t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT20t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:893:3: ( INSTRUCTION_FORMAT20t label_ref -> ^( I_STATEMENT_FORMAT20t[$start, \"I_STATEMENT_FORMAT20t\"] INSTRUCTION_FORMAT20t label_ref ) )
            // smaliParser.g:894:5: INSTRUCTION_FORMAT20t label_ref
            {
                INSTRUCTION_FORMAT20t305 = (Token) match(input, INSTRUCTION_FORMAT20t, FOLLOW_INSTRUCTION_FORMAT20t_in_insn_format20t4262);
                stream_INSTRUCTION_FORMAT20t.add(INSTRUCTION_FORMAT20t305);

                pushFollow(FOLLOW_label_ref_in_insn_format20t4264);
                label_ref306 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref306.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT20t, label_ref
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 895:5: -> ^( I_STATEMENT_FORMAT20t[$start, \"I_STATEMENT_FORMAT20t\"] INSTRUCTION_FORMAT20t label_ref )
                {
                    // smaliParser.g:895:8: ^( I_STATEMENT_FORMAT20t[$start, \"I_STATEMENT_FORMAT20t\"] INSTRUCTION_FORMAT20t label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT20t, (retval.start), "I_STATEMENT_FORMAT20t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT20t.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format20t"


    public static class insn_format21c_field_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21c_field"
    // smaliParser.g:897:1: insn_format21c_field : INSTRUCTION_FORMAT21c_FIELD REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD REGISTER field_reference ) ;
    public final smaliParser.insn_format21c_field_return insn_format21c_field() throws RecognitionException {
        smaliParser.insn_format21c_field_return retval = new smaliParser.insn_format21c_field_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21c_FIELD307 = null;
        Token REGISTER308 = null;
        Token COMMA309 = null;
        ParserRuleReturnScope field_reference310 = null;

        CommonTree INSTRUCTION_FORMAT21c_FIELD307_tree = null;
        CommonTree REGISTER308_tree = null;
        CommonTree COMMA309_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_FIELD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_FIELD");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleSubtreeStream stream_field_reference = new RewriteRuleSubtreeStream(adaptor, "rule field_reference");

        try {
            // smaliParser.g:898:3: ( INSTRUCTION_FORMAT21c_FIELD REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD REGISTER field_reference ) )
            // smaliParser.g:899:5: INSTRUCTION_FORMAT21c_FIELD REGISTER COMMA field_reference
            {
                INSTRUCTION_FORMAT21c_FIELD307 = (Token) match(input, INSTRUCTION_FORMAT21c_FIELD, FOLLOW_INSTRUCTION_FORMAT21c_FIELD_in_insn_format21c_field4294);
                stream_INSTRUCTION_FORMAT21c_FIELD.add(INSTRUCTION_FORMAT21c_FIELD307);

                REGISTER308 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21c_field4296);
                stream_REGISTER.add(REGISTER308);

                COMMA309 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21c_field4298);
                stream_COMMA.add(COMMA309);

                pushFollow(FOLLOW_field_reference_in_insn_format21c_field4300);
                field_reference310 = field_reference();
                state._fsp--;

                stream_field_reference.add(field_reference310.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT21c_FIELD, field_reference, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 900:5: -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD REGISTER field_reference )
                {
                    // smaliParser.g:900:8: ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD REGISTER field_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21c_FIELD, (retval.start), "I_STATEMENT_FORMAT21c_FIELD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21c_FIELD.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_field_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21c_field"


    public static class insn_format21c_field_odex_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21c_field_odex"
    // smaliParser.g:902:1: insn_format21c_field_odex : INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER field_reference ) ;
    public final smaliParser.insn_format21c_field_odex_return insn_format21c_field_odex() throws RecognitionException {
        smaliParser.insn_format21c_field_odex_return retval = new smaliParser.insn_format21c_field_odex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21c_FIELD_ODEX311 = null;
        Token REGISTER312 = null;
        Token COMMA313 = null;
        ParserRuleReturnScope field_reference314 = null;

        CommonTree INSTRUCTION_FORMAT21c_FIELD_ODEX311_tree = null;
        CommonTree REGISTER312_tree = null;
        CommonTree COMMA313_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_FIELD_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_FIELD_ODEX");
        RewriteRuleSubtreeStream stream_field_reference = new RewriteRuleSubtreeStream(adaptor, "rule field_reference");

        try {
            // smaliParser.g:903:3: ( INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER field_reference ) )
            // smaliParser.g:904:5: INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER COMMA field_reference
            {
                INSTRUCTION_FORMAT21c_FIELD_ODEX311 = (Token) match(input, INSTRUCTION_FORMAT21c_FIELD_ODEX, FOLLOW_INSTRUCTION_FORMAT21c_FIELD_ODEX_in_insn_format21c_field_odex4332);
                stream_INSTRUCTION_FORMAT21c_FIELD_ODEX.add(INSTRUCTION_FORMAT21c_FIELD_ODEX311);

                REGISTER312 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21c_field_odex4334);
                stream_REGISTER.add(REGISTER312);

                COMMA313 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21c_field_odex4336);
                stream_COMMA.add(COMMA313);

                pushFollow(FOLLOW_field_reference_in_insn_format21c_field_odex4338);
                field_reference314 = field_reference();
                state._fsp--;

                stream_field_reference.add(field_reference314.getTree());

                if (!allowOdex || opcodes.getOpcodeByName((INSTRUCTION_FORMAT21c_FIELD_ODEX311 != null ? INSTRUCTION_FORMAT21c_FIELD_ODEX311.getText() : null)) == null || apiLevel >= 14) {
                    throwOdexedInstructionException(input, (INSTRUCTION_FORMAT21c_FIELD_ODEX311 != null ? INSTRUCTION_FORMAT21c_FIELD_ODEX311.getText() : null));
                }

                // AST REWRITE
                // elements: field_reference, REGISTER, INSTRUCTION_FORMAT21c_FIELD_ODEX
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 910:5: -> ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER field_reference )
                {
                    // smaliParser.g:910:8: ^( I_STATEMENT_FORMAT21c_FIELD[$start, \"I_STATEMENT_FORMAT21c_FIELD\"] INSTRUCTION_FORMAT21c_FIELD_ODEX REGISTER field_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21c_FIELD, (retval.start), "I_STATEMENT_FORMAT21c_FIELD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21c_FIELD_ODEX.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_field_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21c_field_odex"


    public static class insn_format21c_string_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21c_string"
    // smaliParser.g:912:1: insn_format21c_string : INSTRUCTION_FORMAT21c_STRING REGISTER COMMA STRING_LITERAL -> ^( I_STATEMENT_FORMAT21c_STRING[$start, \"I_STATEMENT_FORMAT21c_STRING\"] INSTRUCTION_FORMAT21c_STRING REGISTER STRING_LITERAL ) ;
    public final smaliParser.insn_format21c_string_return insn_format21c_string() throws RecognitionException {
        smaliParser.insn_format21c_string_return retval = new smaliParser.insn_format21c_string_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21c_STRING315 = null;
        Token REGISTER316 = null;
        Token COMMA317 = null;
        Token STRING_LITERAL318 = null;

        CommonTree INSTRUCTION_FORMAT21c_STRING315_tree = null;
        CommonTree REGISTER316_tree = null;
        CommonTree COMMA317_tree = null;
        CommonTree STRING_LITERAL318_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_STRING = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_STRING");

        try {
            // smaliParser.g:913:3: ( INSTRUCTION_FORMAT21c_STRING REGISTER COMMA STRING_LITERAL -> ^( I_STATEMENT_FORMAT21c_STRING[$start, \"I_STATEMENT_FORMAT21c_STRING\"] INSTRUCTION_FORMAT21c_STRING REGISTER STRING_LITERAL ) )
            // smaliParser.g:914:5: INSTRUCTION_FORMAT21c_STRING REGISTER COMMA STRING_LITERAL
            {
                INSTRUCTION_FORMAT21c_STRING315 = (Token) match(input, INSTRUCTION_FORMAT21c_STRING, FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_insn_format21c_string4376);
                stream_INSTRUCTION_FORMAT21c_STRING.add(INSTRUCTION_FORMAT21c_STRING315);

                REGISTER316 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21c_string4378);
                stream_REGISTER.add(REGISTER316);

                COMMA317 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21c_string4380);
                stream_COMMA.add(COMMA317);

                STRING_LITERAL318 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_insn_format21c_string4382);
                stream_STRING_LITERAL.add(STRING_LITERAL318);

                // AST REWRITE
                // elements: REGISTER, STRING_LITERAL, INSTRUCTION_FORMAT21c_STRING
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 915:5: -> ^( I_STATEMENT_FORMAT21c_STRING[$start, \"I_STATEMENT_FORMAT21c_STRING\"] INSTRUCTION_FORMAT21c_STRING REGISTER STRING_LITERAL )
                {
                    // smaliParser.g:915:8: ^( I_STATEMENT_FORMAT21c_STRING[$start, \"I_STATEMENT_FORMAT21c_STRING\"] INSTRUCTION_FORMAT21c_STRING REGISTER STRING_LITERAL )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21c_STRING, (retval.start), "I_STATEMENT_FORMAT21c_STRING"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21c_STRING.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21c_string"


    public static class insn_format21c_type_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21c_type"
    // smaliParser.g:917:1: insn_format21c_type : INSTRUCTION_FORMAT21c_TYPE REGISTER COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT21c_TYPE[$start, \"I_STATEMENT_FORMAT21c\"] INSTRUCTION_FORMAT21c_TYPE REGISTER nonvoid_type_descriptor ) ;
    public final smaliParser.insn_format21c_type_return insn_format21c_type() throws RecognitionException {
        smaliParser.insn_format21c_type_return retval = new smaliParser.insn_format21c_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21c_TYPE319 = null;
        Token REGISTER320 = null;
        Token COMMA321 = null;
        ParserRuleReturnScope nonvoid_type_descriptor322 = null;

        CommonTree INSTRUCTION_FORMAT21c_TYPE319_tree = null;
        CommonTree REGISTER320_tree = null;
        CommonTree COMMA321_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21c_TYPE");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");

        try {
            // smaliParser.g:918:3: ( INSTRUCTION_FORMAT21c_TYPE REGISTER COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT21c_TYPE[$start, \"I_STATEMENT_FORMAT21c\"] INSTRUCTION_FORMAT21c_TYPE REGISTER nonvoid_type_descriptor ) )
            // smaliParser.g:919:5: INSTRUCTION_FORMAT21c_TYPE REGISTER COMMA nonvoid_type_descriptor
            {
                INSTRUCTION_FORMAT21c_TYPE319 = (Token) match(input, INSTRUCTION_FORMAT21c_TYPE, FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_insn_format21c_type4414);
                stream_INSTRUCTION_FORMAT21c_TYPE.add(INSTRUCTION_FORMAT21c_TYPE319);

                REGISTER320 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21c_type4416);
                stream_REGISTER.add(REGISTER320);

                COMMA321 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21c_type4418);
                stream_COMMA.add(COMMA321);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format21c_type4420);
                nonvoid_type_descriptor322 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor322.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT21c_TYPE, nonvoid_type_descriptor, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 920:5: -> ^( I_STATEMENT_FORMAT21c_TYPE[$start, \"I_STATEMENT_FORMAT21c\"] INSTRUCTION_FORMAT21c_TYPE REGISTER nonvoid_type_descriptor )
                {
                    // smaliParser.g:920:8: ^( I_STATEMENT_FORMAT21c_TYPE[$start, \"I_STATEMENT_FORMAT21c\"] INSTRUCTION_FORMAT21c_TYPE REGISTER nonvoid_type_descriptor )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21c_TYPE, (retval.start), "I_STATEMENT_FORMAT21c"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21c_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21c_type"


    public static class insn_format21ih_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21ih"
    // smaliParser.g:922:1: insn_format21ih : INSTRUCTION_FORMAT21ih REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT21ih[$start, \"I_STATEMENT_FORMAT21ih\"] INSTRUCTION_FORMAT21ih REGISTER fixed_32bit_literal ) ;
    public final smaliParser.insn_format21ih_return insn_format21ih() throws RecognitionException {
        smaliParser.insn_format21ih_return retval = new smaliParser.insn_format21ih_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21ih323 = null;
        Token REGISTER324 = null;
        Token COMMA325 = null;
        ParserRuleReturnScope fixed_32bit_literal326 = null;

        CommonTree INSTRUCTION_FORMAT21ih323_tree = null;
        CommonTree REGISTER324_tree = null;
        CommonTree COMMA325_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21ih = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21ih");
        RewriteRuleSubtreeStream stream_fixed_32bit_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_32bit_literal");

        try {
            // smaliParser.g:923:3: ( INSTRUCTION_FORMAT21ih REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT21ih[$start, \"I_STATEMENT_FORMAT21ih\"] INSTRUCTION_FORMAT21ih REGISTER fixed_32bit_literal ) )
            // smaliParser.g:924:5: INSTRUCTION_FORMAT21ih REGISTER COMMA fixed_32bit_literal
            {
                INSTRUCTION_FORMAT21ih323 = (Token) match(input, INSTRUCTION_FORMAT21ih, FOLLOW_INSTRUCTION_FORMAT21ih_in_insn_format21ih4452);
                stream_INSTRUCTION_FORMAT21ih.add(INSTRUCTION_FORMAT21ih323);

                REGISTER324 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21ih4454);
                stream_REGISTER.add(REGISTER324);

                COMMA325 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21ih4456);
                stream_COMMA.add(COMMA325);

                pushFollow(FOLLOW_fixed_32bit_literal_in_insn_format21ih4458);
                fixed_32bit_literal326 = fixed_32bit_literal();
                state._fsp--;

                stream_fixed_32bit_literal.add(fixed_32bit_literal326.getTree());
                // AST REWRITE
                // elements: fixed_32bit_literal, REGISTER, INSTRUCTION_FORMAT21ih
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 925:5: -> ^( I_STATEMENT_FORMAT21ih[$start, \"I_STATEMENT_FORMAT21ih\"] INSTRUCTION_FORMAT21ih REGISTER fixed_32bit_literal )
                {
                    // smaliParser.g:925:8: ^( I_STATEMENT_FORMAT21ih[$start, \"I_STATEMENT_FORMAT21ih\"] INSTRUCTION_FORMAT21ih REGISTER fixed_32bit_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21ih, (retval.start), "I_STATEMENT_FORMAT21ih"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21ih.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_fixed_32bit_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21ih"


    public static class insn_format21lh_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21lh"
    // smaliParser.g:927:1: insn_format21lh : INSTRUCTION_FORMAT21lh REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT21lh[$start, \"I_STATEMENT_FORMAT21lh\"] INSTRUCTION_FORMAT21lh REGISTER fixed_32bit_literal ) ;
    public final smaliParser.insn_format21lh_return insn_format21lh() throws RecognitionException {
        smaliParser.insn_format21lh_return retval = new smaliParser.insn_format21lh_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21lh327 = null;
        Token REGISTER328 = null;
        Token COMMA329 = null;
        ParserRuleReturnScope fixed_32bit_literal330 = null;

        CommonTree INSTRUCTION_FORMAT21lh327_tree = null;
        CommonTree REGISTER328_tree = null;
        CommonTree COMMA329_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21lh = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21lh");
        RewriteRuleSubtreeStream stream_fixed_32bit_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_32bit_literal");

        try {
            // smaliParser.g:928:3: ( INSTRUCTION_FORMAT21lh REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT21lh[$start, \"I_STATEMENT_FORMAT21lh\"] INSTRUCTION_FORMAT21lh REGISTER fixed_32bit_literal ) )
            // smaliParser.g:929:5: INSTRUCTION_FORMAT21lh REGISTER COMMA fixed_32bit_literal
            {
                INSTRUCTION_FORMAT21lh327 = (Token) match(input, INSTRUCTION_FORMAT21lh, FOLLOW_INSTRUCTION_FORMAT21lh_in_insn_format21lh4490);
                stream_INSTRUCTION_FORMAT21lh.add(INSTRUCTION_FORMAT21lh327);

                REGISTER328 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21lh4492);
                stream_REGISTER.add(REGISTER328);

                COMMA329 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21lh4494);
                stream_COMMA.add(COMMA329);

                pushFollow(FOLLOW_fixed_32bit_literal_in_insn_format21lh4496);
                fixed_32bit_literal330 = fixed_32bit_literal();
                state._fsp--;

                stream_fixed_32bit_literal.add(fixed_32bit_literal330.getTree());
                // AST REWRITE
                // elements: fixed_32bit_literal, INSTRUCTION_FORMAT21lh, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 930:5: -> ^( I_STATEMENT_FORMAT21lh[$start, \"I_STATEMENT_FORMAT21lh\"] INSTRUCTION_FORMAT21lh REGISTER fixed_32bit_literal )
                {
                    // smaliParser.g:930:8: ^( I_STATEMENT_FORMAT21lh[$start, \"I_STATEMENT_FORMAT21lh\"] INSTRUCTION_FORMAT21lh REGISTER fixed_32bit_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21lh, (retval.start), "I_STATEMENT_FORMAT21lh"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21lh.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_fixed_32bit_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21lh"


    public static class insn_format21s_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21s"
    // smaliParser.g:932:1: insn_format21s : INSTRUCTION_FORMAT21s REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT21s[$start, \"I_STATEMENT_FORMAT21s\"] INSTRUCTION_FORMAT21s REGISTER integral_literal ) ;
    public final smaliParser.insn_format21s_return insn_format21s() throws RecognitionException {
        smaliParser.insn_format21s_return retval = new smaliParser.insn_format21s_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21s331 = null;
        Token REGISTER332 = null;
        Token COMMA333 = null;
        ParserRuleReturnScope integral_literal334 = null;

        CommonTree INSTRUCTION_FORMAT21s331_tree = null;
        CommonTree REGISTER332_tree = null;
        CommonTree COMMA333_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21s = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21s");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:933:3: ( INSTRUCTION_FORMAT21s REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT21s[$start, \"I_STATEMENT_FORMAT21s\"] INSTRUCTION_FORMAT21s REGISTER integral_literal ) )
            // smaliParser.g:934:5: INSTRUCTION_FORMAT21s REGISTER COMMA integral_literal
            {
                INSTRUCTION_FORMAT21s331 = (Token) match(input, INSTRUCTION_FORMAT21s, FOLLOW_INSTRUCTION_FORMAT21s_in_insn_format21s4528);
                stream_INSTRUCTION_FORMAT21s.add(INSTRUCTION_FORMAT21s331);

                REGISTER332 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21s4530);
                stream_REGISTER.add(REGISTER332);

                COMMA333 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21s4532);
                stream_COMMA.add(COMMA333);

                pushFollow(FOLLOW_integral_literal_in_insn_format21s4534);
                integral_literal334 = integral_literal();
                state._fsp--;

                stream_integral_literal.add(integral_literal334.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT21s, integral_literal, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 935:5: -> ^( I_STATEMENT_FORMAT21s[$start, \"I_STATEMENT_FORMAT21s\"] INSTRUCTION_FORMAT21s REGISTER integral_literal )
                {
                    // smaliParser.g:935:8: ^( I_STATEMENT_FORMAT21s[$start, \"I_STATEMENT_FORMAT21s\"] INSTRUCTION_FORMAT21s REGISTER integral_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21s, (retval.start), "I_STATEMENT_FORMAT21s"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21s.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_integral_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21s"


    public static class insn_format21t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format21t"
    // smaliParser.g:937:1: insn_format21t : INSTRUCTION_FORMAT21t REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT21t[$start, \"I_STATEMENT_FORMAT21t\"] INSTRUCTION_FORMAT21t REGISTER label_ref ) ;
    public final smaliParser.insn_format21t_return insn_format21t() throws RecognitionException {
        smaliParser.insn_format21t_return retval = new smaliParser.insn_format21t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT21t335 = null;
        Token REGISTER336 = null;
        Token COMMA337 = null;
        ParserRuleReturnScope label_ref338 = null;

        CommonTree INSTRUCTION_FORMAT21t335_tree = null;
        CommonTree REGISTER336_tree = null;
        CommonTree COMMA337_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT21t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT21t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:938:3: ( INSTRUCTION_FORMAT21t REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT21t[$start, \"I_STATEMENT_FORMAT21t\"] INSTRUCTION_FORMAT21t REGISTER label_ref ) )
            // smaliParser.g:939:5: INSTRUCTION_FORMAT21t REGISTER COMMA label_ref
            {
                INSTRUCTION_FORMAT21t335 = (Token) match(input, INSTRUCTION_FORMAT21t, FOLLOW_INSTRUCTION_FORMAT21t_in_insn_format21t4566);
                stream_INSTRUCTION_FORMAT21t.add(INSTRUCTION_FORMAT21t335);

                REGISTER336 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format21t4568);
                stream_REGISTER.add(REGISTER336);

                COMMA337 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format21t4570);
                stream_COMMA.add(COMMA337);

                pushFollow(FOLLOW_label_ref_in_insn_format21t4572);
                label_ref338 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref338.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT21t, REGISTER, label_ref
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 940:5: -> ^( I_STATEMENT_FORMAT21t[$start, \"I_STATEMENT_FORMAT21t\"] INSTRUCTION_FORMAT21t REGISTER label_ref )
                {
                    // smaliParser.g:940:8: ^( I_STATEMENT_FORMAT21t[$start, \"I_STATEMENT_FORMAT21t\"] INSTRUCTION_FORMAT21t REGISTER label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT21t, (retval.start), "I_STATEMENT_FORMAT21t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT21t.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format21t"


    public static class insn_format22b_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22b"
    // smaliParser.g:942:1: insn_format22b : INSTRUCTION_FORMAT22b REGISTER COMMA REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT22b[$start, \"I_STATEMENT_FORMAT22b\"] INSTRUCTION_FORMAT22b REGISTER REGISTER integral_literal ) ;
    public final smaliParser.insn_format22b_return insn_format22b() throws RecognitionException {
        smaliParser.insn_format22b_return retval = new smaliParser.insn_format22b_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22b339 = null;
        Token REGISTER340 = null;
        Token COMMA341 = null;
        Token REGISTER342 = null;
        Token COMMA343 = null;
        ParserRuleReturnScope integral_literal344 = null;

        CommonTree INSTRUCTION_FORMAT22b339_tree = null;
        CommonTree REGISTER340_tree = null;
        CommonTree COMMA341_tree = null;
        CommonTree REGISTER342_tree = null;
        CommonTree COMMA343_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22b = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22b");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:943:3: ( INSTRUCTION_FORMAT22b REGISTER COMMA REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT22b[$start, \"I_STATEMENT_FORMAT22b\"] INSTRUCTION_FORMAT22b REGISTER REGISTER integral_literal ) )
            // smaliParser.g:944:5: INSTRUCTION_FORMAT22b REGISTER COMMA REGISTER COMMA integral_literal
            {
                INSTRUCTION_FORMAT22b339 = (Token) match(input, INSTRUCTION_FORMAT22b, FOLLOW_INSTRUCTION_FORMAT22b_in_insn_format22b4604);
                stream_INSTRUCTION_FORMAT22b.add(INSTRUCTION_FORMAT22b339);

                REGISTER340 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22b4606);
                stream_REGISTER.add(REGISTER340);

                COMMA341 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22b4608);
                stream_COMMA.add(COMMA341);

                REGISTER342 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22b4610);
                stream_REGISTER.add(REGISTER342);

                COMMA343 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22b4612);
                stream_COMMA.add(COMMA343);

                pushFollow(FOLLOW_integral_literal_in_insn_format22b4614);
                integral_literal344 = integral_literal();
                state._fsp--;

                stream_integral_literal.add(integral_literal344.getTree());
                // AST REWRITE
                // elements: integral_literal, INSTRUCTION_FORMAT22b, REGISTER, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 945:5: -> ^( I_STATEMENT_FORMAT22b[$start, \"I_STATEMENT_FORMAT22b\"] INSTRUCTION_FORMAT22b REGISTER REGISTER integral_literal )
                {
                    // smaliParser.g:945:8: ^( I_STATEMENT_FORMAT22b[$start, \"I_STATEMENT_FORMAT22b\"] INSTRUCTION_FORMAT22b REGISTER REGISTER integral_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22b, (retval.start), "I_STATEMENT_FORMAT22b"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22b.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_integral_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22b"


    public static class insn_format22c_field_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22c_field"
    // smaliParser.g:947:1: insn_format22c_field : INSTRUCTION_FORMAT22c_FIELD REGISTER COMMA REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD REGISTER REGISTER field_reference ) ;
    public final smaliParser.insn_format22c_field_return insn_format22c_field() throws RecognitionException {
        smaliParser.insn_format22c_field_return retval = new smaliParser.insn_format22c_field_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22c_FIELD345 = null;
        Token REGISTER346 = null;
        Token COMMA347 = null;
        Token REGISTER348 = null;
        Token COMMA349 = null;
        ParserRuleReturnScope field_reference350 = null;

        CommonTree INSTRUCTION_FORMAT22c_FIELD345_tree = null;
        CommonTree REGISTER346_tree = null;
        CommonTree COMMA347_tree = null;
        CommonTree REGISTER348_tree = null;
        CommonTree COMMA349_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_FIELD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_FIELD");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleSubtreeStream stream_field_reference = new RewriteRuleSubtreeStream(adaptor, "rule field_reference");

        try {
            // smaliParser.g:948:3: ( INSTRUCTION_FORMAT22c_FIELD REGISTER COMMA REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD REGISTER REGISTER field_reference ) )
            // smaliParser.g:949:5: INSTRUCTION_FORMAT22c_FIELD REGISTER COMMA REGISTER COMMA field_reference
            {
                INSTRUCTION_FORMAT22c_FIELD345 = (Token) match(input, INSTRUCTION_FORMAT22c_FIELD, FOLLOW_INSTRUCTION_FORMAT22c_FIELD_in_insn_format22c_field4648);
                stream_INSTRUCTION_FORMAT22c_FIELD.add(INSTRUCTION_FORMAT22c_FIELD345);

                REGISTER346 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_field4650);
                stream_REGISTER.add(REGISTER346);

                COMMA347 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_field4652);
                stream_COMMA.add(COMMA347);

                REGISTER348 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_field4654);
                stream_REGISTER.add(REGISTER348);

                COMMA349 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_field4656);
                stream_COMMA.add(COMMA349);

                pushFollow(FOLLOW_field_reference_in_insn_format22c_field4658);
                field_reference350 = field_reference();
                state._fsp--;

                stream_field_reference.add(field_reference350.getTree());
                // AST REWRITE
                // elements: field_reference, INSTRUCTION_FORMAT22c_FIELD, REGISTER, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 950:5: -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD REGISTER REGISTER field_reference )
                {
                    // smaliParser.g:950:8: ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD REGISTER REGISTER field_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22c_FIELD, (retval.start), "I_STATEMENT_FORMAT22c_FIELD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22c_FIELD.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_field_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22c_field"


    public static class insn_format22c_field_odex_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22c_field_odex"
    // smaliParser.g:952:1: insn_format22c_field_odex : INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER COMMA REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER REGISTER field_reference ) ;
    public final smaliParser.insn_format22c_field_odex_return insn_format22c_field_odex() throws RecognitionException {
        smaliParser.insn_format22c_field_odex_return retval = new smaliParser.insn_format22c_field_odex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22c_FIELD_ODEX351 = null;
        Token REGISTER352 = null;
        Token COMMA353 = null;
        Token REGISTER354 = null;
        Token COMMA355 = null;
        ParserRuleReturnScope field_reference356 = null;

        CommonTree INSTRUCTION_FORMAT22c_FIELD_ODEX351_tree = null;
        CommonTree REGISTER352_tree = null;
        CommonTree COMMA353_tree = null;
        CommonTree REGISTER354_tree = null;
        CommonTree COMMA355_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_FIELD_ODEX = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_FIELD_ODEX");
        RewriteRuleSubtreeStream stream_field_reference = new RewriteRuleSubtreeStream(adaptor, "rule field_reference");

        try {
            // smaliParser.g:953:3: ( INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER COMMA REGISTER COMMA field_reference -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER REGISTER field_reference ) )
            // smaliParser.g:954:5: INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER COMMA REGISTER COMMA field_reference
            {
                INSTRUCTION_FORMAT22c_FIELD_ODEX351 = (Token) match(input, INSTRUCTION_FORMAT22c_FIELD_ODEX, FOLLOW_INSTRUCTION_FORMAT22c_FIELD_ODEX_in_insn_format22c_field_odex4692);
                stream_INSTRUCTION_FORMAT22c_FIELD_ODEX.add(INSTRUCTION_FORMAT22c_FIELD_ODEX351);

                REGISTER352 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_field_odex4694);
                stream_REGISTER.add(REGISTER352);

                COMMA353 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_field_odex4696);
                stream_COMMA.add(COMMA353);

                REGISTER354 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_field_odex4698);
                stream_REGISTER.add(REGISTER354);

                COMMA355 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_field_odex4700);
                stream_COMMA.add(COMMA355);

                pushFollow(FOLLOW_field_reference_in_insn_format22c_field_odex4702);
                field_reference356 = field_reference();
                state._fsp--;

                stream_field_reference.add(field_reference356.getTree());

                if (!allowOdex || opcodes.getOpcodeByName((INSTRUCTION_FORMAT22c_FIELD_ODEX351 != null ? INSTRUCTION_FORMAT22c_FIELD_ODEX351.getText() : null)) == null || apiLevel >= 14) {
                    throwOdexedInstructionException(input, (INSTRUCTION_FORMAT22c_FIELD_ODEX351 != null ? INSTRUCTION_FORMAT22c_FIELD_ODEX351.getText() : null));
                }

                // AST REWRITE
                // elements: REGISTER, REGISTER, INSTRUCTION_FORMAT22c_FIELD_ODEX, field_reference
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 960:5: -> ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER REGISTER field_reference )
                {
                    // smaliParser.g:960:8: ^( I_STATEMENT_FORMAT22c_FIELD[$start, \"I_STATEMENT_FORMAT22c_FIELD\"] INSTRUCTION_FORMAT22c_FIELD_ODEX REGISTER REGISTER field_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22c_FIELD, (retval.start), "I_STATEMENT_FORMAT22c_FIELD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22c_FIELD_ODEX.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_field_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22c_field_odex"


    public static class insn_format22c_type_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22c_type"
    // smaliParser.g:962:1: insn_format22c_type : INSTRUCTION_FORMAT22c_TYPE REGISTER COMMA REGISTER COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT22c_TYPE[$start, \"I_STATEMENT_FORMAT22c_TYPE\"] INSTRUCTION_FORMAT22c_TYPE REGISTER REGISTER nonvoid_type_descriptor ) ;
    public final smaliParser.insn_format22c_type_return insn_format22c_type() throws RecognitionException {
        smaliParser.insn_format22c_type_return retval = new smaliParser.insn_format22c_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22c_TYPE357 = null;
        Token REGISTER358 = null;
        Token COMMA359 = null;
        Token REGISTER360 = null;
        Token COMMA361 = null;
        ParserRuleReturnScope nonvoid_type_descriptor362 = null;

        CommonTree INSTRUCTION_FORMAT22c_TYPE357_tree = null;
        CommonTree REGISTER358_tree = null;
        CommonTree COMMA359_tree = null;
        CommonTree REGISTER360_tree = null;
        CommonTree COMMA361_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22c_TYPE");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");

        try {
            // smaliParser.g:963:3: ( INSTRUCTION_FORMAT22c_TYPE REGISTER COMMA REGISTER COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT22c_TYPE[$start, \"I_STATEMENT_FORMAT22c_TYPE\"] INSTRUCTION_FORMAT22c_TYPE REGISTER REGISTER nonvoid_type_descriptor ) )
            // smaliParser.g:964:5: INSTRUCTION_FORMAT22c_TYPE REGISTER COMMA REGISTER COMMA nonvoid_type_descriptor
            {
                INSTRUCTION_FORMAT22c_TYPE357 = (Token) match(input, INSTRUCTION_FORMAT22c_TYPE, FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_insn_format22c_type4742);
                stream_INSTRUCTION_FORMAT22c_TYPE.add(INSTRUCTION_FORMAT22c_TYPE357);

                REGISTER358 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_type4744);
                stream_REGISTER.add(REGISTER358);

                COMMA359 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_type4746);
                stream_COMMA.add(COMMA359);

                REGISTER360 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22c_type4748);
                stream_REGISTER.add(REGISTER360);

                COMMA361 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22c_type4750);
                stream_COMMA.add(COMMA361);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format22c_type4752);
                nonvoid_type_descriptor362 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor362.getTree());
                // AST REWRITE
                // elements: nonvoid_type_descriptor, REGISTER, INSTRUCTION_FORMAT22c_TYPE, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 965:5: -> ^( I_STATEMENT_FORMAT22c_TYPE[$start, \"I_STATEMENT_FORMAT22c_TYPE\"] INSTRUCTION_FORMAT22c_TYPE REGISTER REGISTER nonvoid_type_descriptor )
                {
                    // smaliParser.g:965:8: ^( I_STATEMENT_FORMAT22c_TYPE[$start, \"I_STATEMENT_FORMAT22c_TYPE\"] INSTRUCTION_FORMAT22c_TYPE REGISTER REGISTER nonvoid_type_descriptor )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22c_TYPE, (retval.start), "I_STATEMENT_FORMAT22c_TYPE"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22c_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22c_type"


    public static class insn_format22cs_field_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22cs_field"
    // smaliParser.g:967:1: insn_format22cs_field : INSTRUCTION_FORMAT22cs_FIELD REGISTER COMMA REGISTER COMMA FIELD_OFFSET ;
    public final smaliParser.insn_format22cs_field_return insn_format22cs_field() throws RecognitionException {
        smaliParser.insn_format22cs_field_return retval = new smaliParser.insn_format22cs_field_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22cs_FIELD363 = null;
        Token REGISTER364 = null;
        Token COMMA365 = null;
        Token REGISTER366 = null;
        Token COMMA367 = null;
        Token FIELD_OFFSET368 = null;

        CommonTree INSTRUCTION_FORMAT22cs_FIELD363_tree = null;
        CommonTree REGISTER364_tree = null;
        CommonTree COMMA365_tree = null;
        CommonTree REGISTER366_tree = null;
        CommonTree COMMA367_tree = null;
        CommonTree FIELD_OFFSET368_tree = null;

        try {
            // smaliParser.g:968:3: ( INSTRUCTION_FORMAT22cs_FIELD REGISTER COMMA REGISTER COMMA FIELD_OFFSET )
            // smaliParser.g:969:5: INSTRUCTION_FORMAT22cs_FIELD REGISTER COMMA REGISTER COMMA FIELD_OFFSET
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT22cs_FIELD363 = (Token) match(input, INSTRUCTION_FORMAT22cs_FIELD, FOLLOW_INSTRUCTION_FORMAT22cs_FIELD_in_insn_format22cs_field4786);
                INSTRUCTION_FORMAT22cs_FIELD363_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT22cs_FIELD363);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT22cs_FIELD363_tree);

                REGISTER364 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22cs_field4788);
                REGISTER364_tree = (CommonTree) adaptor.create(REGISTER364);
                adaptor.addChild(root_0, REGISTER364_tree);

                COMMA365 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22cs_field4790);
                COMMA365_tree = (CommonTree) adaptor.create(COMMA365);
                adaptor.addChild(root_0, COMMA365_tree);

                REGISTER366 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22cs_field4792);
                REGISTER366_tree = (CommonTree) adaptor.create(REGISTER366);
                adaptor.addChild(root_0, REGISTER366_tree);

                COMMA367 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22cs_field4794);
                COMMA367_tree = (CommonTree) adaptor.create(COMMA367);
                adaptor.addChild(root_0, COMMA367_tree);

                FIELD_OFFSET368 = (Token) match(input, FIELD_OFFSET, FOLLOW_FIELD_OFFSET_in_insn_format22cs_field4796);
                FIELD_OFFSET368_tree = (CommonTree) adaptor.create(FIELD_OFFSET368);
                adaptor.addChild(root_0, FIELD_OFFSET368_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT22cs_FIELD363 != null ? INSTRUCTION_FORMAT22cs_FIELD363.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22cs_field"


    public static class insn_format22s_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22s"
    // smaliParser.g:974:1: insn_format22s : instruction_format22s REGISTER COMMA REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT22s[$start, \"I_STATEMENT_FORMAT22s\"] instruction_format22s REGISTER REGISTER integral_literal ) ;
    public final smaliParser.insn_format22s_return insn_format22s() throws RecognitionException {
        smaliParser.insn_format22s_return retval = new smaliParser.insn_format22s_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REGISTER370 = null;
        Token COMMA371 = null;
        Token REGISTER372 = null;
        Token COMMA373 = null;
        ParserRuleReturnScope instruction_format22s369 = null;
        ParserRuleReturnScope integral_literal374 = null;

        CommonTree REGISTER370_tree = null;
        CommonTree COMMA371_tree = null;
        CommonTree REGISTER372_tree = null;
        CommonTree COMMA373_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleSubtreeStream stream_instruction_format22s = new RewriteRuleSubtreeStream(adaptor, "rule instruction_format22s");
        RewriteRuleSubtreeStream stream_integral_literal = new RewriteRuleSubtreeStream(adaptor, "rule integral_literal");

        try {
            // smaliParser.g:975:3: ( instruction_format22s REGISTER COMMA REGISTER COMMA integral_literal -> ^( I_STATEMENT_FORMAT22s[$start, \"I_STATEMENT_FORMAT22s\"] instruction_format22s REGISTER REGISTER integral_literal ) )
            // smaliParser.g:976:5: instruction_format22s REGISTER COMMA REGISTER COMMA integral_literal
            {
                pushFollow(FOLLOW_instruction_format22s_in_insn_format22s4817);
                instruction_format22s369 = instruction_format22s();
                state._fsp--;

                stream_instruction_format22s.add(instruction_format22s369.getTree());
                REGISTER370 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22s4819);
                stream_REGISTER.add(REGISTER370);

                COMMA371 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22s4821);
                stream_COMMA.add(COMMA371);

                REGISTER372 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22s4823);
                stream_REGISTER.add(REGISTER372);

                COMMA373 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22s4825);
                stream_COMMA.add(COMMA373);

                pushFollow(FOLLOW_integral_literal_in_insn_format22s4827);
                integral_literal374 = integral_literal();
                state._fsp--;

                stream_integral_literal.add(integral_literal374.getTree());
                // AST REWRITE
                // elements: instruction_format22s, REGISTER, REGISTER, integral_literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 977:5: -> ^( I_STATEMENT_FORMAT22s[$start, \"I_STATEMENT_FORMAT22s\"] instruction_format22s REGISTER REGISTER integral_literal )
                {
                    // smaliParser.g:977:8: ^( I_STATEMENT_FORMAT22s[$start, \"I_STATEMENT_FORMAT22s\"] instruction_format22s REGISTER REGISTER integral_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22s, (retval.start), "I_STATEMENT_FORMAT22s"), root_1);
                        adaptor.addChild(root_1, stream_instruction_format22s.nextTree());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_integral_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22s"


    public static class insn_format22t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22t"
    // smaliParser.g:979:1: insn_format22t : INSTRUCTION_FORMAT22t REGISTER COMMA REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT22t[$start, \"I_STATEMENT_FFORMAT22t\"] INSTRUCTION_FORMAT22t REGISTER REGISTER label_ref ) ;
    public final smaliParser.insn_format22t_return insn_format22t() throws RecognitionException {
        smaliParser.insn_format22t_return retval = new smaliParser.insn_format22t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22t375 = null;
        Token REGISTER376 = null;
        Token COMMA377 = null;
        Token REGISTER378 = null;
        Token COMMA379 = null;
        ParserRuleReturnScope label_ref380 = null;

        CommonTree INSTRUCTION_FORMAT22t375_tree = null;
        CommonTree REGISTER376_tree = null;
        CommonTree COMMA377_tree = null;
        CommonTree REGISTER378_tree = null;
        CommonTree COMMA379_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:980:3: ( INSTRUCTION_FORMAT22t REGISTER COMMA REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT22t[$start, \"I_STATEMENT_FFORMAT22t\"] INSTRUCTION_FORMAT22t REGISTER REGISTER label_ref ) )
            // smaliParser.g:981:5: INSTRUCTION_FORMAT22t REGISTER COMMA REGISTER COMMA label_ref
            {
                INSTRUCTION_FORMAT22t375 = (Token) match(input, INSTRUCTION_FORMAT22t, FOLLOW_INSTRUCTION_FORMAT22t_in_insn_format22t4861);
                stream_INSTRUCTION_FORMAT22t.add(INSTRUCTION_FORMAT22t375);

                REGISTER376 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22t4863);
                stream_REGISTER.add(REGISTER376);

                COMMA377 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22t4865);
                stream_COMMA.add(COMMA377);

                REGISTER378 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22t4867);
                stream_REGISTER.add(REGISTER378);

                COMMA379 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22t4869);
                stream_COMMA.add(COMMA379);

                pushFollow(FOLLOW_label_ref_in_insn_format22t4871);
                label_ref380 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref380.getTree());
                // AST REWRITE
                // elements: label_ref, REGISTER, INSTRUCTION_FORMAT22t, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 982:5: -> ^( I_STATEMENT_FORMAT22t[$start, \"I_STATEMENT_FFORMAT22t\"] INSTRUCTION_FORMAT22t REGISTER REGISTER label_ref )
                {
                    // smaliParser.g:982:8: ^( I_STATEMENT_FORMAT22t[$start, \"I_STATEMENT_FFORMAT22t\"] INSTRUCTION_FORMAT22t REGISTER REGISTER label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22t, (retval.start), "I_STATEMENT_FFORMAT22t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22t.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22t"


    public static class insn_format22x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format22x"
    // smaliParser.g:984:1: insn_format22x : INSTRUCTION_FORMAT22x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT22x[$start, \"I_STATEMENT_FORMAT22x\"] INSTRUCTION_FORMAT22x REGISTER REGISTER ) ;
    public final smaliParser.insn_format22x_return insn_format22x() throws RecognitionException {
        smaliParser.insn_format22x_return retval = new smaliParser.insn_format22x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT22x381 = null;
        Token REGISTER382 = null;
        Token COMMA383 = null;
        Token REGISTER384 = null;

        CommonTree INSTRUCTION_FORMAT22x381_tree = null;
        CommonTree REGISTER382_tree = null;
        CommonTree COMMA383_tree = null;
        CommonTree REGISTER384_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT22x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT22x");

        try {
            // smaliParser.g:985:3: ( INSTRUCTION_FORMAT22x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT22x[$start, \"I_STATEMENT_FORMAT22x\"] INSTRUCTION_FORMAT22x REGISTER REGISTER ) )
            // smaliParser.g:986:5: INSTRUCTION_FORMAT22x REGISTER COMMA REGISTER
            {
                INSTRUCTION_FORMAT22x381 = (Token) match(input, INSTRUCTION_FORMAT22x, FOLLOW_INSTRUCTION_FORMAT22x_in_insn_format22x4905);
                stream_INSTRUCTION_FORMAT22x.add(INSTRUCTION_FORMAT22x381);

                REGISTER382 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22x4907);
                stream_REGISTER.add(REGISTER382);

                COMMA383 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format22x4909);
                stream_COMMA.add(COMMA383);

                REGISTER384 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format22x4911);
                stream_REGISTER.add(REGISTER384);

                // AST REWRITE
                // elements: REGISTER, INSTRUCTION_FORMAT22x, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 987:5: -> ^( I_STATEMENT_FORMAT22x[$start, \"I_STATEMENT_FORMAT22x\"] INSTRUCTION_FORMAT22x REGISTER REGISTER )
                {
                    // smaliParser.g:987:8: ^( I_STATEMENT_FORMAT22x[$start, \"I_STATEMENT_FORMAT22x\"] INSTRUCTION_FORMAT22x REGISTER REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT22x, (retval.start), "I_STATEMENT_FORMAT22x"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT22x.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format22x"


    public static class insn_format23x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format23x"
    // smaliParser.g:989:1: insn_format23x : INSTRUCTION_FORMAT23x REGISTER COMMA REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT23x[$start, \"I_STATEMENT_FORMAT23x\"] INSTRUCTION_FORMAT23x REGISTER REGISTER REGISTER ) ;
    public final smaliParser.insn_format23x_return insn_format23x() throws RecognitionException {
        smaliParser.insn_format23x_return retval = new smaliParser.insn_format23x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT23x385 = null;
        Token REGISTER386 = null;
        Token COMMA387 = null;
        Token REGISTER388 = null;
        Token COMMA389 = null;
        Token REGISTER390 = null;

        CommonTree INSTRUCTION_FORMAT23x385_tree = null;
        CommonTree REGISTER386_tree = null;
        CommonTree COMMA387_tree = null;
        CommonTree REGISTER388_tree = null;
        CommonTree COMMA389_tree = null;
        CommonTree REGISTER390_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT23x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT23x");

        try {
            // smaliParser.g:990:3: ( INSTRUCTION_FORMAT23x REGISTER COMMA REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT23x[$start, \"I_STATEMENT_FORMAT23x\"] INSTRUCTION_FORMAT23x REGISTER REGISTER REGISTER ) )
            // smaliParser.g:991:5: INSTRUCTION_FORMAT23x REGISTER COMMA REGISTER COMMA REGISTER
            {
                INSTRUCTION_FORMAT23x385 = (Token) match(input, INSTRUCTION_FORMAT23x, FOLLOW_INSTRUCTION_FORMAT23x_in_insn_format23x4943);
                stream_INSTRUCTION_FORMAT23x.add(INSTRUCTION_FORMAT23x385);

                REGISTER386 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format23x4945);
                stream_REGISTER.add(REGISTER386);

                COMMA387 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format23x4947);
                stream_COMMA.add(COMMA387);

                REGISTER388 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format23x4949);
                stream_REGISTER.add(REGISTER388);

                COMMA389 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format23x4951);
                stream_COMMA.add(COMMA389);

                REGISTER390 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format23x4953);
                stream_REGISTER.add(REGISTER390);

                // AST REWRITE
                // elements: INSTRUCTION_FORMAT23x, REGISTER, REGISTER, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 992:5: -> ^( I_STATEMENT_FORMAT23x[$start, \"I_STATEMENT_FORMAT23x\"] INSTRUCTION_FORMAT23x REGISTER REGISTER REGISTER )
                {
                    // smaliParser.g:992:8: ^( I_STATEMENT_FORMAT23x[$start, \"I_STATEMENT_FORMAT23x\"] INSTRUCTION_FORMAT23x REGISTER REGISTER REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT23x, (retval.start), "I_STATEMENT_FORMAT23x"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT23x.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format23x"


    public static class insn_format30t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format30t"
    // smaliParser.g:994:1: insn_format30t : INSTRUCTION_FORMAT30t label_ref -> ^( I_STATEMENT_FORMAT30t[$start, \"I_STATEMENT_FORMAT30t\"] INSTRUCTION_FORMAT30t label_ref ) ;
    public final smaliParser.insn_format30t_return insn_format30t() throws RecognitionException {
        smaliParser.insn_format30t_return retval = new smaliParser.insn_format30t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT30t391 = null;
        ParserRuleReturnScope label_ref392 = null;

        CommonTree INSTRUCTION_FORMAT30t391_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT30t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT30t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:995:3: ( INSTRUCTION_FORMAT30t label_ref -> ^( I_STATEMENT_FORMAT30t[$start, \"I_STATEMENT_FORMAT30t\"] INSTRUCTION_FORMAT30t label_ref ) )
            // smaliParser.g:996:5: INSTRUCTION_FORMAT30t label_ref
            {
                INSTRUCTION_FORMAT30t391 = (Token) match(input, INSTRUCTION_FORMAT30t, FOLLOW_INSTRUCTION_FORMAT30t_in_insn_format30t4987);
                stream_INSTRUCTION_FORMAT30t.add(INSTRUCTION_FORMAT30t391);

                pushFollow(FOLLOW_label_ref_in_insn_format30t4989);
                label_ref392 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref392.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT30t, label_ref
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 997:5: -> ^( I_STATEMENT_FORMAT30t[$start, \"I_STATEMENT_FORMAT30t\"] INSTRUCTION_FORMAT30t label_ref )
                {
                    // smaliParser.g:997:8: ^( I_STATEMENT_FORMAT30t[$start, \"I_STATEMENT_FORMAT30t\"] INSTRUCTION_FORMAT30t label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT30t, (retval.start), "I_STATEMENT_FORMAT30t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT30t.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format30t"


    public static class insn_format31c_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format31c"
    // smaliParser.g:999:1: insn_format31c : INSTRUCTION_FORMAT31c REGISTER COMMA STRING_LITERAL -> ^( I_STATEMENT_FORMAT31c[$start, \"I_STATEMENT_FORMAT31c\"] INSTRUCTION_FORMAT31c REGISTER STRING_LITERAL ) ;
    public final smaliParser.insn_format31c_return insn_format31c() throws RecognitionException {
        smaliParser.insn_format31c_return retval = new smaliParser.insn_format31c_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT31c393 = null;
        Token REGISTER394 = null;
        Token COMMA395 = null;
        Token STRING_LITERAL396 = null;

        CommonTree INSTRUCTION_FORMAT31c393_tree = null;
        CommonTree REGISTER394_tree = null;
        CommonTree COMMA395_tree = null;
        CommonTree STRING_LITERAL396_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT31c = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT31c");
        RewriteRuleTokenStream stream_STRING_LITERAL = new RewriteRuleTokenStream(adaptor, "token STRING_LITERAL");

        try {
            // smaliParser.g:1000:3: ( INSTRUCTION_FORMAT31c REGISTER COMMA STRING_LITERAL -> ^( I_STATEMENT_FORMAT31c[$start, \"I_STATEMENT_FORMAT31c\"] INSTRUCTION_FORMAT31c REGISTER STRING_LITERAL ) )
            // smaliParser.g:1001:5: INSTRUCTION_FORMAT31c REGISTER COMMA STRING_LITERAL
            {
                INSTRUCTION_FORMAT31c393 = (Token) match(input, INSTRUCTION_FORMAT31c, FOLLOW_INSTRUCTION_FORMAT31c_in_insn_format31c5019);
                stream_INSTRUCTION_FORMAT31c.add(INSTRUCTION_FORMAT31c393);

                REGISTER394 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format31c5021);
                stream_REGISTER.add(REGISTER394);

                COMMA395 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format31c5023);
                stream_COMMA.add(COMMA395);

                STRING_LITERAL396 = (Token) match(input, STRING_LITERAL, FOLLOW_STRING_LITERAL_in_insn_format31c5025);
                stream_STRING_LITERAL.add(STRING_LITERAL396);

                // AST REWRITE
                // elements: REGISTER, STRING_LITERAL, INSTRUCTION_FORMAT31c
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1002:5: -> ^( I_STATEMENT_FORMAT31c[$start, \"I_STATEMENT_FORMAT31c\"] INSTRUCTION_FORMAT31c REGISTER STRING_LITERAL )
                {
                    // smaliParser.g:1002:7: ^( I_STATEMENT_FORMAT31c[$start, \"I_STATEMENT_FORMAT31c\"] INSTRUCTION_FORMAT31c REGISTER STRING_LITERAL )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT31c, (retval.start), "I_STATEMENT_FORMAT31c"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT31c.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format31c"


    public static class insn_format31i_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format31i"
    // smaliParser.g:1004:1: insn_format31i : instruction_format31i REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT31i[$start, \"I_STATEMENT_FORMAT31i\"] instruction_format31i REGISTER fixed_32bit_literal ) ;
    public final smaliParser.insn_format31i_return insn_format31i() throws RecognitionException {
        smaliParser.insn_format31i_return retval = new smaliParser.insn_format31i_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REGISTER398 = null;
        Token COMMA399 = null;
        ParserRuleReturnScope instruction_format31i397 = null;
        ParserRuleReturnScope fixed_32bit_literal400 = null;

        CommonTree REGISTER398_tree = null;
        CommonTree COMMA399_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleSubtreeStream stream_fixed_32bit_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_32bit_literal");
        RewriteRuleSubtreeStream stream_instruction_format31i = new RewriteRuleSubtreeStream(adaptor, "rule instruction_format31i");

        try {
            // smaliParser.g:1005:3: ( instruction_format31i REGISTER COMMA fixed_32bit_literal -> ^( I_STATEMENT_FORMAT31i[$start, \"I_STATEMENT_FORMAT31i\"] instruction_format31i REGISTER fixed_32bit_literal ) )
            // smaliParser.g:1006:5: instruction_format31i REGISTER COMMA fixed_32bit_literal
            {
                pushFollow(FOLLOW_instruction_format31i_in_insn_format31i5056);
                instruction_format31i397 = instruction_format31i();
                state._fsp--;

                stream_instruction_format31i.add(instruction_format31i397.getTree());
                REGISTER398 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format31i5058);
                stream_REGISTER.add(REGISTER398);

                COMMA399 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format31i5060);
                stream_COMMA.add(COMMA399);

                pushFollow(FOLLOW_fixed_32bit_literal_in_insn_format31i5062);
                fixed_32bit_literal400 = fixed_32bit_literal();
                state._fsp--;

                stream_fixed_32bit_literal.add(fixed_32bit_literal400.getTree());
                // AST REWRITE
                // elements: REGISTER, fixed_32bit_literal, instruction_format31i
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1007:5: -> ^( I_STATEMENT_FORMAT31i[$start, \"I_STATEMENT_FORMAT31i\"] instruction_format31i REGISTER fixed_32bit_literal )
                {
                    // smaliParser.g:1007:8: ^( I_STATEMENT_FORMAT31i[$start, \"I_STATEMENT_FORMAT31i\"] instruction_format31i REGISTER fixed_32bit_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT31i, (retval.start), "I_STATEMENT_FORMAT31i"), root_1);
                        adaptor.addChild(root_1, stream_instruction_format31i.nextTree());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_fixed_32bit_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format31i"


    public static class insn_format31t_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format31t"
    // smaliParser.g:1009:1: insn_format31t : INSTRUCTION_FORMAT31t REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT31t[$start, \"I_STATEMENT_FORMAT31t\"] INSTRUCTION_FORMAT31t REGISTER label_ref ) ;
    public final smaliParser.insn_format31t_return insn_format31t() throws RecognitionException {
        smaliParser.insn_format31t_return retval = new smaliParser.insn_format31t_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT31t401 = null;
        Token REGISTER402 = null;
        Token COMMA403 = null;
        ParserRuleReturnScope label_ref404 = null;

        CommonTree INSTRUCTION_FORMAT31t401_tree = null;
        CommonTree REGISTER402_tree = null;
        CommonTree COMMA403_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT31t = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT31t");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:1010:3: ( INSTRUCTION_FORMAT31t REGISTER COMMA label_ref -> ^( I_STATEMENT_FORMAT31t[$start, \"I_STATEMENT_FORMAT31t\"] INSTRUCTION_FORMAT31t REGISTER label_ref ) )
            // smaliParser.g:1011:5: INSTRUCTION_FORMAT31t REGISTER COMMA label_ref
            {
                INSTRUCTION_FORMAT31t401 = (Token) match(input, INSTRUCTION_FORMAT31t, FOLLOW_INSTRUCTION_FORMAT31t_in_insn_format31t5094);
                stream_INSTRUCTION_FORMAT31t.add(INSTRUCTION_FORMAT31t401);

                REGISTER402 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format31t5096);
                stream_REGISTER.add(REGISTER402);

                COMMA403 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format31t5098);
                stream_COMMA.add(COMMA403);

                pushFollow(FOLLOW_label_ref_in_insn_format31t5100);
                label_ref404 = label_ref();
                state._fsp--;

                stream_label_ref.add(label_ref404.getTree());
                // AST REWRITE
                // elements: REGISTER, label_ref, INSTRUCTION_FORMAT31t
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1012:5: -> ^( I_STATEMENT_FORMAT31t[$start, \"I_STATEMENT_FORMAT31t\"] INSTRUCTION_FORMAT31t REGISTER label_ref )
                {
                    // smaliParser.g:1012:8: ^( I_STATEMENT_FORMAT31t[$start, \"I_STATEMENT_FORMAT31t\"] INSTRUCTION_FORMAT31t REGISTER label_ref )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT31t, (retval.start), "I_STATEMENT_FORMAT31t"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT31t.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_label_ref.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format31t"


    public static class insn_format32x_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format32x"
    // smaliParser.g:1014:1: insn_format32x : INSTRUCTION_FORMAT32x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT32x[$start, \"I_STATEMENT_FORMAT32x\"] INSTRUCTION_FORMAT32x REGISTER REGISTER ) ;
    public final smaliParser.insn_format32x_return insn_format32x() throws RecognitionException {
        smaliParser.insn_format32x_return retval = new smaliParser.insn_format32x_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT32x405 = null;
        Token REGISTER406 = null;
        Token COMMA407 = null;
        Token REGISTER408 = null;

        CommonTree INSTRUCTION_FORMAT32x405_tree = null;
        CommonTree REGISTER406_tree = null;
        CommonTree COMMA407_tree = null;
        CommonTree REGISTER408_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT32x = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT32x");

        try {
            // smaliParser.g:1015:3: ( INSTRUCTION_FORMAT32x REGISTER COMMA REGISTER -> ^( I_STATEMENT_FORMAT32x[$start, \"I_STATEMENT_FORMAT32x\"] INSTRUCTION_FORMAT32x REGISTER REGISTER ) )
            // smaliParser.g:1016:5: INSTRUCTION_FORMAT32x REGISTER COMMA REGISTER
            {
                INSTRUCTION_FORMAT32x405 = (Token) match(input, INSTRUCTION_FORMAT32x, FOLLOW_INSTRUCTION_FORMAT32x_in_insn_format32x5132);
                stream_INSTRUCTION_FORMAT32x.add(INSTRUCTION_FORMAT32x405);

                REGISTER406 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format32x5134);
                stream_REGISTER.add(REGISTER406);

                COMMA407 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format32x5136);
                stream_COMMA.add(COMMA407);

                REGISTER408 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format32x5138);
                stream_REGISTER.add(REGISTER408);

                // AST REWRITE
                // elements: REGISTER, REGISTER, INSTRUCTION_FORMAT32x
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1017:5: -> ^( I_STATEMENT_FORMAT32x[$start, \"I_STATEMENT_FORMAT32x\"] INSTRUCTION_FORMAT32x REGISTER REGISTER )
                {
                    // smaliParser.g:1017:8: ^( I_STATEMENT_FORMAT32x[$start, \"I_STATEMENT_FORMAT32x\"] INSTRUCTION_FORMAT32x REGISTER REGISTER )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT32x, (retval.start), "I_STATEMENT_FORMAT32x"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT32x.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format32x"


    public static class insn_format35c_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format35c_method"
    // smaliParser.g:1019:1: insn_format35c_method : INSTRUCTION_FORMAT35c_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference -> ^( I_STATEMENT_FORMAT35c_METHOD[$start, \"I_STATEMENT_FORMAT35c_METHOD\"] INSTRUCTION_FORMAT35c_METHOD register_list method_reference ) ;
    public final smaliParser.insn_format35c_method_return insn_format35c_method() throws RecognitionException {
        smaliParser.insn_format35c_method_return retval = new smaliParser.insn_format35c_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT35c_METHOD409 = null;
        Token OPEN_BRACE410 = null;
        Token CLOSE_BRACE412 = null;
        Token COMMA413 = null;
        ParserRuleReturnScope register_list411 = null;
        ParserRuleReturnScope method_reference414 = null;

        CommonTree INSTRUCTION_FORMAT35c_METHOD409_tree = null;
        CommonTree OPEN_BRACE410_tree = null;
        CommonTree CLOSE_BRACE412_tree = null;
        CommonTree COMMA413_tree = null;
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35c_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35c_METHOD");
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleSubtreeStream stream_method_reference = new RewriteRuleSubtreeStream(adaptor, "rule method_reference");
        RewriteRuleSubtreeStream stream_register_list = new RewriteRuleSubtreeStream(adaptor, "rule register_list");

        try {
            // smaliParser.g:1020:3: ( INSTRUCTION_FORMAT35c_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference -> ^( I_STATEMENT_FORMAT35c_METHOD[$start, \"I_STATEMENT_FORMAT35c_METHOD\"] INSTRUCTION_FORMAT35c_METHOD register_list method_reference ) )
            // smaliParser.g:1021:5: INSTRUCTION_FORMAT35c_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference
            {
                INSTRUCTION_FORMAT35c_METHOD409 = (Token) match(input, INSTRUCTION_FORMAT35c_METHOD, FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_insn_format35c_method5170);
                stream_INSTRUCTION_FORMAT35c_METHOD.add(INSTRUCTION_FORMAT35c_METHOD409);

                OPEN_BRACE410 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format35c_method5172);
                stream_OPEN_BRACE.add(OPEN_BRACE410);

                pushFollow(FOLLOW_register_list_in_insn_format35c_method5174);
                register_list411 = register_list();
                state._fsp--;

                stream_register_list.add(register_list411.getTree());
                CLOSE_BRACE412 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format35c_method5176);
                stream_CLOSE_BRACE.add(CLOSE_BRACE412);

                COMMA413 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format35c_method5178);
                stream_COMMA.add(COMMA413);

                pushFollow(FOLLOW_method_reference_in_insn_format35c_method5180);
                method_reference414 = method_reference();
                state._fsp--;

                stream_method_reference.add(method_reference414.getTree());
                // AST REWRITE
                // elements: register_list, INSTRUCTION_FORMAT35c_METHOD, method_reference
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1022:5: -> ^( I_STATEMENT_FORMAT35c_METHOD[$start, \"I_STATEMENT_FORMAT35c_METHOD\"] INSTRUCTION_FORMAT35c_METHOD register_list method_reference )
                {
                    // smaliParser.g:1022:8: ^( I_STATEMENT_FORMAT35c_METHOD[$start, \"I_STATEMENT_FORMAT35c_METHOD\"] INSTRUCTION_FORMAT35c_METHOD register_list method_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT35c_METHOD, (retval.start), "I_STATEMENT_FORMAT35c_METHOD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT35c_METHOD.nextNode());
                        adaptor.addChild(root_1, stream_register_list.nextTree());
                        adaptor.addChild(root_1, stream_method_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format35c_method"


    public static class insn_format35c_type_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format35c_type"
    // smaliParser.g:1024:1: insn_format35c_type : INSTRUCTION_FORMAT35c_TYPE OPEN_BRACE register_list CLOSE_BRACE COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT35c_TYPE[$start, \"I_STATEMENT_FORMAT35c_TYPE\"] INSTRUCTION_FORMAT35c_TYPE register_list nonvoid_type_descriptor ) ;
    public final smaliParser.insn_format35c_type_return insn_format35c_type() throws RecognitionException {
        smaliParser.insn_format35c_type_return retval = new smaliParser.insn_format35c_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT35c_TYPE415 = null;
        Token OPEN_BRACE416 = null;
        Token CLOSE_BRACE418 = null;
        Token COMMA419 = null;
        ParserRuleReturnScope register_list417 = null;
        ParserRuleReturnScope nonvoid_type_descriptor420 = null;

        CommonTree INSTRUCTION_FORMAT35c_TYPE415_tree = null;
        CommonTree OPEN_BRACE416_tree = null;
        CommonTree CLOSE_BRACE418_tree = null;
        CommonTree COMMA419_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT35c_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT35c_TYPE");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleSubtreeStream stream_register_list = new RewriteRuleSubtreeStream(adaptor, "rule register_list");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");

        try {
            // smaliParser.g:1025:3: ( INSTRUCTION_FORMAT35c_TYPE OPEN_BRACE register_list CLOSE_BRACE COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT35c_TYPE[$start, \"I_STATEMENT_FORMAT35c_TYPE\"] INSTRUCTION_FORMAT35c_TYPE register_list nonvoid_type_descriptor ) )
            // smaliParser.g:1026:5: INSTRUCTION_FORMAT35c_TYPE OPEN_BRACE register_list CLOSE_BRACE COMMA nonvoid_type_descriptor
            {
                INSTRUCTION_FORMAT35c_TYPE415 = (Token) match(input, INSTRUCTION_FORMAT35c_TYPE, FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_insn_format35c_type5212);
                stream_INSTRUCTION_FORMAT35c_TYPE.add(INSTRUCTION_FORMAT35c_TYPE415);

                OPEN_BRACE416 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format35c_type5214);
                stream_OPEN_BRACE.add(OPEN_BRACE416);

                pushFollow(FOLLOW_register_list_in_insn_format35c_type5216);
                register_list417 = register_list();
                state._fsp--;

                stream_register_list.add(register_list417.getTree());
                CLOSE_BRACE418 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format35c_type5218);
                stream_CLOSE_BRACE.add(CLOSE_BRACE418);

                COMMA419 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format35c_type5220);
                stream_COMMA.add(COMMA419);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format35c_type5222);
                nonvoid_type_descriptor420 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor420.getTree());
                // AST REWRITE
                // elements: register_list, nonvoid_type_descriptor, INSTRUCTION_FORMAT35c_TYPE
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1027:5: -> ^( I_STATEMENT_FORMAT35c_TYPE[$start, \"I_STATEMENT_FORMAT35c_TYPE\"] INSTRUCTION_FORMAT35c_TYPE register_list nonvoid_type_descriptor )
                {
                    // smaliParser.g:1027:8: ^( I_STATEMENT_FORMAT35c_TYPE[$start, \"I_STATEMENT_FORMAT35c_TYPE\"] INSTRUCTION_FORMAT35c_TYPE register_list nonvoid_type_descriptor )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT35c_TYPE, (retval.start), "I_STATEMENT_FORMAT35c_TYPE"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT35c_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_register_list.nextTree());
                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format35c_type"


    public static class insn_format35c_method_odex_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format35c_method_odex"
    // smaliParser.g:1029:1: insn_format35c_method_odex : INSTRUCTION_FORMAT35c_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference ;
    public final smaliParser.insn_format35c_method_odex_return insn_format35c_method_odex() throws RecognitionException {
        smaliParser.insn_format35c_method_odex_return retval = new smaliParser.insn_format35c_method_odex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT35c_METHOD_ODEX421 = null;
        Token OPEN_BRACE422 = null;
        Token CLOSE_BRACE424 = null;
        Token COMMA425 = null;
        ParserRuleReturnScope register_list423 = null;
        ParserRuleReturnScope method_reference426 = null;

        CommonTree INSTRUCTION_FORMAT35c_METHOD_ODEX421_tree = null;
        CommonTree OPEN_BRACE422_tree = null;
        CommonTree CLOSE_BRACE424_tree = null;
        CommonTree COMMA425_tree = null;

        try {
            // smaliParser.g:1030:3: ( INSTRUCTION_FORMAT35c_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference )
            // smaliParser.g:1031:5: INSTRUCTION_FORMAT35c_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT35c_METHOD_ODEX421 = (Token) match(input, INSTRUCTION_FORMAT35c_METHOD_ODEX, FOLLOW_INSTRUCTION_FORMAT35c_METHOD_ODEX_in_insn_format35c_method_odex5254);
                INSTRUCTION_FORMAT35c_METHOD_ODEX421_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT35c_METHOD_ODEX421);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT35c_METHOD_ODEX421_tree);

                OPEN_BRACE422 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format35c_method_odex5256);
                OPEN_BRACE422_tree = (CommonTree) adaptor.create(OPEN_BRACE422);
                adaptor.addChild(root_0, OPEN_BRACE422_tree);

                pushFollow(FOLLOW_register_list_in_insn_format35c_method_odex5258);
                register_list423 = register_list();
                state._fsp--;

                adaptor.addChild(root_0, register_list423.getTree());

                CLOSE_BRACE424 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format35c_method_odex5260);
                CLOSE_BRACE424_tree = (CommonTree) adaptor.create(CLOSE_BRACE424);
                adaptor.addChild(root_0, CLOSE_BRACE424_tree);

                COMMA425 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format35c_method_odex5262);
                COMMA425_tree = (CommonTree) adaptor.create(COMMA425);
                adaptor.addChild(root_0, COMMA425_tree);

                pushFollow(FOLLOW_method_reference_in_insn_format35c_method_odex5264);
                method_reference426 = method_reference();
                state._fsp--;

                adaptor.addChild(root_0, method_reference426.getTree());


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT35c_METHOD_ODEX421 != null ? INSTRUCTION_FORMAT35c_METHOD_ODEX421.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format35c_method_odex"


    public static class insn_format35mi_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format35mi_method"
    // smaliParser.g:1036:1: insn_format35mi_method : INSTRUCTION_FORMAT35mi_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA INLINE_INDEX ;
    public final smaliParser.insn_format35mi_method_return insn_format35mi_method() throws RecognitionException {
        smaliParser.insn_format35mi_method_return retval = new smaliParser.insn_format35mi_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT35mi_METHOD427 = null;
        Token OPEN_BRACE428 = null;
        Token CLOSE_BRACE430 = null;
        Token COMMA431 = null;
        Token INLINE_INDEX432 = null;
        ParserRuleReturnScope register_list429 = null;

        CommonTree INSTRUCTION_FORMAT35mi_METHOD427_tree = null;
        CommonTree OPEN_BRACE428_tree = null;
        CommonTree CLOSE_BRACE430_tree = null;
        CommonTree COMMA431_tree = null;
        CommonTree INLINE_INDEX432_tree = null;

        try {
            // smaliParser.g:1037:3: ( INSTRUCTION_FORMAT35mi_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA INLINE_INDEX )
            // smaliParser.g:1038:5: INSTRUCTION_FORMAT35mi_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA INLINE_INDEX
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT35mi_METHOD427 = (Token) match(input, INSTRUCTION_FORMAT35mi_METHOD, FOLLOW_INSTRUCTION_FORMAT35mi_METHOD_in_insn_format35mi_method5285);
                INSTRUCTION_FORMAT35mi_METHOD427_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT35mi_METHOD427);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT35mi_METHOD427_tree);

                OPEN_BRACE428 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format35mi_method5287);
                OPEN_BRACE428_tree = (CommonTree) adaptor.create(OPEN_BRACE428);
                adaptor.addChild(root_0, OPEN_BRACE428_tree);

                pushFollow(FOLLOW_register_list_in_insn_format35mi_method5289);
                register_list429 = register_list();
                state._fsp--;

                adaptor.addChild(root_0, register_list429.getTree());

                CLOSE_BRACE430 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format35mi_method5291);
                CLOSE_BRACE430_tree = (CommonTree) adaptor.create(CLOSE_BRACE430);
                adaptor.addChild(root_0, CLOSE_BRACE430_tree);

                COMMA431 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format35mi_method5293);
                COMMA431_tree = (CommonTree) adaptor.create(COMMA431);
                adaptor.addChild(root_0, COMMA431_tree);

                INLINE_INDEX432 = (Token) match(input, INLINE_INDEX, FOLLOW_INLINE_INDEX_in_insn_format35mi_method5295);
                INLINE_INDEX432_tree = (CommonTree) adaptor.create(INLINE_INDEX432);
                adaptor.addChild(root_0, INLINE_INDEX432_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT35mi_METHOD427 != null ? INSTRUCTION_FORMAT35mi_METHOD427.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format35mi_method"


    public static class insn_format35ms_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format35ms_method"
    // smaliParser.g:1043:1: insn_format35ms_method : INSTRUCTION_FORMAT35ms_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA VTABLE_INDEX ;
    public final smaliParser.insn_format35ms_method_return insn_format35ms_method() throws RecognitionException {
        smaliParser.insn_format35ms_method_return retval = new smaliParser.insn_format35ms_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT35ms_METHOD433 = null;
        Token OPEN_BRACE434 = null;
        Token CLOSE_BRACE436 = null;
        Token COMMA437 = null;
        Token VTABLE_INDEX438 = null;
        ParserRuleReturnScope register_list435 = null;

        CommonTree INSTRUCTION_FORMAT35ms_METHOD433_tree = null;
        CommonTree OPEN_BRACE434_tree = null;
        CommonTree CLOSE_BRACE436_tree = null;
        CommonTree COMMA437_tree = null;
        CommonTree VTABLE_INDEX438_tree = null;

        try {
            // smaliParser.g:1044:3: ( INSTRUCTION_FORMAT35ms_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA VTABLE_INDEX )
            // smaliParser.g:1045:5: INSTRUCTION_FORMAT35ms_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA VTABLE_INDEX
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT35ms_METHOD433 = (Token) match(input, INSTRUCTION_FORMAT35ms_METHOD, FOLLOW_INSTRUCTION_FORMAT35ms_METHOD_in_insn_format35ms_method5316);
                INSTRUCTION_FORMAT35ms_METHOD433_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT35ms_METHOD433);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT35ms_METHOD433_tree);

                OPEN_BRACE434 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format35ms_method5318);
                OPEN_BRACE434_tree = (CommonTree) adaptor.create(OPEN_BRACE434);
                adaptor.addChild(root_0, OPEN_BRACE434_tree);

                pushFollow(FOLLOW_register_list_in_insn_format35ms_method5320);
                register_list435 = register_list();
                state._fsp--;

                adaptor.addChild(root_0, register_list435.getTree());

                CLOSE_BRACE436 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format35ms_method5322);
                CLOSE_BRACE436_tree = (CommonTree) adaptor.create(CLOSE_BRACE436);
                adaptor.addChild(root_0, CLOSE_BRACE436_tree);

                COMMA437 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format35ms_method5324);
                COMMA437_tree = (CommonTree) adaptor.create(COMMA437);
                adaptor.addChild(root_0, COMMA437_tree);

                VTABLE_INDEX438 = (Token) match(input, VTABLE_INDEX, FOLLOW_VTABLE_INDEX_in_insn_format35ms_method5326);
                VTABLE_INDEX438_tree = (CommonTree) adaptor.create(VTABLE_INDEX438);
                adaptor.addChild(root_0, VTABLE_INDEX438_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT35ms_METHOD433 != null ? INSTRUCTION_FORMAT35ms_METHOD433.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format35ms_method"


    public static class insn_format3rc_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format3rc_method"
    // smaliParser.g:1050:1: insn_format3rc_method : INSTRUCTION_FORMAT3rc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference -> ^( I_STATEMENT_FORMAT3rc_METHOD[$start, \"I_STATEMENT_FORMAT3rc_METHOD\"] INSTRUCTION_FORMAT3rc_METHOD register_range method_reference ) ;
    public final smaliParser.insn_format3rc_method_return insn_format3rc_method() throws RecognitionException {
        smaliParser.insn_format3rc_method_return retval = new smaliParser.insn_format3rc_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT3rc_METHOD439 = null;
        Token OPEN_BRACE440 = null;
        Token CLOSE_BRACE442 = null;
        Token COMMA443 = null;
        ParserRuleReturnScope register_range441 = null;
        ParserRuleReturnScope method_reference444 = null;

        CommonTree INSTRUCTION_FORMAT3rc_METHOD439_tree = null;
        CommonTree OPEN_BRACE440_tree = null;
        CommonTree CLOSE_BRACE442_tree = null;
        CommonTree COMMA443_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT3rc_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT3rc_METHOD");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleSubtreeStream stream_method_reference = new RewriteRuleSubtreeStream(adaptor, "rule method_reference");
        RewriteRuleSubtreeStream stream_register_range = new RewriteRuleSubtreeStream(adaptor, "rule register_range");

        try {
            // smaliParser.g:1051:3: ( INSTRUCTION_FORMAT3rc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference -> ^( I_STATEMENT_FORMAT3rc_METHOD[$start, \"I_STATEMENT_FORMAT3rc_METHOD\"] INSTRUCTION_FORMAT3rc_METHOD register_range method_reference ) )
            // smaliParser.g:1052:5: INSTRUCTION_FORMAT3rc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference
            {
                INSTRUCTION_FORMAT3rc_METHOD439 = (Token) match(input, INSTRUCTION_FORMAT3rc_METHOD, FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_in_insn_format3rc_method5347);
                stream_INSTRUCTION_FORMAT3rc_METHOD.add(INSTRUCTION_FORMAT3rc_METHOD439);

                OPEN_BRACE440 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format3rc_method5349);
                stream_OPEN_BRACE.add(OPEN_BRACE440);

                pushFollow(FOLLOW_register_range_in_insn_format3rc_method5351);
                register_range441 = register_range();
                state._fsp--;

                stream_register_range.add(register_range441.getTree());
                CLOSE_BRACE442 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format3rc_method5353);
                stream_CLOSE_BRACE.add(CLOSE_BRACE442);

                COMMA443 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format3rc_method5355);
                stream_COMMA.add(COMMA443);

                pushFollow(FOLLOW_method_reference_in_insn_format3rc_method5357);
                method_reference444 = method_reference();
                state._fsp--;

                stream_method_reference.add(method_reference444.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT3rc_METHOD, register_range, method_reference
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1053:5: -> ^( I_STATEMENT_FORMAT3rc_METHOD[$start, \"I_STATEMENT_FORMAT3rc_METHOD\"] INSTRUCTION_FORMAT3rc_METHOD register_range method_reference )
                {
                    // smaliParser.g:1053:8: ^( I_STATEMENT_FORMAT3rc_METHOD[$start, \"I_STATEMENT_FORMAT3rc_METHOD\"] INSTRUCTION_FORMAT3rc_METHOD register_range method_reference )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT3rc_METHOD, (retval.start), "I_STATEMENT_FORMAT3rc_METHOD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT3rc_METHOD.nextNode());
                        adaptor.addChild(root_1, stream_register_range.nextTree());
                        adaptor.addChild(root_1, stream_method_reference.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format3rc_method"


    public static class insn_format3rc_method_odex_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format3rc_method_odex"
    // smaliParser.g:1055:1: insn_format3rc_method_odex : INSTRUCTION_FORMAT3rc_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference ;
    public final smaliParser.insn_format3rc_method_odex_return insn_format3rc_method_odex() throws RecognitionException {
        smaliParser.insn_format3rc_method_odex_return retval = new smaliParser.insn_format3rc_method_odex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT3rc_METHOD_ODEX445 = null;
        Token OPEN_BRACE446 = null;
        Token CLOSE_BRACE448 = null;
        Token COMMA449 = null;
        ParserRuleReturnScope register_list447 = null;
        ParserRuleReturnScope method_reference450 = null;

        CommonTree INSTRUCTION_FORMAT3rc_METHOD_ODEX445_tree = null;
        CommonTree OPEN_BRACE446_tree = null;
        CommonTree CLOSE_BRACE448_tree = null;
        CommonTree COMMA449_tree = null;

        try {
            // smaliParser.g:1056:3: ( INSTRUCTION_FORMAT3rc_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference )
            // smaliParser.g:1057:5: INSTRUCTION_FORMAT3rc_METHOD_ODEX OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT3rc_METHOD_ODEX445 = (Token) match(input, INSTRUCTION_FORMAT3rc_METHOD_ODEX, FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_ODEX_in_insn_format3rc_method_odex5389);
                INSTRUCTION_FORMAT3rc_METHOD_ODEX445_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT3rc_METHOD_ODEX445);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT3rc_METHOD_ODEX445_tree);

                OPEN_BRACE446 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format3rc_method_odex5391);
                OPEN_BRACE446_tree = (CommonTree) adaptor.create(OPEN_BRACE446);
                adaptor.addChild(root_0, OPEN_BRACE446_tree);

                pushFollow(FOLLOW_register_list_in_insn_format3rc_method_odex5393);
                register_list447 = register_list();
                state._fsp--;

                adaptor.addChild(root_0, register_list447.getTree());

                CLOSE_BRACE448 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format3rc_method_odex5395);
                CLOSE_BRACE448_tree = (CommonTree) adaptor.create(CLOSE_BRACE448);
                adaptor.addChild(root_0, CLOSE_BRACE448_tree);

                COMMA449 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format3rc_method_odex5397);
                COMMA449_tree = (CommonTree) adaptor.create(COMMA449);
                adaptor.addChild(root_0, COMMA449_tree);

                pushFollow(FOLLOW_method_reference_in_insn_format3rc_method_odex5399);
                method_reference450 = method_reference();
                state._fsp--;

                adaptor.addChild(root_0, method_reference450.getTree());


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT3rc_METHOD_ODEX445 != null ? INSTRUCTION_FORMAT3rc_METHOD_ODEX445.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format3rc_method_odex"


    public static class insn_format3rc_type_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format3rc_type"
    // smaliParser.g:1062:1: insn_format3rc_type : INSTRUCTION_FORMAT3rc_TYPE OPEN_BRACE register_range CLOSE_BRACE COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT3rc_TYPE[$start, \"I_STATEMENT_FORMAT3rc_TYPE\"] INSTRUCTION_FORMAT3rc_TYPE register_range nonvoid_type_descriptor ) ;
    public final smaliParser.insn_format3rc_type_return insn_format3rc_type() throws RecognitionException {
        smaliParser.insn_format3rc_type_return retval = new smaliParser.insn_format3rc_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT3rc_TYPE451 = null;
        Token OPEN_BRACE452 = null;
        Token CLOSE_BRACE454 = null;
        Token COMMA455 = null;
        ParserRuleReturnScope register_range453 = null;
        ParserRuleReturnScope nonvoid_type_descriptor456 = null;

        CommonTree INSTRUCTION_FORMAT3rc_TYPE451_tree = null;
        CommonTree OPEN_BRACE452_tree = null;
        CommonTree CLOSE_BRACE454_tree = null;
        CommonTree COMMA455_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT3rc_TYPE = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT3rc_TYPE");
        RewriteRuleSubtreeStream stream_nonvoid_type_descriptor = new RewriteRuleSubtreeStream(adaptor, "rule nonvoid_type_descriptor");
        RewriteRuleSubtreeStream stream_register_range = new RewriteRuleSubtreeStream(adaptor, "rule register_range");

        try {
            // smaliParser.g:1063:3: ( INSTRUCTION_FORMAT3rc_TYPE OPEN_BRACE register_range CLOSE_BRACE COMMA nonvoid_type_descriptor -> ^( I_STATEMENT_FORMAT3rc_TYPE[$start, \"I_STATEMENT_FORMAT3rc_TYPE\"] INSTRUCTION_FORMAT3rc_TYPE register_range nonvoid_type_descriptor ) )
            // smaliParser.g:1064:5: INSTRUCTION_FORMAT3rc_TYPE OPEN_BRACE register_range CLOSE_BRACE COMMA nonvoid_type_descriptor
            {
                INSTRUCTION_FORMAT3rc_TYPE451 = (Token) match(input, INSTRUCTION_FORMAT3rc_TYPE, FOLLOW_INSTRUCTION_FORMAT3rc_TYPE_in_insn_format3rc_type5420);
                stream_INSTRUCTION_FORMAT3rc_TYPE.add(INSTRUCTION_FORMAT3rc_TYPE451);

                OPEN_BRACE452 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format3rc_type5422);
                stream_OPEN_BRACE.add(OPEN_BRACE452);

                pushFollow(FOLLOW_register_range_in_insn_format3rc_type5424);
                register_range453 = register_range();
                state._fsp--;

                stream_register_range.add(register_range453.getTree());
                CLOSE_BRACE454 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format3rc_type5426);
                stream_CLOSE_BRACE.add(CLOSE_BRACE454);

                COMMA455 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format3rc_type5428);
                stream_COMMA.add(COMMA455);

                pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format3rc_type5430);
                nonvoid_type_descriptor456 = nonvoid_type_descriptor();
                state._fsp--;

                stream_nonvoid_type_descriptor.add(nonvoid_type_descriptor456.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT3rc_TYPE, nonvoid_type_descriptor, register_range
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1065:5: -> ^( I_STATEMENT_FORMAT3rc_TYPE[$start, \"I_STATEMENT_FORMAT3rc_TYPE\"] INSTRUCTION_FORMAT3rc_TYPE register_range nonvoid_type_descriptor )
                {
                    // smaliParser.g:1065:8: ^( I_STATEMENT_FORMAT3rc_TYPE[$start, \"I_STATEMENT_FORMAT3rc_TYPE\"] INSTRUCTION_FORMAT3rc_TYPE register_range nonvoid_type_descriptor )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT3rc_TYPE, (retval.start), "I_STATEMENT_FORMAT3rc_TYPE"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT3rc_TYPE.nextNode());
                        adaptor.addChild(root_1, stream_register_range.nextTree());
                        adaptor.addChild(root_1, stream_nonvoid_type_descriptor.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format3rc_type"


    public static class insn_format3rmi_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format3rmi_method"
    // smaliParser.g:1067:1: insn_format3rmi_method : INSTRUCTION_FORMAT3rmi_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA INLINE_INDEX ;
    public final smaliParser.insn_format3rmi_method_return insn_format3rmi_method() throws RecognitionException {
        smaliParser.insn_format3rmi_method_return retval = new smaliParser.insn_format3rmi_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT3rmi_METHOD457 = null;
        Token OPEN_BRACE458 = null;
        Token CLOSE_BRACE460 = null;
        Token COMMA461 = null;
        Token INLINE_INDEX462 = null;
        ParserRuleReturnScope register_range459 = null;

        CommonTree INSTRUCTION_FORMAT3rmi_METHOD457_tree = null;
        CommonTree OPEN_BRACE458_tree = null;
        CommonTree CLOSE_BRACE460_tree = null;
        CommonTree COMMA461_tree = null;
        CommonTree INLINE_INDEX462_tree = null;

        try {
            // smaliParser.g:1068:3: ( INSTRUCTION_FORMAT3rmi_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA INLINE_INDEX )
            // smaliParser.g:1069:5: INSTRUCTION_FORMAT3rmi_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA INLINE_INDEX
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT3rmi_METHOD457 = (Token) match(input, INSTRUCTION_FORMAT3rmi_METHOD, FOLLOW_INSTRUCTION_FORMAT3rmi_METHOD_in_insn_format3rmi_method5462);
                INSTRUCTION_FORMAT3rmi_METHOD457_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT3rmi_METHOD457);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT3rmi_METHOD457_tree);

                OPEN_BRACE458 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format3rmi_method5464);
                OPEN_BRACE458_tree = (CommonTree) adaptor.create(OPEN_BRACE458);
                adaptor.addChild(root_0, OPEN_BRACE458_tree);

                pushFollow(FOLLOW_register_range_in_insn_format3rmi_method5466);
                register_range459 = register_range();
                state._fsp--;

                adaptor.addChild(root_0, register_range459.getTree());

                CLOSE_BRACE460 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format3rmi_method5468);
                CLOSE_BRACE460_tree = (CommonTree) adaptor.create(CLOSE_BRACE460);
                adaptor.addChild(root_0, CLOSE_BRACE460_tree);

                COMMA461 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format3rmi_method5470);
                COMMA461_tree = (CommonTree) adaptor.create(COMMA461);
                adaptor.addChild(root_0, COMMA461_tree);

                INLINE_INDEX462 = (Token) match(input, INLINE_INDEX, FOLLOW_INLINE_INDEX_in_insn_format3rmi_method5472);
                INLINE_INDEX462_tree = (CommonTree) adaptor.create(INLINE_INDEX462);
                adaptor.addChild(root_0, INLINE_INDEX462_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT3rmi_METHOD457 != null ? INSTRUCTION_FORMAT3rmi_METHOD457.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format3rmi_method"


    public static class insn_format3rms_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format3rms_method"
    // smaliParser.g:1074:1: insn_format3rms_method : INSTRUCTION_FORMAT3rms_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA VTABLE_INDEX ;
    public final smaliParser.insn_format3rms_method_return insn_format3rms_method() throws RecognitionException {
        smaliParser.insn_format3rms_method_return retval = new smaliParser.insn_format3rms_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT3rms_METHOD463 = null;
        Token OPEN_BRACE464 = null;
        Token CLOSE_BRACE466 = null;
        Token COMMA467 = null;
        Token VTABLE_INDEX468 = null;
        ParserRuleReturnScope register_range465 = null;

        CommonTree INSTRUCTION_FORMAT3rms_METHOD463_tree = null;
        CommonTree OPEN_BRACE464_tree = null;
        CommonTree CLOSE_BRACE466_tree = null;
        CommonTree COMMA467_tree = null;
        CommonTree VTABLE_INDEX468_tree = null;

        try {
            // smaliParser.g:1075:3: ( INSTRUCTION_FORMAT3rms_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA VTABLE_INDEX )
            // smaliParser.g:1076:5: INSTRUCTION_FORMAT3rms_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA VTABLE_INDEX
            {
                root_0 = (CommonTree) adaptor.nil();


                INSTRUCTION_FORMAT3rms_METHOD463 = (Token) match(input, INSTRUCTION_FORMAT3rms_METHOD, FOLLOW_INSTRUCTION_FORMAT3rms_METHOD_in_insn_format3rms_method5493);
                INSTRUCTION_FORMAT3rms_METHOD463_tree = (CommonTree) adaptor.create(INSTRUCTION_FORMAT3rms_METHOD463);
                adaptor.addChild(root_0, INSTRUCTION_FORMAT3rms_METHOD463_tree);

                OPEN_BRACE464 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format3rms_method5495);
                OPEN_BRACE464_tree = (CommonTree) adaptor.create(OPEN_BRACE464);
                adaptor.addChild(root_0, OPEN_BRACE464_tree);

                pushFollow(FOLLOW_register_range_in_insn_format3rms_method5497);
                register_range465 = register_range();
                state._fsp--;

                adaptor.addChild(root_0, register_range465.getTree());

                CLOSE_BRACE466 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format3rms_method5499);
                CLOSE_BRACE466_tree = (CommonTree) adaptor.create(CLOSE_BRACE466);
                adaptor.addChild(root_0, CLOSE_BRACE466_tree);

                COMMA467 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format3rms_method5501);
                COMMA467_tree = (CommonTree) adaptor.create(COMMA467);
                adaptor.addChild(root_0, COMMA467_tree);

                VTABLE_INDEX468 = (Token) match(input, VTABLE_INDEX, FOLLOW_VTABLE_INDEX_in_insn_format3rms_method5503);
                VTABLE_INDEX468_tree = (CommonTree) adaptor.create(VTABLE_INDEX468);
                adaptor.addChild(root_0, VTABLE_INDEX468_tree);


                throwOdexedInstructionException(input, (INSTRUCTION_FORMAT3rms_METHOD463 != null ? INSTRUCTION_FORMAT3rms_METHOD463.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format3rms_method"


    public static class insn_format45cc_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format45cc_method"
    // smaliParser.g:1081:1: insn_format45cc_method : INSTRUCTION_FORMAT45cc_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference COMMA method_prototype -> ^( I_STATEMENT_FORMAT45cc_METHOD[$start, \"I_STATEMENT_FORMAT45cc_METHOD\"] INSTRUCTION_FORMAT45cc_METHOD register_list method_reference method_prototype ) ;
    public final smaliParser.insn_format45cc_method_return insn_format45cc_method() throws RecognitionException {
        smaliParser.insn_format45cc_method_return retval = new smaliParser.insn_format45cc_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT45cc_METHOD469 = null;
        Token OPEN_BRACE470 = null;
        Token CLOSE_BRACE472 = null;
        Token COMMA473 = null;
        Token COMMA475 = null;
        ParserRuleReturnScope register_list471 = null;
        ParserRuleReturnScope method_reference474 = null;
        ParserRuleReturnScope method_prototype476 = null;

        CommonTree INSTRUCTION_FORMAT45cc_METHOD469_tree = null;
        CommonTree OPEN_BRACE470_tree = null;
        CommonTree CLOSE_BRACE472_tree = null;
        CommonTree COMMA473_tree = null;
        CommonTree COMMA475_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT45cc_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT45cc_METHOD");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleSubtreeStream stream_method_reference = new RewriteRuleSubtreeStream(adaptor, "rule method_reference");
        RewriteRuleSubtreeStream stream_method_prototype = new RewriteRuleSubtreeStream(adaptor, "rule method_prototype");
        RewriteRuleSubtreeStream stream_register_list = new RewriteRuleSubtreeStream(adaptor, "rule register_list");

        try {
            // smaliParser.g:1082:3: ( INSTRUCTION_FORMAT45cc_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference COMMA method_prototype -> ^( I_STATEMENT_FORMAT45cc_METHOD[$start, \"I_STATEMENT_FORMAT45cc_METHOD\"] INSTRUCTION_FORMAT45cc_METHOD register_list method_reference method_prototype ) )
            // smaliParser.g:1083:5: INSTRUCTION_FORMAT45cc_METHOD OPEN_BRACE register_list CLOSE_BRACE COMMA method_reference COMMA method_prototype
            {
                INSTRUCTION_FORMAT45cc_METHOD469 = (Token) match(input, INSTRUCTION_FORMAT45cc_METHOD, FOLLOW_INSTRUCTION_FORMAT45cc_METHOD_in_insn_format45cc_method5524);
                stream_INSTRUCTION_FORMAT45cc_METHOD.add(INSTRUCTION_FORMAT45cc_METHOD469);

                OPEN_BRACE470 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format45cc_method5526);
                stream_OPEN_BRACE.add(OPEN_BRACE470);

                pushFollow(FOLLOW_register_list_in_insn_format45cc_method5528);
                register_list471 = register_list();
                state._fsp--;

                stream_register_list.add(register_list471.getTree());
                CLOSE_BRACE472 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format45cc_method5530);
                stream_CLOSE_BRACE.add(CLOSE_BRACE472);

                COMMA473 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format45cc_method5532);
                stream_COMMA.add(COMMA473);

                pushFollow(FOLLOW_method_reference_in_insn_format45cc_method5534);
                method_reference474 = method_reference();
                state._fsp--;

                stream_method_reference.add(method_reference474.getTree());
                COMMA475 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format45cc_method5536);
                stream_COMMA.add(COMMA475);

                pushFollow(FOLLOW_method_prototype_in_insn_format45cc_method5538);
                method_prototype476 = method_prototype();
                state._fsp--;

                stream_method_prototype.add(method_prototype476.getTree());
                // AST REWRITE
                // elements: method_reference, method_prototype, INSTRUCTION_FORMAT45cc_METHOD, register_list
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1084:5: -> ^( I_STATEMENT_FORMAT45cc_METHOD[$start, \"I_STATEMENT_FORMAT45cc_METHOD\"] INSTRUCTION_FORMAT45cc_METHOD register_list method_reference method_prototype )
                {
                    // smaliParser.g:1084:8: ^( I_STATEMENT_FORMAT45cc_METHOD[$start, \"I_STATEMENT_FORMAT45cc_METHOD\"] INSTRUCTION_FORMAT45cc_METHOD register_list method_reference method_prototype )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT45cc_METHOD, (retval.start), "I_STATEMENT_FORMAT45cc_METHOD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT45cc_METHOD.nextNode());
                        adaptor.addChild(root_1, stream_register_list.nextTree());
                        adaptor.addChild(root_1, stream_method_reference.nextTree());
                        adaptor.addChild(root_1, stream_method_prototype.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format45cc_method"


    public static class insn_format4rcc_method_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format4rcc_method"
    // smaliParser.g:1086:1: insn_format4rcc_method : INSTRUCTION_FORMAT4rcc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference COMMA method_prototype -> ^( I_STATEMENT_FORMAT4rcc_METHOD[$start, \"I_STATEMENT_FORMAT4rcc_METHOD\"] INSTRUCTION_FORMAT4rcc_METHOD register_range method_reference method_prototype ) ;
    public final smaliParser.insn_format4rcc_method_return insn_format4rcc_method() throws RecognitionException {
        smaliParser.insn_format4rcc_method_return retval = new smaliParser.insn_format4rcc_method_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT4rcc_METHOD477 = null;
        Token OPEN_BRACE478 = null;
        Token CLOSE_BRACE480 = null;
        Token COMMA481 = null;
        Token COMMA483 = null;
        ParserRuleReturnScope register_range479 = null;
        ParserRuleReturnScope method_reference482 = null;
        ParserRuleReturnScope method_prototype484 = null;

        CommonTree INSTRUCTION_FORMAT4rcc_METHOD477_tree = null;
        CommonTree OPEN_BRACE478_tree = null;
        CommonTree CLOSE_BRACE480_tree = null;
        CommonTree COMMA481_tree = null;
        CommonTree COMMA483_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_OPEN_BRACE = new RewriteRuleTokenStream(adaptor, "token OPEN_BRACE");
        RewriteRuleTokenStream stream_CLOSE_BRACE = new RewriteRuleTokenStream(adaptor, "token CLOSE_BRACE");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT4rcc_METHOD = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT4rcc_METHOD");
        RewriteRuleSubtreeStream stream_method_reference = new RewriteRuleSubtreeStream(adaptor, "rule method_reference");
        RewriteRuleSubtreeStream stream_method_prototype = new RewriteRuleSubtreeStream(adaptor, "rule method_prototype");
        RewriteRuleSubtreeStream stream_register_range = new RewriteRuleSubtreeStream(adaptor, "rule register_range");

        try {
            // smaliParser.g:1087:3: ( INSTRUCTION_FORMAT4rcc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference COMMA method_prototype -> ^( I_STATEMENT_FORMAT4rcc_METHOD[$start, \"I_STATEMENT_FORMAT4rcc_METHOD\"] INSTRUCTION_FORMAT4rcc_METHOD register_range method_reference method_prototype ) )
            // smaliParser.g:1088:5: INSTRUCTION_FORMAT4rcc_METHOD OPEN_BRACE register_range CLOSE_BRACE COMMA method_reference COMMA method_prototype
            {
                INSTRUCTION_FORMAT4rcc_METHOD477 = (Token) match(input, INSTRUCTION_FORMAT4rcc_METHOD, FOLLOW_INSTRUCTION_FORMAT4rcc_METHOD_in_insn_format4rcc_method5572);
                stream_INSTRUCTION_FORMAT4rcc_METHOD.add(INSTRUCTION_FORMAT4rcc_METHOD477);

                OPEN_BRACE478 = (Token) match(input, OPEN_BRACE, FOLLOW_OPEN_BRACE_in_insn_format4rcc_method5574);
                stream_OPEN_BRACE.add(OPEN_BRACE478);

                pushFollow(FOLLOW_register_range_in_insn_format4rcc_method5576);
                register_range479 = register_range();
                state._fsp--;

                stream_register_range.add(register_range479.getTree());
                CLOSE_BRACE480 = (Token) match(input, CLOSE_BRACE, FOLLOW_CLOSE_BRACE_in_insn_format4rcc_method5578);
                stream_CLOSE_BRACE.add(CLOSE_BRACE480);

                COMMA481 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format4rcc_method5580);
                stream_COMMA.add(COMMA481);

                pushFollow(FOLLOW_method_reference_in_insn_format4rcc_method5582);
                method_reference482 = method_reference();
                state._fsp--;

                stream_method_reference.add(method_reference482.getTree());
                COMMA483 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format4rcc_method5584);
                stream_COMMA.add(COMMA483);

                pushFollow(FOLLOW_method_prototype_in_insn_format4rcc_method5586);
                method_prototype484 = method_prototype();
                state._fsp--;

                stream_method_prototype.add(method_prototype484.getTree());
                // AST REWRITE
                // elements: INSTRUCTION_FORMAT4rcc_METHOD, register_range, method_reference, method_prototype
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1089:5: -> ^( I_STATEMENT_FORMAT4rcc_METHOD[$start, \"I_STATEMENT_FORMAT4rcc_METHOD\"] INSTRUCTION_FORMAT4rcc_METHOD register_range method_reference method_prototype )
                {
                    // smaliParser.g:1089:8: ^( I_STATEMENT_FORMAT4rcc_METHOD[$start, \"I_STATEMENT_FORMAT4rcc_METHOD\"] INSTRUCTION_FORMAT4rcc_METHOD register_range method_reference method_prototype )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT4rcc_METHOD, (retval.start), "I_STATEMENT_FORMAT4rcc_METHOD"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT4rcc_METHOD.nextNode());
                        adaptor.addChild(root_1, stream_register_range.nextTree());
                        adaptor.addChild(root_1, stream_method_reference.nextTree());
                        adaptor.addChild(root_1, stream_method_prototype.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format4rcc_method"


    public static class insn_format51l_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_format51l"
    // smaliParser.g:1091:1: insn_format51l : INSTRUCTION_FORMAT51l REGISTER COMMA fixed_literal -> ^( I_STATEMENT_FORMAT51l[$start, \"I_STATEMENT_FORMAT51l\"] INSTRUCTION_FORMAT51l REGISTER fixed_literal ) ;
    public final smaliParser.insn_format51l_return insn_format51l() throws RecognitionException {
        smaliParser.insn_format51l_return retval = new smaliParser.insn_format51l_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTRUCTION_FORMAT51l485 = null;
        Token REGISTER486 = null;
        Token COMMA487 = null;
        ParserRuleReturnScope fixed_literal488 = null;

        CommonTree INSTRUCTION_FORMAT51l485_tree = null;
        CommonTree REGISTER486_tree = null;
        CommonTree COMMA487_tree = null;
        RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(adaptor, "token COMMA");
        RewriteRuleTokenStream stream_REGISTER = new RewriteRuleTokenStream(adaptor, "token REGISTER");
        RewriteRuleTokenStream stream_INSTRUCTION_FORMAT51l = new RewriteRuleTokenStream(adaptor, "token INSTRUCTION_FORMAT51l");
        RewriteRuleSubtreeStream stream_fixed_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_literal");

        try {
            // smaliParser.g:1092:3: ( INSTRUCTION_FORMAT51l REGISTER COMMA fixed_literal -> ^( I_STATEMENT_FORMAT51l[$start, \"I_STATEMENT_FORMAT51l\"] INSTRUCTION_FORMAT51l REGISTER fixed_literal ) )
            // smaliParser.g:1093:5: INSTRUCTION_FORMAT51l REGISTER COMMA fixed_literal
            {
                INSTRUCTION_FORMAT51l485 = (Token) match(input, INSTRUCTION_FORMAT51l, FOLLOW_INSTRUCTION_FORMAT51l_in_insn_format51l5620);
                stream_INSTRUCTION_FORMAT51l.add(INSTRUCTION_FORMAT51l485);

                REGISTER486 = (Token) match(input, REGISTER, FOLLOW_REGISTER_in_insn_format51l5622);
                stream_REGISTER.add(REGISTER486);

                COMMA487 = (Token) match(input, COMMA, FOLLOW_COMMA_in_insn_format51l5624);
                stream_COMMA.add(COMMA487);

                pushFollow(FOLLOW_fixed_literal_in_insn_format51l5626);
                fixed_literal488 = fixed_literal();
                state._fsp--;

                stream_fixed_literal.add(fixed_literal488.getTree());
                // AST REWRITE
                // elements: fixed_literal, INSTRUCTION_FORMAT51l, REGISTER
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1094:5: -> ^( I_STATEMENT_FORMAT51l[$start, \"I_STATEMENT_FORMAT51l\"] INSTRUCTION_FORMAT51l REGISTER fixed_literal )
                {
                    // smaliParser.g:1094:8: ^( I_STATEMENT_FORMAT51l[$start, \"I_STATEMENT_FORMAT51l\"] INSTRUCTION_FORMAT51l REGISTER fixed_literal )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_FORMAT51l, (retval.start), "I_STATEMENT_FORMAT51l"), root_1);
                        adaptor.addChild(root_1, stream_INSTRUCTION_FORMAT51l.nextNode());
                        adaptor.addChild(root_1, stream_REGISTER.nextNode());
                        adaptor.addChild(root_1, stream_fixed_literal.nextTree());
                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_format51l"


    public static class insn_array_data_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_array_data_directive"
    // smaliParser.g:1096:1: insn_array_data_directive : ARRAY_DATA_DIRECTIVE parsed_integer_literal ( fixed_literal )* END_ARRAY_DATA_DIRECTIVE -> ^( I_STATEMENT_ARRAY_DATA[$start, \"I_STATEMENT_ARRAY_DATA\"] ^( I_ARRAY_ELEMENT_SIZE parsed_integer_literal ) ^( I_ARRAY_ELEMENTS ( fixed_literal )* ) ) ;
    public final smaliParser.insn_array_data_directive_return insn_array_data_directive() throws RecognitionException {
        smaliParser.insn_array_data_directive_return retval = new smaliParser.insn_array_data_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARRAY_DATA_DIRECTIVE489 = null;
        Token END_ARRAY_DATA_DIRECTIVE492 = null;
        ParserRuleReturnScope parsed_integer_literal490 = null;
        ParserRuleReturnScope fixed_literal491 = null;

        CommonTree ARRAY_DATA_DIRECTIVE489_tree = null;
        CommonTree END_ARRAY_DATA_DIRECTIVE492_tree = null;
        RewriteRuleTokenStream stream_END_ARRAY_DATA_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_ARRAY_DATA_DIRECTIVE");
        RewriteRuleTokenStream stream_ARRAY_DATA_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token ARRAY_DATA_DIRECTIVE");
        RewriteRuleSubtreeStream stream_parsed_integer_literal = new RewriteRuleSubtreeStream(adaptor, "rule parsed_integer_literal");
        RewriteRuleSubtreeStream stream_fixed_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_literal");

        try {
            // smaliParser.g:1097:3: ( ARRAY_DATA_DIRECTIVE parsed_integer_literal ( fixed_literal )* END_ARRAY_DATA_DIRECTIVE -> ^( I_STATEMENT_ARRAY_DATA[$start, \"I_STATEMENT_ARRAY_DATA\"] ^( I_ARRAY_ELEMENT_SIZE parsed_integer_literal ) ^( I_ARRAY_ELEMENTS ( fixed_literal )* ) ) )
            // smaliParser.g:1097:5: ARRAY_DATA_DIRECTIVE parsed_integer_literal ( fixed_literal )* END_ARRAY_DATA_DIRECTIVE
            {
                ARRAY_DATA_DIRECTIVE489 = (Token) match(input, ARRAY_DATA_DIRECTIVE, FOLLOW_ARRAY_DATA_DIRECTIVE_in_insn_array_data_directive5653);
                stream_ARRAY_DATA_DIRECTIVE.add(ARRAY_DATA_DIRECTIVE489);

                pushFollow(FOLLOW_parsed_integer_literal_in_insn_array_data_directive5659);
                parsed_integer_literal490 = parsed_integer_literal();
                state._fsp--;

                stream_parsed_integer_literal.add(parsed_integer_literal490.getTree());

                int elementWidth = (parsed_integer_literal490 != null ? ((smaliParser.parsed_integer_literal_return) parsed_integer_literal490).value : 0);
                if (elementWidth != 4 && elementWidth != 8 && elementWidth != 1 && elementWidth != 2) {
                    throw new SemanticException(input, (retval.start), "Invalid element width: %d. Must be 1, 2, 4 or 8", elementWidth);
                }

                // smaliParser.g:1105:5: ( fixed_literal )*
                loop52:
                while (true) {
                    int alt52 = 2;
                    int LA52_0 = input.LA(1);
                    if (((LA52_0 >= BOOL_LITERAL && LA52_0 <= BYTE_LITERAL) || LA52_0 == CHAR_LITERAL || (LA52_0 >= DOUBLE_LITERAL && LA52_0 <= DOUBLE_LITERAL_OR_ID) || (LA52_0 >= FLOAT_LITERAL && LA52_0 <= FLOAT_LITERAL_OR_ID) || LA52_0 == LONG_LITERAL || LA52_0 == NEGATIVE_INTEGER_LITERAL || LA52_0 == POSITIVE_INTEGER_LITERAL || LA52_0 == SHORT_LITERAL)) {
                        alt52 = 1;
                    }

                    switch (alt52) {
                        case 1:
                            // smaliParser.g:1105:5: fixed_literal
                        {
                            pushFollow(FOLLOW_fixed_literal_in_insn_array_data_directive5671);
                            fixed_literal491 = fixed_literal();
                            state._fsp--;

                            stream_fixed_literal.add(fixed_literal491.getTree());
                        }
                        break;

                        default:
                            break loop52;
                    }
                }

                END_ARRAY_DATA_DIRECTIVE492 = (Token) match(input, END_ARRAY_DATA_DIRECTIVE, FOLLOW_END_ARRAY_DATA_DIRECTIVE_in_insn_array_data_directive5674);
                stream_END_ARRAY_DATA_DIRECTIVE.add(END_ARRAY_DATA_DIRECTIVE492);

                // AST REWRITE
                // elements: parsed_integer_literal, fixed_literal
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1107:5: -> ^( I_STATEMENT_ARRAY_DATA[$start, \"I_STATEMENT_ARRAY_DATA\"] ^( I_ARRAY_ELEMENT_SIZE parsed_integer_literal ) ^( I_ARRAY_ELEMENTS ( fixed_literal )* ) )
                {
                    // smaliParser.g:1107:8: ^( I_STATEMENT_ARRAY_DATA[$start, \"I_STATEMENT_ARRAY_DATA\"] ^( I_ARRAY_ELEMENT_SIZE parsed_integer_literal ) ^( I_ARRAY_ELEMENTS ( fixed_literal )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_ARRAY_DATA, (retval.start), "I_STATEMENT_ARRAY_DATA"), root_1);
                        // smaliParser.g:1107:67: ^( I_ARRAY_ELEMENT_SIZE parsed_integer_literal )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ARRAY_ELEMENT_SIZE, "I_ARRAY_ELEMENT_SIZE"), root_2);
                            adaptor.addChild(root_2, stream_parsed_integer_literal.nextTree());
                            adaptor.addChild(root_1, root_2);
                        }

                        // smaliParser.g:1108:8: ^( I_ARRAY_ELEMENTS ( fixed_literal )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_ARRAY_ELEMENTS, "I_ARRAY_ELEMENTS"), root_2);
                            // smaliParser.g:1108:27: ( fixed_literal )*
                            while (stream_fixed_literal.hasNext()) {
                                adaptor.addChild(root_2, stream_fixed_literal.nextTree());
                            }
                            stream_fixed_literal.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_array_data_directive"


    public static class insn_packed_switch_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_packed_switch_directive"
    // smaliParser.g:1110:1: insn_packed_switch_directive : PACKED_SWITCH_DIRECTIVE fixed_32bit_literal ( label_ref )* END_PACKED_SWITCH_DIRECTIVE -> ^( I_STATEMENT_PACKED_SWITCH[$start, \"I_STATEMENT_PACKED_SWITCH\"] ^( I_PACKED_SWITCH_START_KEY[$start, \"I_PACKED_SWITCH_START_KEY\"] fixed_32bit_literal ) ^( I_PACKED_SWITCH_ELEMENTS[$start, \"I_PACKED_SWITCH_ELEMENTS\"] ( label_ref )* ) ) ;
    public final smaliParser.insn_packed_switch_directive_return insn_packed_switch_directive() throws RecognitionException {
        smaliParser.insn_packed_switch_directive_return retval = new smaliParser.insn_packed_switch_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PACKED_SWITCH_DIRECTIVE493 = null;
        Token END_PACKED_SWITCH_DIRECTIVE496 = null;
        ParserRuleReturnScope fixed_32bit_literal494 = null;
        ParserRuleReturnScope label_ref495 = null;

        CommonTree PACKED_SWITCH_DIRECTIVE493_tree = null;
        CommonTree END_PACKED_SWITCH_DIRECTIVE496_tree = null;
        RewriteRuleTokenStream stream_END_PACKED_SWITCH_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_PACKED_SWITCH_DIRECTIVE");
        RewriteRuleTokenStream stream_PACKED_SWITCH_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token PACKED_SWITCH_DIRECTIVE");
        RewriteRuleSubtreeStream stream_fixed_32bit_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_32bit_literal");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:1111:5: ( PACKED_SWITCH_DIRECTIVE fixed_32bit_literal ( label_ref )* END_PACKED_SWITCH_DIRECTIVE -> ^( I_STATEMENT_PACKED_SWITCH[$start, \"I_STATEMENT_PACKED_SWITCH\"] ^( I_PACKED_SWITCH_START_KEY[$start, \"I_PACKED_SWITCH_START_KEY\"] fixed_32bit_literal ) ^( I_PACKED_SWITCH_ELEMENTS[$start, \"I_PACKED_SWITCH_ELEMENTS\"] ( label_ref )* ) ) )
            // smaliParser.g:1111:9: PACKED_SWITCH_DIRECTIVE fixed_32bit_literal ( label_ref )* END_PACKED_SWITCH_DIRECTIVE
            {
                PACKED_SWITCH_DIRECTIVE493 = (Token) match(input, PACKED_SWITCH_DIRECTIVE, FOLLOW_PACKED_SWITCH_DIRECTIVE_in_insn_packed_switch_directive5720);
                stream_PACKED_SWITCH_DIRECTIVE.add(PACKED_SWITCH_DIRECTIVE493);

                pushFollow(FOLLOW_fixed_32bit_literal_in_insn_packed_switch_directive5726);
                fixed_32bit_literal494 = fixed_32bit_literal();
                state._fsp--;

                stream_fixed_32bit_literal.add(fixed_32bit_literal494.getTree());
                // smaliParser.g:1113:5: ( label_ref )*
                loop53:
                while (true) {
                    int alt53 = 2;
                    int LA53_0 = input.LA(1);
                    if ((LA53_0 == COLON)) {
                        alt53 = 1;
                    }

                    switch (alt53) {
                        case 1:
                            // smaliParser.g:1113:5: label_ref
                        {
                            pushFollow(FOLLOW_label_ref_in_insn_packed_switch_directive5732);
                            label_ref495 = label_ref();
                            state._fsp--;

                            stream_label_ref.add(label_ref495.getTree());
                        }
                        break;

                        default:
                            break loop53;
                    }
                }

                END_PACKED_SWITCH_DIRECTIVE496 = (Token) match(input, END_PACKED_SWITCH_DIRECTIVE, FOLLOW_END_PACKED_SWITCH_DIRECTIVE_in_insn_packed_switch_directive5739);
                stream_END_PACKED_SWITCH_DIRECTIVE.add(END_PACKED_SWITCH_DIRECTIVE496);

                // AST REWRITE
                // elements: fixed_32bit_literal, label_ref
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1115:5: -> ^( I_STATEMENT_PACKED_SWITCH[$start, \"I_STATEMENT_PACKED_SWITCH\"] ^( I_PACKED_SWITCH_START_KEY[$start, \"I_PACKED_SWITCH_START_KEY\"] fixed_32bit_literal ) ^( I_PACKED_SWITCH_ELEMENTS[$start, \"I_PACKED_SWITCH_ELEMENTS\"] ( label_ref )* ) )
                {
                    // smaliParser.g:1115:8: ^( I_STATEMENT_PACKED_SWITCH[$start, \"I_STATEMENT_PACKED_SWITCH\"] ^( I_PACKED_SWITCH_START_KEY[$start, \"I_PACKED_SWITCH_START_KEY\"] fixed_32bit_literal ) ^( I_PACKED_SWITCH_ELEMENTS[$start, \"I_PACKED_SWITCH_ELEMENTS\"] ( label_ref )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_PACKED_SWITCH, (retval.start), "I_STATEMENT_PACKED_SWITCH"), root_1);
                        // smaliParser.g:1116:10: ^( I_PACKED_SWITCH_START_KEY[$start, \"I_PACKED_SWITCH_START_KEY\"] fixed_32bit_literal )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PACKED_SWITCH_START_KEY, (retval.start), "I_PACKED_SWITCH_START_KEY"), root_2);
                            adaptor.addChild(root_2, stream_fixed_32bit_literal.nextTree());
                            adaptor.addChild(root_1, root_2);
                        }

                        // smaliParser.g:1117:10: ^( I_PACKED_SWITCH_ELEMENTS[$start, \"I_PACKED_SWITCH_ELEMENTS\"] ( label_ref )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_PACKED_SWITCH_ELEMENTS, (retval.start), "I_PACKED_SWITCH_ELEMENTS"), root_2);
                            // smaliParser.g:1118:11: ( label_ref )*
                            while (stream_label_ref.hasNext()) {
                                adaptor.addChild(root_2, stream_label_ref.nextTree());
                            }
                            stream_label_ref.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_packed_switch_directive"


    public static class insn_sparse_switch_directive_return extends ParserRuleReturnScope {
        CommonTree tree;

        @Override
        public CommonTree getTree() {
            return tree;
        }
    }

    ;


    // $ANTLR start "insn_sparse_switch_directive"
    // smaliParser.g:1121:1: insn_sparse_switch_directive : SPARSE_SWITCH_DIRECTIVE ( fixed_32bit_literal ARROW label_ref )* END_SPARSE_SWITCH_DIRECTIVE -> ^( I_STATEMENT_SPARSE_SWITCH[$start, \"I_STATEMENT_SPARSE_SWITCH\"] ^( I_SPARSE_SWITCH_ELEMENTS[$start, \"I_SPARSE_SWITCH_ELEMENTS\"] ( fixed_32bit_literal label_ref )* ) ) ;
    public final smaliParser.insn_sparse_switch_directive_return insn_sparse_switch_directive() throws RecognitionException {
        smaliParser.insn_sparse_switch_directive_return retval = new smaliParser.insn_sparse_switch_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SPARSE_SWITCH_DIRECTIVE497 = null;
        Token ARROW499 = null;
        Token END_SPARSE_SWITCH_DIRECTIVE501 = null;
        ParserRuleReturnScope fixed_32bit_literal498 = null;
        ParserRuleReturnScope label_ref500 = null;

        CommonTree SPARSE_SWITCH_DIRECTIVE497_tree = null;
        CommonTree ARROW499_tree = null;
        CommonTree END_SPARSE_SWITCH_DIRECTIVE501_tree = null;
        RewriteRuleTokenStream stream_ARROW = new RewriteRuleTokenStream(adaptor, "token ARROW");
        RewriteRuleTokenStream stream_SPARSE_SWITCH_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token SPARSE_SWITCH_DIRECTIVE");
        RewriteRuleTokenStream stream_END_SPARSE_SWITCH_DIRECTIVE = new RewriteRuleTokenStream(adaptor, "token END_SPARSE_SWITCH_DIRECTIVE");
        RewriteRuleSubtreeStream stream_fixed_32bit_literal = new RewriteRuleSubtreeStream(adaptor, "rule fixed_32bit_literal");
        RewriteRuleSubtreeStream stream_label_ref = new RewriteRuleSubtreeStream(adaptor, "rule label_ref");

        try {
            // smaliParser.g:1122:3: ( SPARSE_SWITCH_DIRECTIVE ( fixed_32bit_literal ARROW label_ref )* END_SPARSE_SWITCH_DIRECTIVE -> ^( I_STATEMENT_SPARSE_SWITCH[$start, \"I_STATEMENT_SPARSE_SWITCH\"] ^( I_SPARSE_SWITCH_ELEMENTS[$start, \"I_SPARSE_SWITCH_ELEMENTS\"] ( fixed_32bit_literal label_ref )* ) ) )
            // smaliParser.g:1122:7: SPARSE_SWITCH_DIRECTIVE ( fixed_32bit_literal ARROW label_ref )* END_SPARSE_SWITCH_DIRECTIVE
            {
                SPARSE_SWITCH_DIRECTIVE497 = (Token) match(input, SPARSE_SWITCH_DIRECTIVE, FOLLOW_SPARSE_SWITCH_DIRECTIVE_in_insn_sparse_switch_directive5813);
                stream_SPARSE_SWITCH_DIRECTIVE.add(SPARSE_SWITCH_DIRECTIVE497);

                // smaliParser.g:1123:5: ( fixed_32bit_literal ARROW label_ref )*
                loop54:
                while (true) {
                    int alt54 = 2;
                    int LA54_0 = input.LA(1);
                    if (((LA54_0 >= BOOL_LITERAL && LA54_0 <= BYTE_LITERAL) || LA54_0 == CHAR_LITERAL || (LA54_0 >= FLOAT_LITERAL && LA54_0 <= FLOAT_LITERAL_OR_ID) || LA54_0 == LONG_LITERAL || LA54_0 == NEGATIVE_INTEGER_LITERAL || LA54_0 == POSITIVE_INTEGER_LITERAL || LA54_0 == SHORT_LITERAL)) {
                        alt54 = 1;
                    }

                    switch (alt54) {
                        case 1:
                            // smaliParser.g:1123:6: fixed_32bit_literal ARROW label_ref
                        {
                            pushFollow(FOLLOW_fixed_32bit_literal_in_insn_sparse_switch_directive5820);
                            fixed_32bit_literal498 = fixed_32bit_literal();
                            state._fsp--;

                            stream_fixed_32bit_literal.add(fixed_32bit_literal498.getTree());
                            ARROW499 = (Token) match(input, ARROW, FOLLOW_ARROW_in_insn_sparse_switch_directive5822);
                            stream_ARROW.add(ARROW499);

                            pushFollow(FOLLOW_label_ref_in_insn_sparse_switch_directive5824);
                            label_ref500 = label_ref();
                            state._fsp--;

                            stream_label_ref.add(label_ref500.getTree());
                        }
                        break;

                        default:
                            break loop54;
                    }
                }

                END_SPARSE_SWITCH_DIRECTIVE501 = (Token) match(input, END_SPARSE_SWITCH_DIRECTIVE, FOLLOW_END_SPARSE_SWITCH_DIRECTIVE_in_insn_sparse_switch_directive5832);
                stream_END_SPARSE_SWITCH_DIRECTIVE.add(END_SPARSE_SWITCH_DIRECTIVE501);

                // AST REWRITE
                // elements: fixed_32bit_literal, label_ref
                // token labels:
                // rule labels: retval
                // token list labels:
                // rule list labels:
                // wildcard labels:
                retval.tree = root_0;
                RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.getTree() : null);

                root_0 = (CommonTree) adaptor.nil();
                // 1125:5: -> ^( I_STATEMENT_SPARSE_SWITCH[$start, \"I_STATEMENT_SPARSE_SWITCH\"] ^( I_SPARSE_SWITCH_ELEMENTS[$start, \"I_SPARSE_SWITCH_ELEMENTS\"] ( fixed_32bit_literal label_ref )* ) )
                {
                    // smaliParser.g:1125:8: ^( I_STATEMENT_SPARSE_SWITCH[$start, \"I_STATEMENT_SPARSE_SWITCH\"] ^( I_SPARSE_SWITCH_ELEMENTS[$start, \"I_SPARSE_SWITCH_ELEMENTS\"] ( fixed_32bit_literal label_ref )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_STATEMENT_SPARSE_SWITCH, (retval.start), "I_STATEMENT_SPARSE_SWITCH"), root_1);
                        // smaliParser.g:1126:8: ^( I_SPARSE_SWITCH_ELEMENTS[$start, \"I_SPARSE_SWITCH_ELEMENTS\"] ( fixed_32bit_literal label_ref )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(I_SPARSE_SWITCH_ELEMENTS, (retval.start), "I_SPARSE_SWITCH_ELEMENTS"), root_2);
                            // smaliParser.g:1126:71: ( fixed_32bit_literal label_ref )*
                            while (stream_fixed_32bit_literal.hasNext() || stream_label_ref.hasNext()) {
                                adaptor.addChild(root_2, stream_fixed_32bit_literal.nextTree());
                                adaptor.addChild(root_2, stream_label_ref.nextTree());
                            }
                            stream_fixed_32bit_literal.reset();
                            stream_label_ref.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }


                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "insn_sparse_switch_directive"

    // Delegated rules


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA40 dfa40 = new DFA40(this);
    static final String DFA30_eotS =
            "\55\uffff";
    static final String DFA30_eofS =
            "\55\uffff";
    static final String DFA30_minS =
            "\1\4\52\23\2\uffff";
    static final String DFA30_maxS =
            "\1\u00c6\12\u00b4\1\u00b7\37\u00b4\2\uffff";
    static final String DFA30_acceptS =
            "\53\uffff\1\1\1\2";
    static final String DFA30_specialS =
            "\55\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\1\uffff\1\16\3\uffff\1\10\14\uffff\1\7\17\uffff\1\6\2\uffff\1\17" +
                    "\1\20\1\21\1\uffff\1\22\1\uffff\1\23\2\uffff\1\24\1\25\1\26\1\27\3\uffff" +
                    "\1\30\1\uffff\1\31\1\32\1\33\1\34\1\uffff\1\35\1\36\1\uffff\1\37\3\uffff" +
                    "\1\40\1\41\1\uffff\1\42\1\43\1\44\1\45\1\46\5\uffff\1\47\1\50\1\51\127" +
                    "\uffff\1\52\1\uffff\1\5\1\11\4\uffff\1\13\1\4\1\14\1\uffff\1\12\3\uffff" +
                    "\1\1\5\uffff\1\3\1\15",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54\2\uffff\1\13",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "\1\53\u00a0\uffff\1\54",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    protected class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }

        @Override
        public String getDescription() {
            return "695:7: ( member_name COLON nonvoid_type_descriptor -> ^( I_ENCODED_FIELD ( reference_type_descriptor )? member_name nonvoid_type_descriptor ) | member_name method_prototype -> ^( I_ENCODED_METHOD ( reference_type_descriptor )? member_name method_prototype ) )";
        }
    }

    static final String DFA38_eotS =
            "\62\uffff";
    static final String DFA38_eofS =
            "\62\uffff";
    static final String DFA38_minS =
            "\1\4\1\5\1\17\52\23\1\uffff\1\4\1\11\2\uffff";
    static final String DFA38_maxS =
            "\1\u00c6\1\u00c1\1\u00b9\12\u00b4\1\u00b7\37\u00b4\1\uffff\1\u00c6\1\11" +
                    "\2\uffff";
    static final String DFA38_acceptS =
            "\55\uffff\1\1\2\uffff\1\2\1\3";
    static final String DFA38_specialS =
            "\62\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\4\1\uffff\1\20\1\uffff\1\2\1\uffff\1\12\4\uffff\1\1\7\uffff\1\11\17" +
                    "\uffff\1\10\2\uffff\1\21\1\22\1\23\1\uffff\1\24\1\uffff\1\25\2\uffff" +
                    "\1\26\1\27\1\30\1\31\3\uffff\1\32\1\uffff\1\33\1\34\1\35\1\36\1\uffff" +
                    "\1\37\1\40\1\uffff\1\41\3\uffff\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47" +
                    "\1\50\5\uffff\1\51\1\52\1\53\127\uffff\1\54\1\uffff\1\7\1\13\4\uffff" +
                    "\1\15\1\6\1\16\1\uffff\1\14\3\uffff\1\3\5\uffff\1\5\1\17",
            "\1\55\1\uffff\1\55\1\uffff\1\56\2\uffff\2\55\5\uffff\1\55\7\uffff\2" +
                    "\55\5\uffff\1\55\7\uffff\56\55\123\uffff\3\55\7\uffff\2\55\3\uffff\1" +
                    "\55\1\uffff\2\55\2\uffff\2\55",
            "\1\57\u00a9\uffff\1\57",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61\2\uffff\1\15",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "\1\60\u00a0\uffff\1\61",
            "",
            "\1\4\1\uffff\1\20\3\uffff\1\12\14\uffff\1\11\17\uffff\1\10\2\uffff\1" +
                    "\21\1\22\1\23\1\uffff\1\24\1\uffff\1\25\2\uffff\1\26\1\27\1\30\1\31\3" +
                    "\uffff\1\32\1\uffff\1\33\1\34\1\35\1\36\1\uffff\1\37\1\40\1\uffff\1\41" +
                    "\3\uffff\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47\1\50\5\uffff\1\51\1\52" +
                    "\1\53\127\uffff\1\54\1\uffff\1\7\1\13\4\uffff\1\15\1\6\1\16\1\uffff\1" +
                    "\14\3\uffff\1\3\5\uffff\1\5\1\17",
            "\1\56",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    protected class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }

        @Override
        public String getDescription() {
            return "723:1: verification_error_reference : ( CLASS_DESCRIPTOR | field_reference | method_reference );";
        }
    }

    static final String DFA40_eotS =
            "\103\uffff";
    static final String DFA40_eofS =
            "\103\uffff";
    static final String DFA40_minS =
            "\1\5\100\uffff\1\0\1\uffff";
    static final String DFA40_maxS =
            "\1\u00c1\100\uffff\1\0\1\uffff";
    static final String DFA40_acceptS =
            "\1\uffff\1\2\100\uffff\1\1";
    static final String DFA40_specialS =
            "\101\uffff\1\0\1\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\101\1\uffff\1\1\4\uffff\2\1\5\uffff\1\1\7\uffff\2\1\1\uffff\1\1\3" +
                    "\uffff\1\1\7\uffff\56\1\123\uffff\3\1\7\uffff\2\1\3\uffff\1\1\1\uffff" +
                    "\2\1\2\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    protected class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }

        @Override
        public String getDescription() {
            return "()* loopback of 741:5: ({...}? annotation )*";
        }

        @Override
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream) _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA40_65 = input.LA(1);

                    int index40_65 = input.index();
                    input.rewind();
                    s = -1;
                    if (((input.LA(1) == ANNOTATION_DIRECTIVE))) {
                        s = 66;
                    } else if ((true)) {
                        s = 1;
                    }

                    input.seek(index40_65);
                    if (s >= 0) return s;
                    break;
            }
            NoViableAltException nvae =
                    new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    public static final BitSet FOLLOW_class_spec_in_smali_file1075 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_super_spec_in_smali_file1086 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_implements_spec_in_smali_file1094 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_source_spec_in_smali_file1103 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_method_in_smali_file1111 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_field_in_smali_file1117 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_annotation_in_smali_file1123 = new BitSet(new long[]{0x0000011000010020L, 0x0000000000000000L, 0x0001000000000000L, 0x0000000000000011L});
    public static final BitSet FOLLOW_EOF_in_smali_file1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_DIRECTIVE_in_class_spec1221 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_access_list_in_class_spec1223 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_class_spec1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_DIRECTIVE_in_super_spec1243 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_super_spec1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_DIRECTIVE_in_implements_spec1264 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_implements_spec1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOURCE_DIRECTIVE_in_source_spec1285 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_source_spec1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACCESS_SPEC_in_access_list1306 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_FIELD_DIRECTIVE_in_field1337 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_access_list_in_field1339 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_member_name_in_field1341 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_field1343 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_field1345 = new BitSet(new long[]{0x0000000804000022L});
    public static final BitSet FOLLOW_EQUAL_in_field1348 = new BitSet(new long[]{0xF4795CC200C0CD50L, 0x0000000000E0FB16L, 0xCB8EC00000000000L, 0x000000000000006CL});
    public static final BitSet FOLLOW_literal_in_field1350 = new BitSet(new long[]{0x0000000004000022L});
    public static final BitSet FOLLOW_annotation_in_field1363 = new BitSet(new long[]{0x0000000004000022L});
    public static final BitSet FOLLOW_END_FIELD_DIRECTIVE_in_field1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_DIRECTIVE_in_method1488 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_access_list_in_method1490 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_member_name_in_method1492 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_method_prototype_in_method1494 = new BitSet(new long[]{0xFFFFFC04180830A0L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_statements_and_directives_in_method1496 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_END_METHOD_DIRECTIVE_in_method1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ordered_method_item_in_statements_and_directives1547 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_registers_directive_in_statements_and_directives1555 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_catch_directive_in_statements_and_directives1563 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_catchall_directive_in_statements_and_directives1571 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_parameter_directive_in_statements_and_directives1579 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_annotation_in_statements_and_directives1587 = new BitSet(new long[]{0xFFFFFC04080830A2L, 0x0000000000FFFFFFL, 0x3460380000000000L, 0x0000000000000003L});
    public static final BitSet FOLLOW_label_in_ordered_method_item1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_in_ordered_method_item1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_debug_directive_in_ordered_method_item1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTERS_DIRECTIVE_in_registers_directive1704 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_registers_directive1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCALS_DIRECTIVE_in_registers_directive1728 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_registers_directive1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAM_LIST_OR_ID_PRIMITIVE_TYPE_in_param_list_or_id1764 = new BitSet(new long[]{0x0000000000000002L, 0x0000000000000000L, 0x0080000000000000L});
    public static final BitSet FOLLOW_SIMPLE_NAME_in_simple_name1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACCESS_SPEC_in_simple_name1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERIFICATION_ERROR_TYPE_in_simple_name1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INTEGER_LITERAL_in_simple_name1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATIVE_INTEGER_LITERAL_in_simple_name1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_LITERAL_OR_ID_in_simple_name1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_LITERAL_OR_ID_in_simple_name1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_simple_name1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_LITERAL_in_simple_name1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_simple_name1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_list_or_id_in_simple_name1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_simple_name1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_TYPE_in_simple_name1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANNOTATION_VISIBILITY_in_simple_name1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10t_in_simple_name1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10x_in_simple_name1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10x_ODEX_in_simple_name1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT11x_in_simple_name1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT12x_OR_ID_in_simple_name1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_FIELD_in_simple_name1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_FIELD_ODEX_in_simple_name1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_simple_name2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_simple_name2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21t_in_simple_name2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_FIELD_in_simple_name2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_FIELD_ODEX_in_simple_name2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_simple_name2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22cs_FIELD_in_simple_name2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22s_OR_ID_in_simple_name2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22t_in_simple_name2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT23x_in_simple_name2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31i_OR_ID_in_simple_name2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31t_in_simple_name2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_simple_name2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_METHOD_ODEX_in_simple_name2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_simple_name2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35mi_METHOD_in_simple_name2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35ms_METHOD_in_simple_name2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT45cc_METHOD_in_simple_name2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT4rcc_METHOD_in_simple_name2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT51l_in_simple_name2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_name_in_member_name2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MEMBER_NAME_in_member_name2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_method_prototype2247 = new BitSet(new long[]{0x0000000000048100L, 0x0000000000000000L, 0x0280000000000000L});
    public static final BitSet FOLLOW_param_list_in_method_prototype2249 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_method_prototype2251 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L, 0x0000000000000040L});
    public static final BitSet FOLLOW_type_descriptor_in_method_prototype2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAM_LIST_OR_ID_PRIMITIVE_TYPE_in_param_list_or_id_primitive_type2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_list_or_id_primitive_type_in_param_list2298 = new BitSet(new long[]{0x0000000000000002L, 0x0000000000000000L, 0x0080000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_param_list2305 = new BitSet(new long[]{0x0000000000008102L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_ARRAY_TYPE_PREFIX_in_array_descriptor2316 = new BitSet(new long[]{0x0000000000008000L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_set_in_array_descriptor2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_TYPE_in_type_descriptor2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_type_descriptor2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_type_descriptor2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_descriptor_in_type_descriptor2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_nonvoid_type_descriptor2362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_nonvoid_type_descriptor2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_descriptor_in_nonvoid_type_descriptor2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_reference_type_descriptor2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_descriptor_in_reference_type_descriptor2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_INTEGER_LITERAL_in_integer_literal2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATIVE_INTEGER_LITERAL_in_integer_literal2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_LITERAL_OR_ID_in_float_literal2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_LITERAL_in_float_literal2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_LITERAL_OR_ID_in_double_literal2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_LITERAL_in_double_literal2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_LITERAL_in_literal2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_literal2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_LITERAL_in_literal2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_LITERAL_in_literal2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_literal_in_literal2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_double_literal_in_literal2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_literal2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_literal2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_LITERAL_in_literal2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_literal_in_literal2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subannotation_in_literal2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_field_method_literal_in_literal2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_literal_in_literal2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_parsed_integer_literal2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_LITERAL_in_integral_literal2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_integral_literal2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_LITERAL_in_integral_literal2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_integral_literal2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_LITERAL_in_integral_literal2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_LITERAL_in_fixed_32bit_literal2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_fixed_32bit_literal2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_LITERAL_in_fixed_32bit_literal2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_LITERAL_in_fixed_32bit_literal2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_literal_in_fixed_32bit_literal2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_fixed_32bit_literal2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_fixed_32bit_literal2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_fixed_literal2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_LITERAL_in_fixed_literal2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_LITERAL_in_fixed_literal2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_LITERAL_in_fixed_literal2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_literal_in_fixed_literal2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_double_literal_in_fixed_literal2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_fixed_literal2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_fixed_literal2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_array_literal2703 = new BitSet(new long[]{0xF4795CC200C2CD50L, 0x0000000000E0FB16L, 0xCB8EC00000000000L, 0x000000000000006CL});
    public static final BitSet FOLLOW_literal_in_array_literal2706 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_COMMA_in_array_literal2709 = new BitSet(new long[]{0xF4795CC200C0CD50L, 0x0000000000E0FB16L, 0xCB8EC00000000000L, 0x000000000000006CL});
    public static final BitSet FOLLOW_literal_in_array_literal2711 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_array_literal2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_name_in_annotation_element2743 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_EQUAL_in_annotation_element2745 = new BitSet(new long[]{0xF4795CC200C0CD50L, 0x0000000000E0FB16L, 0xCB8EC00000000000L, 0x000000000000006CL});
    public static final BitSet FOLLOW_literal_in_annotation_element2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANNOTATION_DIRECTIVE_in_annotation2772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ANNOTATION_VISIBILITY_in_annotation2774 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_annotation2776 = new BitSet(new long[]{0xF4795C8001800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_annotation_element_in_annotation2782 = new BitSet(new long[]{0xF4795C8001800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_END_ANNOTATION_DIRECTIVE_in_annotation2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBANNOTATION_DIRECTIVE_in_subannotation2818 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_subannotation2820 = new BitSet(new long[]{0xF4795C8100800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_annotation_element_in_subannotation2822 = new BitSet(new long[]{0xF4795C8100800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_END_SUBANNOTATION_DIRECTIVE_in_subannotation2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_DIRECTIVE_in_enum_literal2852 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_field_reference_in_enum_literal2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_type_descriptor_in_type_field_method_literal2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_type_descriptor_in_type_field_method_literal2883 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARROW_in_type_field_method_literal2885 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_member_name_in_type_field_method_literal2897 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_type_field_method_literal2899 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_type_field_method_literal2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_member_name_in_type_field_method_literal2924 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_method_prototype_in_type_field_method_literal2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_type_field_method_literal2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_TYPE_in_type_field_method_literal2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_type_descriptor_in_method_reference2976 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARROW_in_method_reference2978 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_member_name_in_method_reference2982 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_method_prototype_in_method_reference2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_type_descriptor_in_field_reference3006 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARROW_in_field_reference3008 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_member_name_in_field_reference3012 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_field_reference3014 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_field_reference3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_label3037 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_simple_name_in_label3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_label_ref3058 = new BitSet(new long[]{0xF4795C8000800450L, 0x0000000000E0FB16L, 0x8B86000000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_simple_name_in_label_ref3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_list3074 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_register_list3077 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_register_list3079 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_REGISTER_in_register_range3114 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_DOTDOT_in_register_range3117 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_register_range3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_verification_error_reference3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_reference_in_verification_error_reference3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_reference_in_verification_error_reference3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_DIRECTIVE_in_catch_directive3168 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_catch_directive3170 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_catch_directive3172 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catch_directive3176 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOTDOT_in_catch_directive3178 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catch_directive3182 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_catch_directive3184 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catch_directive3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCHALL_DIRECTIVE_in_catchall_directive3220 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_catchall_directive3222 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catchall_directive3226 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOTDOT_in_catchall_directive3228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catchall_directive3232 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_catchall_directive3234 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_catchall_directive3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAMETER_DIRECTIVE_in_parameter_directive3277 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_parameter_directive3279 = new BitSet(new long[]{0x0000000040100022L});
    public static final BitSet FOLLOW_COMMA_in_parameter_directive3282 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parameter_directive3284 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_annotation_in_parameter_directive3295 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_END_PARAMETER_DIRECTIVE_in_parameter_directive3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_line_directive_in_debug_directive3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_local_directive_in_debug_directive3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_end_local_directive_in_debug_directive3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_restart_local_directive_in_debug_directive3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prologue_directive_in_debug_directive3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_epilogue_directive_in_debug_directive3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_directive_in_debug_directive3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_DIRECTIVE_in_line_directive3427 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_line_directive3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCAL_DIRECTIVE_in_local_directive3452 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_local_directive3454 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_local_directive3457 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0004000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_NULL_LITERAL_in_local_directive3460 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_local_directive3466 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_local_directive3469 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L, 0x0000000000000040L});
    public static final BitSet FOLLOW_VOID_TYPE_in_local_directive3472 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_local_directive3476 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_local_directive3510 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_local_directive3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_LOCAL_DIRECTIVE_in_end_local_directive3556 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_end_local_directive3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RESTART_LOCAL_DIRECTIVE_in_restart_local_directive3581 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_restart_local_directive3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROLOGUE_DIRECTIVE_in_prologue_directive3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPILOGUE_DIRECTIVE_in_epilogue_directive3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOURCE_DIRECTIVE_in_source_directive3648 = new BitSet(new long[]{0x0000000000000002L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_source_directive3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT12x_in_instruction_format12x3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT12x_OR_ID_in_instruction_format12x3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22s_in_instruction_format22s3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22s_OR_ID_in_instruction_format22s3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31i_in_instruction_format31i3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31i_OR_ID_in_instruction_format31i3723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format10t_in_instruction3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format10x_in_instruction3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format10x_odex_in_instruction3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format11n_in_instruction3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format11x_in_instruction3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format12x_in_instruction3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format20bc_in_instruction3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format20t_in_instruction3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21c_field_in_instruction3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21c_field_odex_in_instruction3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21c_string_in_instruction3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21c_type_in_instruction3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21ih_in_instruction3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21lh_in_instruction3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21s_in_instruction3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format21t_in_instruction3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22b_in_instruction3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22c_field_in_instruction3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22c_field_odex_in_instruction3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22c_type_in_instruction3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22cs_field_in_instruction3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22s_in_instruction3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22t_in_instruction3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format22x_in_instruction3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format23x_in_instruction3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format30t_in_instruction3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format31c_in_instruction3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format31i_in_instruction3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format31t_in_instruction3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format32x_in_instruction3914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format35c_method_in_instruction3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format35c_type_in_instruction3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format35c_method_odex_in_instruction3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format35mi_method_in_instruction3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format35ms_method_in_instruction3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format3rc_method_in_instruction3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format3rc_method_odex_in_instruction3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format3rc_type_in_instruction3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format3rmi_method_in_instruction3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format3rms_method_in_instruction3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format45cc_method_in_instruction3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format4rcc_method_in_instruction3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_format51l_in_instruction3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_array_data_directive_in_instruction3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_packed_switch_directive_in_instruction4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insn_sparse_switch_directive_in_instruction4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10t_in_insn_format10t4030 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format10t4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10x_in_insn_format10x4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10x_ODEX_in_insn_format10x_odex4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT11n_in_insn_format11n4111 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format11n4113 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format11n4115 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_insn_format11n4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT11x_in_insn_format11x4149 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format11x4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_format12x_in_insn_format12x4181 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format12x4183 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format12x4185 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format12x4187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT20bc_in_insn_format20bc4219 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000020L});
    public static final BitSet FOLLOW_VERIFICATION_ERROR_TYPE_in_insn_format20bc4221 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format20bc4223 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_verification_error_reference_in_insn_format20bc4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT20t_in_insn_format20t4262 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format20t4264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_FIELD_in_insn_format21c_field4294 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_field4296 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21c_field4298 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_field_reference_in_insn_format21c_field4300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_FIELD_ODEX_in_insn_format21c_field_odex4332 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_field_odex4334 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21c_field_odex4336 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_field_reference_in_insn_format21c_field_odex4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_insn_format21c_string4376 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_string4378 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21c_string4380 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_insn_format21c_string4382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_insn_format21c_type4414 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_type4416 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21c_type4418 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format21c_type4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21ih_in_insn_format21ih4452 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21ih4454 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21ih4456 = new BitSet(new long[]{0x000000C000004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_format21ih4458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21lh_in_insn_format21lh4490 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21lh4492 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21lh4494 = new BitSet(new long[]{0x000000C000004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_format21lh4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21s_in_insn_format21s4528 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21s4530 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21s4532 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_insn_format21s4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21t_in_insn_format21t4566 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format21t4568 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format21t4570 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format21t4572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22b_in_insn_format22b4604 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22b4606 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22b4608 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22b4610 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22b4612 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_insn_format22b4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_FIELD_in_insn_format22c_field4648 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field4650 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_field4652 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field4654 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_field4656 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_field_reference_in_insn_format22c_field4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_FIELD_ODEX_in_insn_format22c_field_odex4692 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field_odex4694 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_field_odex4696 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field_odex4698 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_field_odex4700 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_field_reference_in_insn_format22c_field_odex4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_insn_format22c_type4742 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_type4744 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_type4746 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_type4748 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22c_type4750 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format22c_type4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22cs_FIELD_in_insn_format22cs_field4786 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22cs_field4788 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22cs_field4790 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22cs_field4792 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22cs_field4794 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_FIELD_OFFSET_in_insn_format22cs_field4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_format22s_in_insn_format22s4817 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22s4819 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22s4821 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22s4823 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22s4825 = new BitSet(new long[]{0x0000000000004800L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_integral_literal_in_insn_format22s4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22t_in_insn_format22t4861 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22t4863 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22t4865 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22t4867 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22t4869 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format22t4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22x_in_insn_format22x4905 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22x4907 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format22x4909 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format22x4911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT23x_in_insn_format23x4943 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x4945 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format23x4947 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x4949 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format23x4951 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT30t_in_insn_format30t4987 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format30t4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31c_in_insn_format31c5019 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format31c5021 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format31c5023 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_insn_format31c5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_format31i_in_insn_format31i5056 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format31i5058 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format31i5060 = new BitSet(new long[]{0x000000C000004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_format31i5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31t_in_insn_format31t5094 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format31t5096 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format31t5098 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_format31t5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT32x_in_insn_format32x5132 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format32x5134 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format32x5136 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format32x5138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_insn_format35c_method5170 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format35c_method5172 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format35c_method5174 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format35c_method5176 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format35c_method5178 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format35c_method5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_insn_format35c_type5212 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format35c_type5214 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format35c_type5216 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format35c_type5218 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format35c_type5220 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format35c_type5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_METHOD_ODEX_in_insn_format35c_method_odex5254 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format35c_method_odex5256 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format35c_method_odex5258 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format35c_method_odex5260 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format35c_method_odex5262 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format35c_method_odex5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35mi_METHOD_in_insn_format35mi_method5285 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format35mi_method5287 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format35mi_method5289 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format35mi_method5291 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format35mi_method5293 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_INLINE_INDEX_in_insn_format35mi_method5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35ms_METHOD_in_insn_format35ms_method5316 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format35ms_method5318 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format35ms_method5320 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format35ms_method5322 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format35ms_method5324 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000080L});
    public static final BitSet FOLLOW_VTABLE_INDEX_in_insn_format35ms_method5326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_in_insn_format3rc_method5347 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format3rc_method5349 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_range_in_insn_format3rc_method5351 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format3rc_method5353 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format3rc_method5355 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format3rc_method5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_ODEX_in_insn_format3rc_method_odex5389 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format3rc_method_odex5391 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format3rc_method_odex5393 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format3rc_method_odex5395 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format3rc_method_odex5397 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format3rc_method_odex5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rc_TYPE_in_insn_format3rc_type5420 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format3rc_type5422 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_range_in_insn_format3rc_type5424 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format3rc_type5426 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format3rc_type5428 = new BitSet(new long[]{0x0000000000008100L, 0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format3rc_type5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rmi_METHOD_in_insn_format3rmi_method5462 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format3rmi_method5464 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_range_in_insn_format3rmi_method5466 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format3rmi_method5468 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format3rmi_method5470 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_INLINE_INDEX_in_insn_format3rmi_method5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rms_METHOD_in_insn_format3rms_method5493 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format3rms_method5495 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_range_in_insn_format3rms_method5497 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format3rms_method5499 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format3rms_method5501 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0000000000000000L, 0x0000000000000080L});
    public static final BitSet FOLLOW_VTABLE_INDEX_in_insn_format3rms_method5503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT45cc_METHOD_in_insn_format45cc_method5524 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format45cc_method5526 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_list_in_insn_format45cc_method5528 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format45cc_method5530 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format45cc_method5532 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format45cc_method5534 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format45cc_method5536 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_method_prototype_in_insn_format45cc_method5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT4rcc_METHOD_in_insn_format4rcc_method5572 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0008000000000000L});
    public static final BitSet FOLLOW_OPEN_BRACE_in_insn_format4rcc_method5574 = new BitSet(new long[]{0x0000000000020000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_register_range_in_insn_format4rcc_method5576 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_BRACE_in_insn_format4rcc_method5578 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format4rcc_method5580 = new BitSet(new long[]{0xF4795C8000808550L, 0x0000000000E0FB16L, 0x8B86800000000000L, 0x0000000000000060L});
    public static final BitSet FOLLOW_method_reference_in_insn_format4rcc_method5582 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format4rcc_method5584 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_method_prototype_in_insn_format4rcc_method5586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT51l_in_insn_format51l5620 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0800000000000000L});
    public static final BitSet FOLLOW_REGISTER_in_insn_format51l5622 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_insn_format51l5624 = new BitSet(new long[]{0x000000C000C04C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_literal_in_insn_format51l5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_DATA_DIRECTIVE_in_insn_array_data_directive5653 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000000L, 0x0102000000000000L});
    public static final BitSet FOLLOW_parsed_integer_literal_in_insn_array_data_directive5659 = new BitSet(new long[]{0x000000C002C04C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_literal_in_insn_array_data_directive5671 = new BitSet(new long[]{0x000000C002C04C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_END_ARRAY_DATA_DIRECTIVE_in_insn_array_data_directive5674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKED_SWITCH_DIRECTIVE_in_insn_packed_switch_directive5720 = new BitSet(new long[]{0x000000C000004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_packed_switch_directive5726 = new BitSet(new long[]{0x0000000020080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_packed_switch_directive5732 = new BitSet(new long[]{0x0000000020080000L});
    public static final BitSet FOLLOW_END_PACKED_SWITCH_DIRECTIVE_in_insn_packed_switch_directive5739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPARSE_SWITCH_DIRECTIVE_in_insn_sparse_switch_directive5813 = new BitSet(new long[]{0x000000C080004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_sparse_switch_directive5820 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARROW_in_insn_sparse_switch_directive5822 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_label_ref_in_insn_sparse_switch_directive5824 = new BitSet(new long[]{0x000000C080004C00L, 0x0000000000000000L, 0x4102400000000000L});
    public static final BitSet FOLLOW_END_SPARSE_SWITCH_DIRECTIVE_in_insn_sparse_switch_directive5832 = new BitSet(new long[]{0x0000000000000002L});
}
