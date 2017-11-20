/*package proJekt;


import java.io.File;
import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainView {

	protected Shell shell;

	
	
	
	public static void main(String[] args) {
		try {
			MainView window = new MainView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
/*
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}*/

	/**
	 * Create contents of the window.
	 */
	/*
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(700, 600));
		shell.setSize(700, 600);
		shell.setText("proJekt");
		shell.setLayout(new GridLayout(3, false));
		
		Composite operationsArea = new Composite(shell, SWT.NONE);
		operationsArea.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_operationsArea = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1 );
		gd_operationsArea.widthHint = 234;
		operationsArea.setLayoutData(gd_operationsArea);
		
		Group grpMode = new Group(operationsArea, SWT.NONE);
		grpMode.setText("Mode:");
		grpMode.setLayout(new FillLayout(SWT.VERTICAL));
		
		Button btnDefault = new Button(grpMode, SWT.RADIO);
		btnDefault.setText("Default");
		btnDefault.setSelection(true);
		
		Button btnManPickDir = new Button(grpMode, SWT.RADIO);
		btnManPickDir.setText("Manual pick of directories");
		
		Button btnAllInDir = new Button(grpMode, SWT.RADIO);
		btnAllInDir.setText("Merging all within one directory");
		
		Button btnManPickImg = new Button(grpMode, SWT.RADIO);
		btnManPickImg.setText("Manual pick of images");
		
		Group grpOperation = new Group(operationsArea, SWT.NONE);
		grpOperation.setText("Operation:");
		grpOperation.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnAND = new Button(grpOperation, SWT.RADIO);
		btnAND.setText("AND");
		btnAND.setSelection(true);
		
		Button btnOR = new Button(grpOperation, SWT.RADIO);
		btnOR.setText("OR");
		
		Button btnXOR = new Button(grpOperation, SWT.RADIO);
		btnXOR.setText("XOR");
		
		Group grpResizingMode = new Group(operationsArea, SWT.NONE);
		grpResizingMode.setText("Resizing mode:");
		grpResizingMode.setLayout(new FillLayout(SWT.VERTICAL));
		
		Button btnCenter = new Button(grpResizingMode, SWT.RADIO);
		btnCenter.setText("Center images");
		btnCenter.setSelection(true);
		
		Button btnEnlarge = new Button(grpResizingMode, SWT.RADIO);
		btnEnlarge.setText("Enlarge smaller image");
		
		Button btnShrink = new Button(grpResizingMode, SWT.RADIO);
		btnShrink.setText("Shrink larger image");
		
		Button btnCutOut = new Button(grpResizingMode, SWT.RADIO);
		btnCutOut.setText("Cut out center of larger image");
		
		Composite composite = new Composite(operationsArea, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnMergeImages = new Button(composite, SWT.NONE);
		btnMergeImages.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
		btnMergeImages.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnMergeImages.setText("Merge Images");
		
		Button btnAddDirectory = new Button(composite, SWT.NONE);
		btnAddDirectory.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnAddDirectory.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnAddDirectory.setText("Add Directory");
		
		Composite ViewingArea = new Composite(shell, SWT.NONE);
		ViewingArea.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_ViewingArea = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_ViewingArea.widthHint = 185;
		ViewingArea.setLayoutData(gd_ViewingArea);
		
		List list = new List(ViewingArea, SWT.BORDER);
		list.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		
		btnAddDirectory.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event event)
		    {
		    	JFileChooser chooser = new JFileChooser();
		    	 chooser.setCurrentDirectory(new java.io.File("."));
		    	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    	 chooser.setAcceptAllFileFilterUsed(false);
		    	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		    	    {
		    	      

		    	    	File[] files = new File(chooser.getSelectedFile().getPath()).listFiles();
		    	    	//If this pathname does not denote a directory, then listFiles() returns null. 

		    	    	for (File file : files) {
		    	    	    if (file.isFile()) {
		    	    	    	System.out.println(file.getPath());
		    	    	    
		    	    	    	if(file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".jpg") ||
		    	    	    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".jpeg") ||
		    	    	    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".png") ||
		    	    	    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".bmp") ||
		    	    	    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".tiff") ||
		    	    	    	file.getPath().substring(file.getPath().lastIndexOf(".")+1, file.getPath().length()).equals(".tif"))
		    	    	        list.add(file.getName());
		    	    	    }
		    	    	}
		    	    }
		    	    else 
		    	      System.out.println("No Selection ");
		    	      
		    	     }
		    });
		
		new Label(shell, SWT.NONE);
		
		
		
	}
} */
