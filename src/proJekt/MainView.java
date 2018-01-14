package proJekt;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import swing2swt.layout.BoxLayout;

//import org.eclipse.ecf.ui.SWTResourceManager;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;



public class MainView {

	protected Shell shell;
	Display display;
	
	Button btnCenter;
	Button btnEnlarge;
	Button btnShrink;
	Button btnCutOut;
	Button btnOR;
	Button btnAND;
	Button btnXOR;
	Button btnSave;
	
	Combo FadeShadeNoneCombo;
	Combo FadeShadeOptionsCombo;
	
	boolean saved = true;
	ArrayList<ShadingOptions> shadingOptions = new ArrayList<ShadingOptions>();
	
	public static void main(String[] args) {
		try {
			MainView window = new MainView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(700, 600));
		shell.setSize(700, 600);
		shell.setText("proJekt");
		shell.setLayout(new GridLayout(3, false));
		shell.addListener(SWT.Close, new Listener() {
		      public void handleEvent(Event event) {
		    	 if(!saved){
		    		 MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
		    		            | SWT.YES | SWT.NO);
		    		        messageBox.setMessage("Previous output not saved, proceed?");
		    		        messageBox.setText("Ouptut not saved");
		    		        int response = messageBox.open();
		    		        if(response == SWT.YES)
		    		        	deleteFolderContent(new File(".\\output"));
		    		        event.doit = response == SWT.YES;
		    	 }
		    	 else
		    		 deleteFolderContent(new File(".\\output"));
		      }});
		
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
		
		btnAND = new Button(grpOperation, SWT.RADIO);
		btnAND.setText("AND");
		btnAND.setSelection(true);
		
		btnOR = new Button(grpOperation, SWT.RADIO);
		btnOR.setText("OR");
		
		btnXOR = new Button(grpOperation, SWT.RADIO);
		btnXOR.setText("XOR");
		
		Group grpResizingMode = new Group(operationsArea, SWT.NONE);
		grpResizingMode.setText("Resizing mode:");
		grpResizingMode.setLayout(new FillLayout(SWT.VERTICAL));
		
		btnCenter = new Button(grpResizingMode, SWT.RADIO);
		btnCenter.setText("Center images");
		btnCenter.setSelection(true);
		
		btnEnlarge = new Button(grpResizingMode, SWT.RADIO);
		btnEnlarge.setText("Enlarge smaller image");
		
		btnShrink = new Button(grpResizingMode, SWT.RADIO);
		btnShrink.setText("Shrink larger image");
		
		btnCutOut = new Button(grpResizingMode, SWT.RADIO);
		btnCutOut.setText("Cut out center of larger image");
		
		Composite buttonsArea1 = new Composite(operationsArea, SWT.NONE);
		buttonsArea1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		btnSave = new Button(buttonsArea1, SWT.PUSH);
		btnSave.setText("Save");
		btnSave.setEnabled(false);
		
