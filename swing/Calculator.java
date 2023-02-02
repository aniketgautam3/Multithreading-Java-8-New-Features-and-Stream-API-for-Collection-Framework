package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Stack;

import javax.swing.*;

public final class Calculator implements ActionListener {
	JFrame f;
	JTextField t;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,
			badd, bsub, bdiv, bmul, bdec, beq, bdel, bclr;

	static double a = 0, b = 0, result = 0;
	static int op = 0;

	public Calculator() {
		f = new JFrame("Calculator");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(20, 20, 300, 350);
		f.setResizable(false);

		Font fo = new Font("Arial", Font.BOLD, 20);

		t = new JTextField();

		t.setFont(fo);
		t.setBackground(Color.BLUE);
		t.setForeground(Color.BLACK);
		t.setBounds(40, 40, 200, 50);

		f.add(t);

		b0 = new JButton("0");
		b0.addActionListener(this);
		b0.setBounds(40, 220, 50, 40);
		f.add(b0);

		b1 = new JButton("1");
		b1.addActionListener(this);
		b1.setBounds(40, 180, 50, 40);
		f.add(b1);

		b2 = new JButton("2");
		b2.addActionListener(this);
		b2.setBounds(90, 180, 50, 40);
		f.add(b2);

		b3 = new JButton("3");
		b3.addActionListener(this);
		b3.setBounds(140, 180, 50, 40);
		f.add(b3);

		b4 = new JButton("4");
		b4.addActionListener(this);
		b4.setBounds(40, 140, 50, 40);
		f.add(b4);

		b5 = new JButton("5");
		b5.addActionListener(this);
		b5.setBounds(90, 140, 50, 40);
		f.add(b5);

		b6 = new JButton("6");
		b6.addActionListener(this);
		b6.setBounds(140, 140, 50, 40);
		f.add(b6);

		b7 = new JButton("7");
		b7.addActionListener(this);
		b7.setBounds(40, 100, 50, 40);
		f.add(b7);

		b8 = new JButton("8");
		b8.addActionListener(this);
		b8.setBounds(90, 100, 50, 40);
		f.add(b8);

		b9 = new JButton("9");
		b9.addActionListener(this);
		b9.setBounds(140, 100, 50, 40);
		f.add(b9);

		badd = new JButton("+");
		badd.addActionListener(this);
		badd.setBounds(140, 220, 50, 40);
		f.add(badd);

		bsub = new JButton("-");
		bsub.addActionListener(this);
		bsub.setBounds(190, 180, 50, 40);
		f.add(bsub);

		bmul = new JButton("*");
		bmul.addActionListener(this);
		bmul.setBounds(190, 140, 50, 40);
		f.add(bmul);

		bdiv = new JButton("/");
		bdiv.addActionListener(this);
		bdiv.setBounds(190, 100, 50, 40);
		f.add(bdiv);

		beq = new JButton("=");
		beq.addActionListener(this);
		beq.setBounds(190, 220, 50, 40);
		f.add(beq);

		bdec = new JButton(".");
		bdec.addActionListener(this);
		bdec.setBounds(90, 220, 50, 40);
		f.add(bdec);

		bclr = new JButton("CLR");
		bclr.addActionListener(this);
		bclr.setBounds(140, 260, 100, 40);
		f.add(bclr);

		bdel = new JButton("DEL");
		bdel.addActionListener(this);
		bdel.setBounds(40, 260, 100, 40);
		f.add(bdel);

	}

	public static boolean hasPrecedence(char op1, char op2) {
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return false;
		} else {
			return true;
		}
	}

	public static double applyOp(char op, double b, double a) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0) {
					throw new UnsupportedOperationException("Cannot divide by zero");
				}
				return a / b;
		}

		return 0;
	}

	public static double evaluateInfixExpression(String expression) {
		char[] tokens = expression.toCharArray();

		Stack<Double> values = new Stack<Double>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length &&
						((tokens[i] >= '0' &&
								tokens[i] <= '9')
								||
								tokens[i] == '.')) {
					sbuf.append(tokens[i++]);
				}
				values.push(Double.parseDouble(sbuf.toString()));

				i--;
			}

			else if (tokens[i] == '*' ||
					tokens[i] == '/' ||
					tokens[i] == '+' ||
					tokens[i] == '-') {
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty()) {
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		}

		return values.pop();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bdec) {

			String str = t.getText();
			for (int i = str.length() - 1; i >= 0; i--) {
				if (str.charAt(i) == '.') {
					return;
				}

				if (str.charAt(i) == '*' ||
						str.charAt(i) == '/' ||
						str.charAt(i) == '+' ||
						str.charAt(i) == '-') {
					break;
				}
			}

			if (str.length() == 0 ||
					str.charAt(str.length() - 1) == '*' ||
					str.charAt(str.length() - 1) == '/' ||
					str.charAt(str.length() - 1) == '+' ||
					str.charAt(str.length() - 1) == '-') {
				str = str.concat("0");
			}

			t.setText(str.concat("."));

			return;
		}

		if (e.getSource() == b0) {
			t.setText(t.getText().concat("0"));

			return;
		}

		if (e.getSource() == b1) {
			t.setText(t.getText().concat("1"));

			return;
		}

		if (e.getSource() == b2) {
			t.setText(t.getText().concat("2"));

			return;
		}

		if (e.getSource() == b3) {
			t.setText(t.getText().concat("3"));

			return;
		}

		if (e.getSource() == b4) {
			t.setText(t.getText().concat("4"));

			return;
		}

		if (e.getSource() == b5) {
			t.setText(t.getText().concat("5"));

			return;
		}

		if (e.getSource() == b6) {
			t.setText(t.getText().concat("6"));

			return;
		}

		if (e.getSource() == b7) {
			t.setText(t.getText().concat("7"));

			return;
		}

		if (e.getSource() == b8) {
			t.setText(t.getText().concat("8"));

			return;
		}

		if (e.getSource() == b9) {
			t.setText(t.getText().concat("9"));

			return;
		}

		if (t.getText().endsWith(".")) {
			int len = t.getText().length();
			t.setText(t.getText().substring(0, len - 1));
		}

		if (e.getSource() == badd) {
			t.setText(t.getText().concat("+"));

			return;
		}

		if (e.getSource() == bclr) {
			t.setText("");

			return;
		}

		if (e.getSource() == bdel) {
			if (t.getText() == null || t.getText().length() == 0) {
				return;
			}

			int len = t.getText().length();
			t.setText(t.getText().substring(0, len - 1));

			return;
		}

		if (e.getSource() == bdiv) {
			t.setText(t.getText().concat("/"));

			return;
		}

		if (e.getSource() == beq) {
			double equivalent = evaluateInfixExpression(t.getText());
			String str = "";

			if (equivalent % 1 == 0) {
				str = String.valueOf((int) equivalent);
			} else {
				str = String.valueOf(equivalent);
			}
			t.setText(str);

			return;
		}

		if (e.getSource() == bmul) {
			t.setText(t.getText().concat("*"));

			return;
		}

		if (e.getSource() == bsub) {
			t.setText(t.getText().concat("-"));

			return;
		}
	}

	public static void main(String[] args) {
		new Calculator();

	}
}
