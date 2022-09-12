package com.peculiar.ui;

import com.peculiar.cli.CLI;
import com.peculiar.ui.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI extends javax.swing.JFrame {
  private JTextArea txtArea;
  private MyPanel btnPanel;

  private MyPanel searchEnginePanel;
  private MyButton googleBtn;
  private MyButton bingBtn;
  private MyButton askBtn;
  private MyButton duckBtn;
  private MyButton dogpileBtn;
  private MyButton metacrawlerBtn;
  private MyButton searchEngineAllBtn;

  private MyPanel socialPanel;
  private MyButton facebookBtn;
  private MyButton twitterBtn;
  private MyButton youtubeBtn;
  private MyButton instagramBtn;
  private MyButton reggitBtn;
  private MyButton socialAllBtn;

  private MyPanel sourceCodePanel;
  private MyButton codeseekBtn;
  private MyButton gopensourceBtn;
  private MyButton searchcodeBtn;
  private MyButton sourceCodeAllBtn;
  //

  private String[] searchEngines = {
      "\"https://www.google.com/search?q=%s\"",
      "\"https://www.bing.com/search?q=%s\"",
      "\"https://www.ask.com/web?q=%s\"",
      "\"https://duckduckgo.com/?q=%s\"",
      "\"https://www.dogpile.com/serp?q=%s\"",
      "\"https://www.metacrawler.com/serp?q=%s\""};

  private String[] socialMedias = {
      "\"https://web.facebook.com/search/top/?q=%s\"",
      "\"https://twitter.com/search?q=%s\"",
      "\"https://www.youtube.com/results?search_query=%s\"",
      "\"https://duckduckgo.com/?q=%s\"",
      "\"https://www.reddit.com/r/reggit/search/?q=%s\""};

  private String[] sourceCodes = {
      "\"https://codeseek.com/seek?q=%s\"",
      "\"https://opensource.google/s/results?q=%s\"",
      "\"https://searchcode.com/?q=%s\""};

  String ICON_PATH = "/com/peculiar/ngita/icon.png";

  public UI() {
    super("Ngita All Search");
    setSize(700, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(
        getClass().getResource(ICON_PATH)));
    setVisible(true);
    setComponents();
    setEvent();
  }

  void setComponents() {
    txtArea = new JTextArea();
    txtArea.setLineWrap(true);
    txtArea.setTabSize(2);
    txtArea.setMargin(new Insets(10, 10, 10, 10));
    txtArea.setBackground(new Color(24, 24, 24));
    txtArea.setForeground(new Color(255, 255, 255));
    txtArea.setCaretColor(new Color(255, 255, 255));
    txtArea.setFont(new java.awt.Font("Roboto", 0, 13));

    setLayout(new BorderLayout());
    setPanels();
    add(btnPanel, BorderLayout.SOUTH);
    add(new JScrollPane(txtArea), BorderLayout.CENTER);
  }

  void setPanels() {
    btnPanel = new MyPanel();
    btnPanel.setLayout(new GridLayout(3, 1));

    setSocialPanel();
    btnPanel.add(socialPanel);

    setSearchEnginePanel();
    btnPanel.add(searchEnginePanel);

    setSourceCodePanel();
    btnPanel.add(sourceCodePanel);
  }

  void setSearchEnginePanel() {
    searchEnginePanel = new MyPanel();

    googleBtn = new MyButton("Google");
    bingBtn = new MyButton("Bing");
    askBtn = new MyButton("Ask");
    duckBtn = new MyButton("Duckduckgo");
    dogpileBtn = new MyButton("Dogpile");
    metacrawlerBtn = new MyButton("Metacrawler");
    searchEngineAllBtn = new MyButton("All");

    searchEnginePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    searchEnginePanel.add(askBtn);
    searchEnginePanel.add(bingBtn);
    searchEnginePanel.add(googleBtn);
    searchEnginePanel.add(duckBtn);
    searchEnginePanel.add(dogpileBtn);
    searchEnginePanel.add(metacrawlerBtn);
    searchEnginePanel.add(searchEngineAllBtn);
  }

  void setSocialPanel() {
    socialPanel = new MyPanel();

    facebookBtn = new MyButton("Facebook");
    twitterBtn = new MyButton("Twitter");
    youtubeBtn = new MyButton("Youtube");
    instagramBtn = new MyButton("Instagram");
    reggitBtn = new MyButton("Reggit");
    socialAllBtn = new MyButton("All");

    socialPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    socialPanel.add(facebookBtn);
    socialPanel.add(twitterBtn);
    socialPanel.add(youtubeBtn);
    socialPanel.add(instagramBtn);
    socialPanel.add(reggitBtn);
    socialPanel.add(socialAllBtn);
  }

  void setSourceCodePanel() {
    sourceCodePanel = new MyPanel();
    codeseekBtn = new MyButton("Code Seek");
    gopensourceBtn = new MyButton("Google openSource");
    searchcodeBtn = new MyButton("Search Code");
    sourceCodeAllBtn = new MyButton("All");
    sourceCodePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    sourceCodePanel.add(codeseekBtn);
    sourceCodePanel.add(gopensourceBtn);
    sourceCodePanel.add(searchcodeBtn);
    sourceCodePanel.add(sourceCodeAllBtn);
  }

  void setEvent() {
    setSearchEngineEvents();
    setSocialEvents();
    setCodeSearchEvents();
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

    dogpileBtn.addActionListener(e -> {
      String query = txtArea.getText();
      String searchCmd = String.format(searchEngines[4], query);
      CLI.execute("explorer " + searchCmd);
    });
    metacrawlerBtn.addActionListener(e -> {
      String query = txtArea.getText();
      String searchCmd = String.format(searchEngines[5], query);
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

  void setCodeSearchEvents() {
    codeseekBtn.addActionListener(e -> {
      String query = txtArea.getText();
      String searchCmd = String.format(sourceCodes[0], query);
      CLI.execute("explorer " + searchCmd);
    });
    gopensourceBtn.addActionListener(e -> {
      String query = txtArea.getText();
      String searchCmd = String.format(sourceCodes[1], query);
      CLI.execute("explorer " + searchCmd);
    });
    searchcodeBtn.addActionListener(e -> {
      String query = txtArea.getText();
      String searchCmd = String.format(sourceCodes[2], query);
      CLI.execute("explorer " + searchCmd);
    });

    sourceCodeAllBtn.addActionListener(e -> {
      String query = txtArea.getText();
      for (var i : sourceCodes) {
        String searchCmd = String.format(i, query);
        CLI.execute("explorer " + searchCmd);
      }
    });
  }
}