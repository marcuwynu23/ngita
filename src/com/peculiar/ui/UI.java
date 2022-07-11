package com.peculiar.ui;

import com.peculiar.ui.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.peculiar.cli.CLI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class UI extends javax.swing.JFrame {
	private JTextArea txtArea;
	private MyPanel btnPanel;

	private MyPanel searchEnginePanel;
	private MyButton googleBtn;
	private MyButton bingBtn;
	private MyButton askBtn;
	private MyButton duckBtn;
	private MyButton searchEngineAllBtn;

	private MyPanel socialPanel;
	private MyButton facebookBtn;
	private MyButton twitterBtn;
	private MyButton youtubeBtn;
	private MyButton instagramBtn;
	private MyButton reggitBtn;
	private MyButton socialAllBtn;

	private String[] searchEngines = {
			"\"https://www.google.com/search?q=%s\"",
			"\"https://www.bing.com/search?q=%s\"",
			"\"https://www.ask.com/web?q=%s\"",
			"\"https://duckduckgo.com/?q=%s\""
	};

	private String[] socialMedias = {
			"\"https://web.facebook.com/search/top/?q=%s\"",
			"\"https://twitter.com/search?q=%s\"",
			"\"https://www.youtube.com/results?search_query=%s\"",
			"\"https://duckduckgo.com/?q=%s\"",
			"\"https://www.reddit.com/r/reggit/search/?q=%s\""
	};

	String ICON_PATH = "/com/peculiar/ngita/icon.png";

	public UI() {
		super("Ngita All Search");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON_PATH)));
		setVisible(true);
		setComponents();
		setEvent();
	}

	void setComponents() {
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setMargin(new Insets(10, 10, 10, 10));
		txtArea.setBackground(new Color(34, 34, 34));
		txtArea.setForeground(new Color(255, 255, 255));
		txtArea.setCaretColor(new Color(255, 255, 255));
		txtArea.setFont(new java.awt.Font("Arial", 0, 18));

		setLayout(new BorderLayout());
		setPanels();
		add(btnPanel, BorderLayout.SOUTH);
		add(new JScrollPane(txtArea), BorderLayout.CENTER);
	}

	void setPanels() {
		btnPanel = new MyPanel();
		btnPanel.setLayout(new GridLayout(2, 1));

		setSocialPanel();
		btnPanel.add(socialPanel);

		setSearchEnginePanel();
		btnPanel.add(searchEnginePanel);
	}

	void setSearchEnginePanel() {
		searchEnginePanel = new MyPanel();

		googleBtn = new MyButton("google");
		bingBtn = new MyButton("bing");
		askBtn = new MyButton("ask.com");
		duckBtn = new MyButton("duckduckgo");
		searchEngineAllBtn = new MyButton("all");

		searchEnginePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		searchEnginePanel.add(askBtn);
		searchEnginePanel.add(bingBtn);
		searchEnginePanel.add(googleBtn);
		searchEnginePanel.add(duckBtn);
		searchEnginePanel.add(searchEngineAllBtn);
	}

	void setSocialPanel() {
		socialPanel = new MyPanel();

		facebookBtn = new MyButton("facebook");
		twitterBtn = new MyButton("twitter");
		youtubeBtn = new MyButton("youtube");
		instagramBtn = new MyButton("instagram");
		reggitBtn = new MyButton("reggit");
		socialAllBtn = new MyButton("all");

		socialPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		socialPanel.add(facebookBtn);
		socialPanel.add(twitterBtn);
		socialPanel.add(youtubeBtn);
		socialPanel.add(instagramBtn);
		socialPanel.add(reggitBtn);
		socialPanel.add(socialAllBtn);
	}

	void setEvent() {
		setSearchEngineEvents();
		setSocialEvents();
	}

	void setSearchEngineEvents() {
		googleBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(searchEngines[0], query);
			CLI.execute("explorer " + searchCmd);
		});
		bingBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(searchEngines[1], query);
			CLI.execute("explorer " + searchCmd);
		});

		askBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(searchEngines[2], query);
			CLI.execute("explorer " + searchCmd);
		});

		duckBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(searchEngines[3], query);
			CLI.execute("explorer " + searchCmd);
		});

		searchEngineAllBtn.addActionListener(e -> {
			String query = txtArea.getText();
			for (var i : searchEngines) {
				String searchCmd = String.format(i, query);
				CLI.execute("explorer " + searchCmd);
			}
		});
	}

	void setSocialEvents() {
		facebookBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(socialMedias[0], query);
			CLI.execute("explorer " + searchCmd);
		});
		twitterBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(socialMedias[1], query);
			CLI.execute("explorer " + searchCmd);
		});
		youtubeBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(socialMedias[2], query);
			CLI.execute("explorer " + searchCmd);
		});
		instagramBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(socialMedias[3], query);
			CLI.execute("explorer " + searchCmd);
		});
		reggitBtn.addActionListener(e -> {
			String query = txtArea.getText();
			String searchCmd = String.format(socialMedias[4], query);
			CLI.execute("explorer " + searchCmd);
		});

		socialAllBtn.addActionListener(e -> {
			String query = txtArea.getText();
			for (var i : socialMedias) {
				String searchCmd = String.format(i, query);
				CLI.execute("explorer " + searchCmd);
			}
		});

	}
}