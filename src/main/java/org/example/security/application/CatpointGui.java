package org.example.security.application;



import net.miginfocom.swing.MigLayout;
import org.example.image.FakeImageService;
import org.example.image.ImageService;
import org.example.security.data.PretendDatabaseSecurityRepositoryImpl;
import org.example.security.data.SecurityRepository;
import org.example.security.service.SecurityService;

import javax.swing.*;

/**
 * This is the primary JFrame for the application that contains all the top-level JPanels.
 *
 * We're not using any dependency injection framework, so this class also handles constructing
 * all our dependencies and providing them to other classes as necessary.
 */
public class CatpointGui extends JFrame {

    public CatpointGui() {
        setLocation(100, 100);
        setSize(600, 850);
        setTitle("Very Secure App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout());
        ImageService imageService = new FakeImageService();
        SecurityRepository securityRepository = new PretendDatabaseSecurityRepositoryImpl();
        SecurityService securityService = new SecurityService(securityRepository, imageService);
        DisplayPanel displayPanel = new DisplayPanel(securityService);
        mainPanel.add(displayPanel, "wrap");
        ImagePanel imagePanel = new ImagePanel(securityService);
        mainPanel.add(imagePanel, "wrap");
        ControlPanel controlPanel = new ControlPanel(securityService);
        mainPanel.add(controlPanel, "wrap");
        SensorPanel sensorPanel = new SensorPanel(securityService);
        mainPanel.add(sensorPanel);

        getContentPane().add(mainPanel);

    }
}