		Group FadeShadeSettingsGroup = new Group(buttonsArea1, SWT.NONE);
		FadeShadeSettingsGroup.setText("Shading options");
		FadeShadeSettingsGroup.setLayout(new FillLayout(SWT.VERTICAL));
		 FadeShadeNoneCombo = new Combo(FadeShadeSettingsGroup, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		 FadeShadeNoneCombo.add("None");
		 FadeShadeNoneCombo.add("Fade");
		 FadeShadeNoneCombo.add("Shade");
		 FadeShadeNoneCombo.select(0);

		 
		 FadeShadeOptionsCombo = new Combo(FadeShadeSettingsGroup, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		 FadeShadeOptionsCombo.add("Top");
		 FadeShadeOptionsCombo.add("Bottom");
		 FadeShadeOptionsCombo.add("Left");
		 FadeShadeOptionsCombo.add("Right");
		 FadeShadeOptionsCombo.add("Top-Left");
		 FadeShadeOptionsCombo.add("Top-Right");
		 FadeShadeOptionsCombo.add("Bottom-Left");
		 FadeShadeOptionsCombo.add("Bottom-Right");
		 FadeShadeOptionsCombo.select(0);
		 

		//Button btnFadeShadeOptions = new Button(buttonsArea1, SWT.PUSH);
		//btnFadeShadeOptions.setText("Shading Settings");
		
		Composite buttonsArea2 = new Composite(operationsArea, SWT.NONE);
		buttonsArea2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnMergeImages = new Button(buttonsArea2, SWT.WRAP | SWT.PUSH);
		//btnMergeImages.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
		//btnMergeImages.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnMergeImages.setText("Merge \n Images");
		
		Button btnAddDirectory = new Button(buttonsArea2, SWT.WRAP | SWT.PUSH);
		//btnAddDirectory.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		//btnAddDirectory.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		btnAddDirectory.setText("Add \n Directory");
		
		Composite ViewingArea = new Composite(shell, SWT.NONE);
		ViewingArea.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_ViewingArea = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_ViewingArea.widthHint = 185;
		ViewingArea.setLayoutData(gd_ViewingArea);
		
		CTabFolder tabFolder = new CTabFolder(ViewingArea, SWT.BORDER | SWT.CLOSE);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		tabFolder.addSelectionListener(new SelectionAdapter() {
			 @Override
			 public void widgetSelected(SelectionEvent e) {
			  tabFolder.getSelection().notifyListeners(SWT.SELECTED, new Event());
			 }
			});
		
		tabFolder.addCTabFolder2Listener(new CTabFolder2Adapter() {

	        @Override
	        public void close(CTabFolderEvent event) {
	            CTabItem tabItem = (CTabItem) event.item;
	            shadingOptions.remove(tabItem.getParent().indexOf(tabItem));
	        }
	    });
		
		 FadeShadeNoneCombo.addSelectionListener(new SelectionListener() {
			 public void widgetSelected(SelectionEvent e) {
				 		if(!shadingOptions.isEmpty())
				 			shadingOptions.get(tabFolder.getSelectionIndex()).option = FadeShadeNoneCombo.getSelectionIndex();
			      }

			      public void widgetDefaultSelected(SelectionEvent e) {
			      }});
		 FadeShadeOptionsCombo.addSelectionListener(new SelectionListener() {
			 public void widgetSelected(SelectionEvent e) {
				 		if(!shadingOptions.isEmpty())
				 			shadingOptions.get(tabFolder.getSelectionIndex()).direction = FadeShadeOptionsCombo.getSelectionIndex();
			      }

			      public void widgetDefaultSelected(SelectionEvent e) {
			      }});
		
		ArrayList<BufferedImage> output = new ArrayList<BufferedImage>();
		
		btnSave.addListener(SWT.Selection, new Listener() // adding directory
			{
			 @Override
			    public void handleEvent(Event event)
			    {
				 FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				    dialog.setFilterExtensions(new String[] { "*.jpg", "*.JPEG", "*.bmp", "*.png", "*.tif", "*.tiff" });
				    dialog.setFilterPath("c:\\"); // Windows path
				    dialog.setFileName("output.jpg");
				    saveOutput(output, dialog.open());

			    }});
		btnAddDirectory.addListener(SWT.Selection, new Listener() // adding directory
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
		    	    	directoryPreview(tabFolder,chooser.getSelectedFile().getPath());
		    	    }
		    	    else 
		    	      System.out.println("No Selection ");
		    	
		    	     }
		    });
		
		btnMergeImages.addListener(SWT.Selection, new Listener(){
		    @Override
		    public void handleEvent(Event event)
		    {
		    	if(tabFolder.getItemCount()==0)
    	    	{
    	    		MessageBox empty = new MessageBox(shell);
    	    		empty.setMessage("No directories opened");
    	    		empty.open();
    	    		return;
    	    	}
		    	
		    	
		    	if(!saved)
		    	{
		    		 MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
		    		            | SWT.YES | SWT.NO);
		    		        messageBox.setMessage("Previous output not saved, proceed?");
		    		        messageBox.setText("Ouptut not saved");
		    		        int response = messageBox.open();
		    		        if (response == SWT.NO)
		    		        	return;
		    	}
		    	
		    	for(CTabItem item : tabFolder.getItems())
		    		if(item.getText().equals("Output"))
		    			item.dispose();
		    	if(btnDefault.getSelection())
		    	{
		    		ArrayList<String> dir = new ArrayList<String>();
		    		for(CTabItem item : tabFolder.getItems())
		    			dir.add(item.getText());
		    		mergeDirectories(output, dir, shadingOptions);
		    		saveTempOutput(output, tabFolder);
		    	}
		    	
		    	
		    	else if(btnManPickImg.getSelection())
		    	{
		    		Shell picker = new Shell(display);
		    		RowLayout pickerLayout = new RowLayout();
		    		pickerLayout.justify = true;
		    		pickerLayout.type = SWT.VERTICAL;
		    		picker.setLayout(pickerLayout);
		    		final Tree tree = new Tree(picker, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		    		tree.setSize(1000, 1000);
		    		picker.setSize(300, 300);
		    		picker.setText("Images pick");
		    		Button button = new Button(picker, SWT.PUSH);
		    		button.setText("Ok");
		    		
		    		for(CTabItem item : tabFolder.getItems())
		    		{
		    		    File[] files = new File(item.getText()).listFiles();
		    		    for(File file : files)
		    		    {
		    		    	if(isImage(file))
		    		    	{
		    		    		 TreeItem treeItem = new TreeItem(tree, 0);
		    		    	     treeItem.setText(file.getPath());
		    		    	}
		    		    }
		    		}
		    		
		    		button.addListener(SWT.Selection, new Listener(){
	    			    @Override
	    			    public void handleEvent(Event event)
	    			    {
	    			    	ArrayList<String> dir = new ArrayList<String>();
	    			    	for(TreeItem item : tree.getItems())
	    			    		if(item.getChecked())
	    			    			dir.add(item.getText());
	    			    	if(!dir.isEmpty())
	    			    	{
	    			    	File[] files = new File[dir.size()];
	    			    	for(int i = 0; i<dir.size(); i++)
	    			    		files[i] = new File(dir.get(i));
	    			    	mergeToOneFile(output, files, shadingOptions.get(tabFolder.getSelectionIndex()));
	    			    	saveTempOutput(output, tabFolder);
	    			    	}
	    			    	picker.dispose();}});
		    		picker.open();
		    	}
		    	
		    	else if(btnAllInDir.getSelection())
		    	{
		    		File[] files = new File(tabFolder.getItem(tabFolder.getSelectionIndex()).getText()).listFiles();
		    		mergeToOneFile(output, files, shadingOptions.get(tabFolder.getSelectionIndex()));
					saveTempOutput(output, tabFolder);	
		    	}
		    	
		    	else
		    	{
		    		CTabItem[] dir = tabFolder.getItems(); 
		    		Shell picker = new Shell(display); 
		    		 picker.setLayout(new GridLayout(1, true));
		    		 picker.setSize(280, 300);
		    		 picker.setText("Directories pick");
		    		 Table table = new Table(picker, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		    		 table.setHeaderVisible(true);
		    		 TableColumn column = new TableColumn(table, SWT.NULL);
		    	     column.setText("Directories");
		    	     for (int i=0; i<dir.length; i++) {
		    	         TableItem item = new TableItem(table, SWT.NULL);
		    	         item.setText(0, dir[i].getText());
		    	     }
		    	     table.getColumn(0).pack();
		    	     table.setBounds(25, 25, 220, 200);
		    	     Button button = new Button(picker, SWT.PUSH);
		    		 button.setText("Ok");
		    	     button.addListener(SWT.Selection, new Listener(){
		    			    @Override
		    			    public void handleEvent(Event event)
		    			    {
		    			    	ArrayList<String> dir = new ArrayList<String>();
		    			    	ArrayList<ShadingOptions> shading = new ArrayList<ShadingOptions>();
		    			    	for(int i = 0; i<table.getItemCount(); i++){
		    			    		if(table.getItem(i).getChecked()){
		    			    			dir.add(table.getItem(i).getText());
		    			    			shading.add(shadingOptions.get(i));
		    			    		}
		    			    	}
		    			    	if(!dir.isEmpty())
		    			    	{
		    			    	mergeDirectories(output, dir, shading);
		    			    	saveTempOutput(output, tabFolder);
		    			    	}
		    			    	picker.dispose();}});
		    	     
		    		 picker.open();
		    		 
		    	}
		    	
		    }});
		
		
	}
	
	private boolean isImage(File file)
	{
		if(file.isFile() && (file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".jpg") ||
    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".JPEG") ||
    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".png") ||
    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".bmp") ||
    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".tiff") ||
    	file.getPath().substring(file.getPath().lastIndexOf("."), file.getPath().length()).equals(".tif")))
			return true;
		else
			return false;
	}
	
	private void directoryPreview(CTabFolder tabFolder, String path)
	{
		File[] files = new File(path).listFiles();
    	CTabItem tbtmAdded = new CTabItem(tabFolder, SWT.NONE);
    	shadingOptions.add(new ShadingOptions());
    	tbtmAdded.addListener(SWT.SELECTED, new Listener() {

    		 @Override
    		 public void handleEvent(Event event) {
    			FadeShadeNoneCombo.select(shadingOptions.get(tabFolder.indexOf(tbtmAdded)).option);
    			FadeShadeOptionsCombo.select(shadingOptions.get(tabFolder.indexOf(tbtmAdded)).direction);
    		 }
    		});
    	tabFolder.setSelection(tbtmAdded);
    	if(path.equals(".\\output"))
    		tbtmAdded.setText("Output");
    	else
    		tbtmAdded.setText(path);
    	
    	ScrolledComposite sc = new ScrolledComposite(tabFolder, SWT.V_SCROLL);
    	
    	Composite composite = new Composite(sc, SWT.NONE);
    	composite.setLayout(new RowLayout());
    	
    	sc.addControlListener(new ControlAdapter() { //dynamic resize
    	    public void controlResized(ControlEvent e) {
    	        Rectangle r = sc.getClientArea();
    	        sc.setMinSize(composite.computeSize(r.width, SWT.DEFAULT));
    	    }
    	});
    	
    	sc.addListener(SWT.Activate, new Listener() { //mouse roll not working fix
    		  public void handleEvent(Event e) {
    		    sc.setFocus();
    		  }
    		});
    	tbtmAdded.setControl(sc);
    	
    	boolean notEmpty = false;
    	for (File file : files) {
    	    if (file.isFile()) {
    	    	System.out.println(file.getPath());
    	    
    	    	if(isImage(file))
    	    	{
    	    		Composite cell = new Composite(composite, SWT.NONE);
    	    		cell.setLayout(new BoxLayout(2));
    	    		ImageData inputData = new ImageData(file.getPath());
    	    		inputData = inputData.scaledTo(200*inputData.width/inputData.height, 200);
    	    		Image inputImg = new Image(display, inputData);
    	    		Image greyImg = new Image(display, inputImg, SWT.IMAGE_GRAY);
    	    		Label thumbnail = new Label(cell, SWT.PUSH);
    	    		thumbnail.setImage(greyImg);
    	    		Label name = new Label(cell, SWT.PUSH);
    	    		name.setText(file.getName()+"\n ");
    	    		inputImg.dispose();
    	    		
    	    		if(!notEmpty)
    	    			notEmpty = true;
    	    	};
    	    }
    	}
    	if(!notEmpty)
    	{
    		MessageBox empty = new MessageBox(shell);
    		empty.setMessage("No images in the directory");
    		tbtmAdded.dispose();
    		empty.open();
    	}
    	else
    	{
    		sc.setExpandHorizontal(true);
   		 	sc.setExpandVertical(true);
    		sc.setContent(composite);
    		sc.setMinSize(tabFolder.getSize());

    	}
	}
	
	
	private void saveTempOutput(ArrayList<BufferedImage> output, CTabFolder tabFolder)
	{
		btnSave.setEnabled(true);
		saved = false;
		deleteFolderContent(new File(".\\output"));
		for(int i = 0; i<output.size(); i++)
    	{
    		File outputImage = new File(".\\output\\output_"+i+".jpg");
    		try {
				ImageIO.write(output.get(i), "jpg", outputImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	directoryPreview(tabFolder, ".\\output");
	}
	
	private void saveOutput(ArrayList<BufferedImage> output, String path)
	{
		for(int i = 0; i<output.size(); i++)
    	{
    		File outputImage = new File(path.substring(0, path.lastIndexOf("."))+i+path.substring(path.lastIndexOf(".")));
    		try {
				ImageIO.write(output.get(i), path.substring(path.lastIndexOf(".")+1), outputImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
		output.clear();
		saved = true;
	}
	
	private void mergeDirectories(ArrayList<BufferedImage> output, ArrayList<String> dir, ArrayList<ShadingOptions> shading)
	{
	output.clear();
	int maxIndex = 0;
	int maxSize = 0;
	int imgCounter = 0;
	for(int i = 0; i<dir.size(); i++)
	{
		File[] files = new File(dir.get(i)).listFiles();
		for(File file : files)
			if (isImage(file))
				imgCounter++;
		if(imgCounter>maxSize)
		{
			maxSize = imgCounter;
			maxIndex = i;
		}
		imgCounter = 0;
	}
	File[] filesMaxDir = new File(dir.get(maxIndex)).listFiles();
	for(int i = 0; i<filesMaxDir.length; i++)
	{
		
		if(isImage(filesMaxDir[i]))
		{
				output.add(applyFadeShade(shading.get(maxIndex),IntoGrayscale.grayscale(filesMaxDir[i])));
		}
	}
	
	for(int i = 0; i<dir.size(); i++)
	{
		
		if(i!=maxIndex)
		{
			File[] files = new File(dir.get(i)).listFiles();
			int k = 0;
			for(int j = 0; j<files.length; j++)
			{
				
				if(isImage(files[j])){
				ArrayList<BufferedImage> pair = new ArrayList<BufferedImage>();
				if(btnCenter.getSelection())
					pair = Resize.CenterImages(output.get(k), applyFadeShade(shading.get(i),IntoGrayscale.grayscale(files[j])));
				else if(btnEnlarge.getSelection())
					pair = Resize.EnlargeImage(output.get(k), applyFadeShade(shading.get(i),IntoGrayscale.grayscale(files[j])));
				else if(btnShrink.getSelection())
					pair = Resize.ShrinkImage(output.get(k), applyFadeShade(shading.get(i),IntoGrayscale.grayscale(files[j])));
				else
					pair = Resize.CenterLarger(output.get(k), applyFadeShade(shading.get(i),IntoGrayscale.grayscale(files[j])));
				
				if(btnOR.getSelection())
					output.set(k, Merge.optionOR(pair.get(0), pair.get(1)));
				else if(btnAND.getSelection())
					output.set(k, Merge.optionAND(pair.get(0), pair.get(1)));
				else
					output.set(k, Merge.optionXOR(pair.get(0), pair.get(1)));
				k++;
				}
			}
		}
	}
	}
	
	private void mergeToOneFile(ArrayList<BufferedImage> output, File[] files, ShadingOptions shading)
	{
	output.clear();
	int imgIndex = 0;
	for(File file : files)
	{
		if(isImage(file))
			break;
		imgIndex++;
	}
	output.add(applyFadeShade(shading,IntoGrayscale.grayscale(files[imgIndex])));
	for(int i = imgIndex; i<files.length; i++)
	{
		if(isImage(files[i])){
		ArrayList<BufferedImage> pair = new ArrayList<BufferedImage>();
		if(btnCenter.getSelection())
			pair = Resize.CenterImages(output.get(0), applyFadeShade(shading, IntoGrayscale.grayscale(files[i])));
		else if(btnEnlarge.getSelection())
			pair = Resize.EnlargeImage(output.get(0), applyFadeShade(shading, IntoGrayscale.grayscale(files[i])));
		else if(btnShrink.getSelection())
			pair = Resize.ShrinkImage(output.get(0), applyFadeShade(shading, IntoGrayscale.grayscale(files[i])));
		else
			pair = Resize.CenterLarger(output.get(0), applyFadeShade(shading, IntoGrayscale.grayscale(files[i])));
		
		if(btnOR.getSelection())
			output.set(0, Merge.optionOR(pair.get(0), pair.get(1)));
		else if(btnAND.getSelection())
			output.set(0, Merge.optionAND(pair.get(0), pair.get(1)));
		else
			output.set(0, Merge.optionXOR(pair.get(0), pair.get(1)));
		}
	}
	}
	
	private void deleteFolderContent(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(!f.isDirectory()) f.delete();
	        }
	    }
	}
	
	private BufferedImage applyFadeShade(ShadingOptions arg, BufferedImage img){
		if(arg.option == 0)
			return img;
		else if(arg.option == 1){
			switch(arg.direction){
			case 0:
				return Fade.fromTop(img);
			case 1:
				return Fade.fromBottom(img);
			case 2:
				return Fade.fromLeft(img);
			case 3:
				return Fade.fromRight(img);
			case 4:
				return Fade.fromTopLeft(img);
			case 5:
				return Fade.fromTopRight(img);
			case 6:
				return Fade.fromBottomLeft(img);
			case 7:
				return Fade.fromBottomRight(img);
			default:
				return null;
			}
		}
			else {
				switch(arg.direction){
				case 0:
					return Shade.fromTop(img);
				case 1:
					return Shade.fromBottom(img);
				case 2:
					return Shade.fromLeft(img);
				case 3:
					return Shade.fromRight(img);
				case 4:
					return Shade.fromTopLeft(img);
				case 5:
					return Shade.fromTopRight(img);
				case 6:
					return Shade.fromBottomLeft(img);
				case 7:
					return Shade.fromBottomRight(img);
				default:
					return null;
				}
			}
			
	}
}
