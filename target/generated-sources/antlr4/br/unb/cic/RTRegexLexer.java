// Generated from br/unb/cic/RTRegex.g4 by ANTLR 4.3
package br.unb.cic;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RTRegexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, FLOAT=5, TASK=6, GOAL=7, X=8, NEWLINE=9, 
		WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "FLOAT", "TASK", "GOAL", "X", "NEWLINE", 
		"WS", "DIGIT"
	};


	public RTRegexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RTRegex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fE\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6%\n\6\r\6\16"+
		"\6&\3\6\5\6*\n\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\6\n9\n\n\r\n\16\n:\3\13\6\13>\n\13\r\13\16\13?\3\13\3\13\3\f\3\f"+
		"\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\3\2\5\4\2\f"+
		"\f\17\17\3\2\13\13\3\2\62;H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13$\3"+
		"\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\238\3\2\2\2\25=\3\2\2"+
		"\2\27C\3\2\2\2\31\32\7B\2\2\32\4\3\2\2\2\33\34\7F\2\2\34\35\7O\2\2\35"+
		"\36\7*\2\2\36\6\3\2\2\2\37 \7+\2\2 \b\3\2\2\2!\"\7.\2\2\"\n\3\2\2\2#%"+
		"\5\27\f\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(*\7\60\2"+
		"\2)(\3\2\2\2)*\3\2\2\2*.\3\2\2\2+-\5\27\f\2,+\3\2\2\2-\60\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\f\3\2\2\2\60.\3\2\2\2\61\62\7V\2\2\62\16\3\2\2\2\63"+
		"\64\7I\2\2\64\20\3\2\2\2\65\66\7Z\2\2\66\22\3\2\2\2\679\t\2\2\28\67\3"+
		"\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\24\3\2\2\2<>\t\3\2\2=<\3\2\2\2>"+
		"?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\b\13\2\2B\26\3\2\2\2CD\t\4\2"+
		"\2D\30\3\2\2\2\b\2&).:?\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}