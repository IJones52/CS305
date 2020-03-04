// finish (and comment) me!

package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;

/**
 * 
 * @author Ismael Jones
 * @version 3/4/20
 */
public class SnapShopGUI extends JFrame{
    
    /**
     * Panel fldies
     * */
    private JPanel north;
    private JPanel south;
    private JPanel mid;
    
    /**
     * Button fields
     * */
    private JButton edgeDetect;
    private JButton edgeHighlight;
    private JButton flipHorizontal;
    private JButton flipVertical;
    private JButton grayScale;
    private JButton sharpen;
    private JButton soften;
    private JButton open;
    private JButton save;
    private JButton close;
    
    /**
     * Image fields
     * */
    private JLabel img;
    private PixelImage pixels;
    
    
    /**
     * The file chooser
     * */
    JFileChooser chooser = new JFileChooser();
    
    /**
     * Creates a new snapshop gui and sets up all of its components.
     * */
    public SnapShopGUI() {
        setSize(750,200);
        setTitle("TCSS 305 - Assignment 4 ");
        setLayout(new BorderLayout());
        setupNorth();
        //setupCenter();
        setupSouth();

    }

    
    /**
     * A method to start snapshop. Makes the GUI visible and sets the close operation
     */
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
    
    /**
     * A method that sets up the north jpanel, and all of its buttons and actions
     * */
    public void setupNorth() {
        //Create the buttons
        north = new JPanel();
        edgeDetect = new JButton("Edge Detect");
        edgeHighlight = new JButton("Edge Highlight");
        flipHorizontal = new JButton("Filp Horizontal");
        flipVertical = new JButton("Flip Vertical");
        grayScale = new JButton("Grayscale");
        sharpen = new JButton("Sharpen");
        soften = new JButton("Soften");
        
        //disable the buttons
        edgeDetect.setEnabled(false);
        edgeHighlight.setEnabled(false);
        flipHorizontal.setEnabled(false);
        flipVertical.setEnabled(false);
        grayScale.setEnabled(false);
        sharpen.setEnabled(false);
        soften.setEnabled(false);
        
        
        //add the buttons
        north.add(edgeDetect);
        north.add(edgeHighlight);
        north.add(flipHorizontal);
        north.add(flipVertical);
        north.add(grayScale);
        north.add(sharpen);
        north.add(soften);
        add(north, BorderLayout.NORTH);
    }
    /**
     * Creates an empty middle panel;
     * */
    public void setupCenter() {
        remove(mid);
        mid = new JPanel();
        add(mid, BorderLayout.CENTER);
    }
    
    
    /**
     * Sets up the southern panel and the file open action listener
     * */
    public void setupSouth() {
        //Create the buttons
        south = new JPanel();
        open = new JButton("Open..");
        save = new JButton("Save as...");
        close = new JButton("Close Image");
        
        //disable the appropriate buttons
        save.setEnabled(false);
        close.setEnabled(false);
        
    
        south.add(open);
        south.add(save);
        south.add(close);
        add(south, BorderLayout.SOUTH);
        //Make open action listener
        open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onFileOpen();
            }
            
        });
        
    }
    
    /**
     * A method that allows the user to select the image and then displays it in the middle panel
     * @throws IOException
     * */
    public void onFileOpen() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        //Display the image
        int returnVal = chooser.showOpenDialog(SnapShopGUI.this);
        
        //if a file is selected
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            //Display image
            try {
                pixels = PixelImage.load(chooser.getSelectedFile());
                img = new JLabel();
                img.setIcon(new ImageIcon(pixels));
                mid = new JPanel();
                mid.add(img);
                add(mid, BorderLayout.CENTER);
                
              //enable the buttons
               
                enableAll();
              //setup action listeners
                setupActions();    
                
                pack();
            }
            catch(IOException e){
                JOptionPane error = new JOptionPane("The selected file" + chooser.getSelectedFile().getName() + "is not an image file");
                error.setVisible(true);
                
            }
            

        }
        else {
            //do nothing
        }
       
    }
    
    
    /**
     * A method that changes the state of buttons when a file is closed
     * Also clears the image, and resizes the GUI
     * */
    public void onFileClose() {
        //disable the buttons
        disableAll();
        //Delete the image
        setupCenter();
        pack();
    }
    
    /**
     * A method that enables all buttons
     * */
    public void enableAll() {
        edgeDetect.setEnabled(true);
        edgeHighlight.setEnabled(true);
        flipHorizontal.setEnabled(true);
        flipVertical.setEnabled(true);
        grayScale.setEnabled(true);
        sharpen.setEnabled(true);
        soften.setEnabled(true);
        save.setEnabled(true);
        close.setEnabled(true);
    }
    
    /**
     * A method that disables all buttons except open
     * */
    public void disableAll() {
        edgeDetect.setEnabled(false);
        edgeHighlight.setEnabled(false);
        flipHorizontal.setEnabled(false);
        flipVertical.setEnabled(false);
        grayScale.setEnabled(false);
        sharpen.setEnabled(false);
        soften.setEnabled(false);
        save.setEnabled(false);
        close.setEnabled(false);

    }
    
    /**
     * A method that sets up action listeners for all buttons once they've been enabled
     * Each action listener is implemented with a lambda expression all activating the associated filter
     * @throws IOException on improper file writing
     * */
    public void setupActions() {
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onFileClose();
            }
            
        });
        
        grayScale.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              new GrayscaleFilter().filter(pixels);
              repaint();
            }
            
        });
        
        edgeDetect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new EdgeDetectFilter().filter(pixels);
                repaint();
            }
            
        });
        edgeHighlight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new EdgeHighlightFilter().filter(pixels);
                repaint();
            }
            
        });
        flipHorizontal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new FlipHorizontalFilter().filter(pixels);
                repaint();
            }
            
        });
        flipVertical.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new FlipVerticalFilter().filter(pixels);
                repaint();
            }
            
        });
        sharpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SharpenFilter().filter(pixels);
                repaint();
            }
            
        });
        soften.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SoftenFilter().filter(pixels);
                repaint();
            }
            
        });
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.showSaveDialog(SnapShopGUI.this);
                int userSelection = chooser.showSaveDialog(SnapShopGUI.this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = chooser.getSelectedFile();
                    try {
                        pixels.save(fileToSave);
                    }
                    catch (IOException e1) {
                        JOptionPane error = new JOptionPane("The selected file" + chooser.getSelectedFile().getName() + "cannot be written to");
                        error.setVisible(true);
                    }
                }
                else {
                    
                }
            }
            
        });
        
    }
}