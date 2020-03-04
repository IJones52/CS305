// finish (and comment) me!

package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
     * Image field
     * */
    private JLabel img;
    
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
    
    public void onFileOpen() {
        JFileChooser chooser = new JFileChooser();
        //Display the image
        int returnVal = chooser.showOpenDialog(SnapShopGUI.this);
        
        //if a file is selected
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            //Display image
            try {
                PixelImage pixels = PixelImage.load(chooser.getSelectedFile());
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
                //No file popup
            }
            

        }
        else {
            //do nothing
        }
       
    }
    
    public void onFileClose() {
        //disable the buttons
        disableAll();
        //Delete the image
        setupCenter();
        pack();
    }
    
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
    
    public void setupActions() {
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onFileClose();
            }
            
        });
    }
}