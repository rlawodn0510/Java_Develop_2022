package CustomerManager;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import CustomerManager.Customer;

public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener{//----2

	   //����ʵ�
	   private static final long serialVersionUID = 1L;
	   //------------------ ȭ�� ���� ��� -----------------------
	   private TextField nametf = new TextField(20);
	   
	   private TextField jumin1tf = new TextField(7);
	   private TextField jumin2tf = new TextField(8);
	   
	   private Choice telch = new Choice();
	      private String[] tstr = {"010", "011", "016", "017", "018", "019"};
	   private TextField tel1tf = new TextField(4);
	   private TextField tel2tf = new TextField(4);
	   
	   private CheckboxGroup cg = new CheckboxGroup();
	      private Checkbox man = new Checkbox("����", true, cg);
	      private Checkbox woman = new Checkbox("����", false, cg);
	   
	   private String[] hstr = {"����", "����", "��ȭ", "����", "����"};
	   private Checkbox[] hobby = new Checkbox[hstr.length];
	   
	   private Button addbt = new Button("���");
	   private Button dispbt = new Button("�м�");
	   private Button updatebt = new Button("����");
	   private Button delbt = new Button("����");
	   private Button initbt = new Button("�Է¸��");
	   
	   private java.awt.List listli = new java.awt.List();
	   private TextArea infota = new TextArea();
	   
	   //------------------ �޴� ���� ��� -----------------------
	   private MenuBar mb = new MenuBar();
	   
	   private Menu mfile = new Menu("File");
	      private MenuItem mfnew = new MenuItem("New File");
	      private MenuItem mfopen = new MenuItem("Open File");
	      private MenuItem mfsave = new MenuItem("Save File");
	      private MenuItem mfsaveas = new MenuItem("Save as File");
	      private MenuItem mfexit = new MenuItem("Exit");
	      
	   private Menu mhelp = new Menu("Help");
	      private MenuItem mhver = new MenuItem("Version Infomatino");
	   
	   //------------------ ��Ÿ ���� ��� -----------------------
	   private java.util.List<Customer> data = new java.util.ArrayList<Customer>(); 
	   private Dialog dialog = new Dialog(this, "Version Information", true);
	   private Label dlabel = new Label("Customer Manager V1.0", Label.CENTER);
	   private Button dbt = new Button("Ȯ��");
	   private File myfile = null;
	   private FileDialog fd = null;
	      
	   //������
	   public CustomerManager() {
	      super();
	      setDialog();//���̾˷α� ����
	      setMenu();  //�޴�����
	      buildGUI(); //ȭ�鱸��
	      setEvent(); //�̺�Ʈ ����
	   }
	   
	   //�޼���
	   private void setEvent() {
	      mfexit.addActionListener(this);
	      mfsaveas.addActionListener(this);
	      mfsave.addActionListener(this);
	      mfopen.addActionListener(this);
	      mfnew.addActionListener(this);
	      dbt.addActionListener(this);
	      mhver.addActionListener(this);
	      initbt.addActionListener(this);
	      delbt.addActionListener(this);
	      updatebt.addActionListener(this);
	      dispbt.addActionListener(this);
	      listli.addItemListener(this);
	      addbt.addActionListener(this);
	      tel1tf.addActionListener(this);
	      telch.addItemListener(this);
	      jumin2tf.addKeyListener(this);
	      jumin1tf.addKeyListener(this);
	      nametf.addActionListener(this);
	      addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	   }
	   
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      if(e.getSource() == nametf) {
	         jumin1tf.requestFocus();
	         return;
	      }
	      if(e.getSource() == tel1tf) {
	         tel2tf.requestFocus(); return;
	      }
	      if(e.getSource() == addbt) {//��Ϲ�ư
	         String name = nametf.getText().trim();
	         String jumin = jumin1tf.getText().trim() + jumin2tf.getText().trim();
	         String tel = telch.getSelectedItem() + "-" + tel1tf.getText() + "-" + tel2tf.getText();
	         boolean gender = man.getState();
	         String myhobby = "";
	         for(int i=0; i<hobby.length; i++) {
	            if(hobby[i].getState()) {
	               myhobby += hobby[i].getLabel() + "-";
	            }
	         }
	         if(myhobby.length() == 0) myhobby = "����";
	         else myhobby = myhobby.substring(0, myhobby.length()-1);
	         
	         Customer myCustomer = new Customer(name, jumin, tel, gender, myhobby);
	         data.add(myCustomer);
	         listli.add(myCustomer.toString());
	         infota.setText("\n\t���������� �����Ͱ� ��ϵǾ����ϴ�.");
	         try {
	            Thread.sleep(500);
	         }catch(InterruptedException ir) { }
	         clrscr();//ȭ�������
	      }//end ���
	      if(e.getSource() == dispbt) {
	         String jumin = jumin1tf.getText() + jumin2tf.getText();
	         juminCheck(jumin);//�ֹι�ȣ �м�
	      }
	      if(e.getSource() == updatebt) {//������ư
	         setForm(true);
	         setButton(true);
	         Customer myCustomer = data.get(listli.getSelectedIndex());
	         String tel = telch.getSelectedItem() + "-" + tel1tf.getText() + "-" + tel2tf.getText();
	         String myhobby = "";
	         for(int i=0; i<hobby.length; i++) {
	            if(hobby[i].getState()) {
	               myhobby += hobby[i].getLabel() + "-";
	            }
	         }
	         if(myhobby.length() == 0) myhobby = "����";
	         else myhobby = myhobby.substring(0, myhobby.length()-1);
	         myCustomer.setTel(tel);
	         myCustomer.setHobby(myhobby);
	         infota.setText("\n\t���������� �����Ǿ����ϴ�.");
	         try {
	            Thread.sleep(500);
	         }catch(InterruptedException ir) { }
	         clrscr();
	      }
	      if(e.getSource() == delbt) {//������ư
	         setForm(true);
	         setButton(true);
	         int index = listli.getSelectedIndex();
	         listli.remove(index);
	         data.remove(index);
	         infota.setText("\n\t���������� �����Ǿ����ϴ�.");
	         try {
	            Thread.sleep(500);
	         }catch(InterruptedException ir) { }
	         clrscr();
	      }
	      if(e.getSource() == initbt) {//�Է¸��
	         setForm(true);
	         setButton(true);
	         clrscr();
	      }
	      if(e.getSource() == mhver) {
	         setMyLoc();
	         dialog.setVisible(true);
	      }
	      if(e.getSource() == dbt) {
	         dialog.setVisible(false);
	      }
	      if(e.getSource() == mfexit) {
	         System.exit(0);
	      }
	      if(e.getSource() == mfnew) {//������
	         listli.removeAll();
	         data.clear();
	         myfile = null;
	         fd = null;
	         setButton(true);
	         setForm(true);
	         clrscr();
	      }
	      if(e.getSource() == mfopen) {//�ҷ�����
	         fd = new FileDialog(this, "�����ͷε�", FileDialog.LOAD);
	         fd.setVisible(true);
	         String fileName = fd.getFile();
	         String folder = fd.getDirectory();
	         if(fileName == null || folder == null) return;
	         myfile = new File(folder, fileName);
	         //fileLoad();
	         dataLoad();
	      }
	      if(e.getSource() == mfsave) {//�����ϱ�
	         if(myfile == null) {
	            fd = new FileDialog(this, "����������", FileDialog.SAVE);
	            fd.setVisible(true);
	            String fileName = fd.getFile();
	            String folder = fd.getDirectory();
	            if(fileName == null || folder == null) return;
	            myfile = new File(folder, fileName);
	         }
	         //fileSave();
	         saveData();
	      }
	      if(e.getSource() == mfsaveas) {//�� �̸����� �����ϱ�
	         fd = new FileDialog(this, "����������", FileDialog.SAVE);
	         fd.setVisible(true);
	         String fileName = fd.getFile();
	         String folder = fd.getDirectory();
	         if(fileName == null || folder == null) return;
	         myfile = new File(folder, fileName);
	         //fileSave();
	         saveData();
	      }
	   }//end Action
	   
	   @Override
	   public void itemStateChanged(ItemEvent e) {
	      if(e.getSource() == telch) {
	         tel1tf.requestFocus(); return;
	      }
	      if(e.getSource() == listli) {
	         int index = listli.getSelectedIndex();
	         Customer myCustomer = data.get(index);
	         nametf.setText(myCustomer.getName());
	         jumin1tf.setText(myCustomer.getJumin().substring(0, 6));
	         jumin2tf.setText(myCustomer.getJumin().substring(6));
	         String[] phone = myCustomer.getTel().split("-");
	         telch.select(phone[0]);
	         tel1tf.setText(phone[1]);
	         tel2tf.setText(phone[2]);
	         man.setState(myCustomer.isGender());
	         woman.setState(!myCustomer.isGender());
	         for(int i=0; i<hobby.length; i++)
	            hobby[i].setState(false);
	         StringTokenizer st = new StringTokenizer(myCustomer.getHobby(), "-");
	         while(st.hasMoreElements()) {
	            String imsi = st.nextToken();
	            for(int i=0; i<hobby.length; i++) {
	               if(imsi.equals(hobby[i].getLabel())) {
	                  hobby[i].setState(true);
	                  break;
	               }
	            }
	         }
	         setForm(false);
	         setButton(false);
	      }
	   }

	   @Override
	   public void keyTyped(KeyEvent e) {}

	   @Override
	   public void keyPressed(KeyEvent e) {}

	   @Override
	   public void keyReleased(KeyEvent e) {
	      if(e.getSource() == jumin1tf) {
	         if(jumin1tf.getText().trim().length() == 6) {
	            jumin2tf.requestFocus(); return;
	         }
	      }
	      if(e.getSource() == jumin2tf) {
	         if(jumin2tf.getText().trim().length() == 7) {
	            telch.requestFocus(); return;
	         }
	      }
	   }

	   private void setButton(boolean state) {
	      addbt.setEnabled(state);
	      dispbt.setEnabled(!state);
	      updatebt.setEnabled(!state);
	      delbt.setEnabled(!state);
	      initbt.setEnabled(!state);
	   }

	   private void juminCheck(String juminNumber) {
	      int[] jumin = new int[13];
	      for(int i=0; i<jumin.length; i++) {
	         jumin[i] = juminNumber.charAt(i) - 48;
	      }
	      // �迭������ �м�.
	   }
	   
	   private void saveData() {
	      FileOutputStream fos = null;
	      ObjectOutputStream oos = null;
	      try {
	         fos = new FileOutputStream(myfile);
	         oos = new ObjectOutputStream(fos);
	         for(int i=0; i<data.size(); i++) {
	            Customer myCustomer = data.get(i);
	            oos.writeObject(myCustomer);
	         }
	      }catch(FileNotFoundException fnfe) {
	         System.err.println("��ΰ� �߸��Ǿ����ϴ�.");
	      }catch(IOException ioe) {
	         ioe.printStackTrace();
	      }finally {
	         try { if(oos != null) oos.close(); }catch(IOException ioe) { }
	         try { if(fos != null) fos.close(); }catch(IOException ioe) { }
	      }
	   }
	   
	   private void dataLoad() {
	      listli.removeAll();
	      data.clear();
	      FileInputStream fis = null;
	      ObjectInputStream ois = null;
	      try {
	         fis = new FileInputStream(myfile);
	         ois = new ObjectInputStream(fis);
	         Customer myCustomer = null;
	         while((myCustomer = (Customer) ois.readObject()) != null) {
	            listli.add(myCustomer.toString());
	            data.add(myCustomer);
	         }
	      }catch(ClassNotFoundException cnfe) {
	         infota.setText("\n\tCustomer Ŭ������ ��ȯ�� �� �����ϴ�.");
	      }catch(EOFException eofe) {
	         infota.setText("\n\t���������� �����͸� �ε� �Ͽ����ϴ�.");
	      }catch(IOException ioe) {
	         ioe.printStackTrace();
	      }finally {
	         try { if(ois != null) ois.close(); }catch(IOException ioe) { }
	         try { if(fis != null) fis.close(); }catch(IOException ioe) { }
	      }
	   }
	   
	   private void fileLoad() {
	      listli.removeAll();
	      data.clear();
	      FileReader fr = null;
	      BufferedReader br = null;
	      try {
	         fr = new FileReader(myfile);
	         br = new BufferedReader(fr);
	         String imsidata = "";
	         while((imsidata = br.readLine()) != null) {
	            String[] temp = imsidata.split("/");
	            boolean gender = true;
	            if(temp[3].equals("����")) gender = false;
	            Customer myCustomer = new Customer(temp[0], temp[1], temp[2], gender, temp[4]);
	            data.add(myCustomer);
	            listli.add(myCustomer.toString());
	         }
	      }catch(EOFException eofe) {
	         infota.setText("\n\t���������� �����͸� �ε� �Ͽ����ϴ�.");
	      }catch(IOException ioe) {
	         ioe.printStackTrace();
	      }finally {
	         try { if(br != null) br.close(); }catch(IOException ioe) { }
	         try { if(fr != null) fr.close(); }catch(IOException ioe) { }
	      }
	   }
	   
	   private void fileSave() {
	      FileWriter fw = null;
	      BufferedWriter bw = null;
	      PrintWriter pw = null;
	      try {
	         fw = new FileWriter(myfile);
	         bw = new BufferedWriter(fw);
	         pw = new PrintWriter(bw, true);
	         for(int i=0; i<data.size(); i++) {
	            Customer myCustomer = data.get(i);
	            StringBuffer sb = new StringBuffer(myCustomer.getName()); sb.append("/");
	            sb.append(myCustomer.getJumin()); sb.append("/");
	            sb.append(myCustomer.getTel()); sb.append("/");
	            sb.append(myCustomer.isGender() ? "����" : "����"); sb.append("/");
	            sb.append(myCustomer.getHobby());
	            pw.println(sb.toString());
	         }
	      }catch(FileNotFoundException fnfe) {
	         System.err.println("��ΰ� �߸��Ǿ����ϴ�.");
	      }catch(IOException ioe) {
	         ioe.printStackTrace();
	      }finally {
	         if(pw != null) pw.close();
	         try { if(bw != null) bw.close(); }catch(IOException ioe) { }
	         try { if(fw != null) fw.close(); }catch(IOException ioe) { }
	      }
	   }
	   
	   private void setDialog() {
	      dialog.setLayout(new BorderLayout(3,3));
	      dialog.add("North", new Label());
	      dialog.add("West", new Label());
	      dialog.add("East", new Label());
	      dialog.add("South", new Label());
	      Panel dmain = new Panel(new BorderLayout(3,3));
	         dlabel.setFont(new Font("����ü", Font.BOLD, 25));
	         dbt.setFont(new Font("����ü", Font.BOLD, 25));
	         dmain.add("Center", dlabel);
	         dmain.add("South", dbt);
	      dialog.add("Center", dmain);
	      dialog.pack();
	   }
	   
	   private void setMyLoc() {
	      Dimension my = this.getSize();
	      Dimension d = dialog.getSize();
	      System.out.println(this.getX() + ", " + this.getY());
	      dialog.setLocation(this.getX() + (my.width/2-d.width/2), this.getY() + (my.height/2-d.height/2));
	   }
	   
	   private void setForm(boolean state) {
	      nametf.setEnabled(state);
	      jumin1tf.setEnabled(state);
	      jumin2tf.setEnabled(state);
	      man.setEnabled(state);
	      woman.setEnabled(state);
	   }
	   private void clrscr() {
	      nametf.setText("");
	      jumin1tf.setText("");
	      jumin2tf.setText("");
	      telch.select(0);
	      tel1tf.setText("");
	      tel2tf.setText("");
	      man.setState(true);
	      for(int i=0; i<hobby.length; i++)
	         hobby[i].setState(false);
	      infota.setText("");
	      nametf.requestFocus();
	   }
	   /**
	    * �޴��� �����ϴ� �޼���
	    */
	   private void setMenu() {
	      setMenuBar(mb);
	      mb.add(mfile);
	         mfile.add(mfnew);
	         mfile.addSeparator();
	         mfile.add(mfopen);
	         mfile.add(mfsave);
	         mfile.add(mfsaveas);
	         mfile.addSeparator();
	         mfile.add(mfexit);
	      mb.add(mhelp);
	         mhelp.add(mhver);
	   }
	   /**
	    * ȭ���� �����ϴ� �޼���
	    */
	   private void buildGUI() {
	      setBackground(Color.cyan);
	      setLayout(new BorderLayout(3,3));
	      add("North", new Label());
	      add("South", new Label());
	      add("West", new Label());
	      add("East", new Label());
	      
	      Panel mainPanel = new Panel(new BorderLayout(3,3));
	         Panel centerPanel = new Panel(new BorderLayout(3,3));
	            centerPanel.add("North", new Label("�� �� �� �� �� ��", Label.CENTER));
	            
	            Panel cwPanel = new Panel(new GridLayout(5,1,3,3));
	               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
	               cwPanel.add(new Label("�ֹι�ȣ : ", Label.RIGHT));
	               cwPanel.add(new Label("��ȭ��ȣ : ", Label.RIGHT));
	               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
	               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
	            centerPanel.add("West", cwPanel);
	            
	            centerPanel.add("East", new Label());
	            
	            Panel csPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
	               csPanel.add(addbt);
	               csPanel.add(dispbt);
	               csPanel.add(updatebt);
	               csPanel.add(delbt);
	               csPanel.add(initbt);
	            centerPanel.add("South", csPanel);
	            
	            Panel ccPanel = new Panel(new GridLayout(5,1,3,3));
	               Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
	                  p1.add(nametf);
	               ccPanel.add(p1);
	               
	               Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
	                  p2.add(jumin1tf);
	                  p2.add(new Label("-", Label.CENTER));
	                  p2.add(jumin2tf);
	               ccPanel.add(p2);
	               
	               Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
	                  for(String temp : tstr) telch.add(temp);
	                  p3.add(telch);
	                  p3.add(new Label("-", Label.CENTER));
	                  p3.add(tel1tf);
	                  p3.add(new Label("-", Label.CENTER));
	                  p3.add(tel2tf);
	               ccPanel.add(p3);
	               
	               Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
	                  p4.add(man);
	                  p4.add(woman);
	               ccPanel.add(p4);
	               
	               Panel p5 = new Panel(new FlowLayout(FlowLayout.LEFT));
	                  for(int i=0; i<hobby.length; i++) {
	                     hobby[i] = new Checkbox(hstr[i]);
	                     p5.add(hobby[i]);
	                  }
	               ccPanel.add(p5);
	            centerPanel.add("Center", ccPanel);
	         mainPanel.add("Center", centerPanel);
	         
	         Panel eastPanel = new Panel(new BorderLayout(3,3));
	            eastPanel.add("North", new Label("�� �� �� ��", Label.CENTER));
	            eastPanel.add("Center", listli);
	         mainPanel.add("East", eastPanel);
	         
	         Panel southPanel = new Panel(new BorderLayout(3,3));
	            southPanel.add("North", new Label("�� �� �� �� �� �� �� ��", Label.CENTER));
	            southPanel.add("Center", infota);
	         mainPanel.add("South", southPanel);
	      add(mainPanel);
	      
	      setSize(510, 541);//----3 : pack();
	      setResizable(false);
	      
	      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
	      Dimension my = getSize();
	      setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
	      
	      setForm(true);
	      setButton(true);
	      nametf.requestFocus();
	      
	      setVisible(true);//----4
	   }
	   
	   public static void main(String[] args) {
	      new CustomerManager();
	   }
	}
