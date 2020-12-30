import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Resume extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,lblRegNo,l12;
	TextField tName,tAge,tQ,tPercentage,tUniverse,tworkEx;
	TextArea tworkExp,tskills;
	Button bSubmit,bClear;
	Panel p1,p2,p3,p4;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	Checkbox male,female;
	CheckboxGroup cbg;
	Checkbox selectedCheckbox;
	Choice c;
	//private class HandleMouse extends MouseMotionAdapter
	//{
		//public void mouseMoved(MouseEvent me)
		//{
			//System.out.println("mouse moved x coordinate is - "+me.getX()+" y coordinate is - "+me.getY());

		//}
	//}
	
		
	public Resume()
	{
		//th=t;
		setSize(700,500);
		this.setLayout(null); //new GridLayout(2,1,5,5));
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		
		p1.setBounds(10,10,690,50);
		p2.setBounds(10,70,340,210);
		p3.setBounds(350,70,350,200);
		p4.setBounds(10,270,690,140);
		
		l3=new Label("RESUME BUILDER",Label.CENTER);
		l3.setBounds(20,20,600,40);
		Font myFont = new Font("Arial",Font.BOLD,18);
		l3.setFont(myFont);
		p1.add(l3);
		
		add(p1);
		
		l4=new Label("Personal Info");
		l4.setBounds(10,20,120,40);
		Font my1Font = new Font("Serif",Font.BOLD,14);
		l4.setFont(my1Font);
		p2.add(l4);
		
		l1=new Label("Name");
		l1.setBounds(10,60,60,20);
		p2.add(l1);
		tName=new TextField("");
		tName.setBounds(70,60,100,20);
		p2.add(tName);
		
		
		l2=new Label("Age");
		l2.setBounds(10,100,60,20);
		p2.add(l2);
		tAge=new TextField("");
		tAge.setBounds(70,100,100,20);
		p2.add(tAge);
		
		l5=new Label("Gender");
		l5.setBounds(10,140,50,20);
		p2.add(l5);
		
		cbg = new CheckboxGroup();  
        male = new Checkbox("Male", cbg,false);    
        male.setBounds(70,140,60,20);    
        female = new Checkbox("Female", cbg, false);
		female.setBounds(130,140,70,20);    
       
		p2.add(male);    
        p2.add(female);
		 
		
		l6=new Label("Country");
		l6.setBounds(10,180,50,20);
		p2.add(l6);
		c=new Choice();  
        c.setBounds(70,180,100,20);
		c.add("----");
        c.add("USA");  
        c.add("Australia");  
        c.add("India");  
        c.add("Ireland");  
        c.add("Dubai");  
        p2.add(c);
		
		add(p2);

		l7=new Label("Academic Info");
		l7.setBounds(10,20,150,40);
		l7.setFont(my1Font);
		p3.add(l7);
		
		l8=new Label("Qualification");
		l8.setBounds(10,60,80,20);
		p3.add(l8);
		tQ=new TextField();
		tQ.setBounds(100,60,100,20);
		p3.add(tQ);
		
		l9=new Label("Percentage");
		l9.setBounds(10,100,60,30);
		p3.add(l9);
		tPercentage=new TextField();
		tPercentage.setBounds(100,60,100,20);
		p3.add(tPercentage);
		add(p3);
		
		
		
		l11=new Label("work experience");
		l11.setBounds(10,40,90,20);
		p4.add(l11);
		tworkExp=new TextArea("");
		tworkExp.setBounds(120,40,200,80);
		p4.add(tworkExp);
		
		l12=new Label("Skills");
		l12.setBounds(340,40,50,20);
		p4.add(l12);
		tskills=new TextArea("");
		tskills.setBounds(400,40,200,80);
		p4.add(tskills);
		
		add(p4);
		
		bSubmit=new Button("SUBMIT");
		bClear=new Button("CLEAR");
		bSubmit.setBounds(210,420,70,30);
		bClear.setBounds(390,420,70,30);
		add(bSubmit);
		add(bClear);
		
		lblRegNo=new Label();
		lblRegNo.setBounds(10,420,350,40);
		add(lblRegNo);
	
		
		bSubmit.addActionListener(this);
		bClear.addActionListener(this);
		
		//this.addMouseMotionListener(new HandleMouse());
		
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                
				dispose();  
            }			
        });  
		//tName.addTextListener(this);
		//tAge.addTextListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getActionCommand()=="Submit")
		{	
			//String t=tName.getText();
			//System.out.println(t+"Length: "+t.length());//Submit clicked: "+(tName.getText()==""?"Yes":"No"));
			if(tName.getText().equals("") || tAge.getText().equals("") || c.getItem(c.getSelectedIndex()).equals("----")  || tQ.getText().equals("") || tPercentage.getText().equals("") || cbg.getSelectedCheckbox()==null)
			{
				System.out.println("personal and academic details cannot be left blank");
				
			}
			else
			{	
			 try
			 {
				 
				 System.out.println(System.getProperty("user.dir"));
				//dataIn = new DataInputStream(new FileInputStream("D:\\java codes\\project\\StudReg.txt"));
				//str=dataIn.readInt();
				
				//personal info
				
				String name="Name: "+tName.getText();
				String age="Age: "+tAge.getText();
				
				selectedCheckbox=cbg.getSelectedCheckbox();
				System.out.println(selectedCheckbox);
				String gender="Gender: "+selectedCheckbox.getLabel();
				String country="Country: "+c.getItem(c.getSelectedIndex());
				
				//academic info
				String qual= "Qualification: "+tQ.getText();
				String percentage="Percentage: "+tPercentage.getText();
				
				//Work Exp
				String Exp="Work Experience: "+tworkExp.getText();
				String skills="Skills: "+tskills.getText();
				System.out.println(Exp);
				
				
				FileWriter myWriter = new FileWriter("resume-"+tName.getText()+".txt");
				myWriter.write(name);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(age);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(gender);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(country);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(qual);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(percentage);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(Exp);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(skills);
				myWriter.close();
				
				
				
				//dataOut=new DataOutputStream(new FileOutputStream("D:\\college\\java\\New folder\\resume.txt"));
				//dataOut.write(name);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			}
		}
		if(a.getActionCommand()=="Clear")
		{
			
			tName.setText("");
			tAge.setText("");
			tQ.setText("");
			tPercentage.setText("");
			tworkExp.setText("");
			tskills.setText("");
			cbg.getSelectedCheckbox().setState(false);
			c.select(0);
		}
	}
	public static void main(String[] p)
	{
		Resume f=new Resume();
		f.setTitle("RESUME");
		f.setVisible(true);
		
	}
}

		
		
