package jumperforgoalposts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI extends JFrame {
    private League league;
    private JButton saveButton, loadButton, addTeamButton, addPlayerButton, scheduleMatchButton, removeTeamButton, removePlayerButton, setFormationButton, addManagerButton, removeManagerButton, addRefereeButton, removeRefereeButton;
    private JTextArea leagueTableArea;

    public GUI() {
        league = new League();

        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Data");
        addTeamButton = new JButton("Add Team");
        addPlayerButton = new JButton("Add Player");
        scheduleMatchButton = new JButton("Schedule Match");
        removeTeamButton = new JButton("Remove Team");
        removePlayerButton = new JButton("Remove Player");
        setFormationButton = new JButton("Set Formation");
        addManagerButton = new JButton("Add Manager");
        removeManagerButton = new JButton("Remove Manager");
        addRefereeButton = new JButton("Add Referee");
        removeRefereeButton = new JButton("Remove Referee");

        leagueTableArea = new JTextArea(10, 30);
        leagueTableArea.setEditable(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveLoad.saveData(league.getTeams());
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                league.setTeams(SaveLoad.loadData());
                displayLeagueTable();
            }
        });

        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name:");
                String ground = JOptionPane.showInputDialog("Enter Home Ground:");
                int capacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Ground Capacity:"));
                Team team = new Team(teamName, ground, capacity);
                league.addTeam(team);
                displayLeagueTable();
            }
        });

        removeTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Remove:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    league.removeTeam(team);
                    displayLeagueTable();
                }
            }
        });

        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Add Player:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    String playerName = JOptionPane.showInputDialog("Enter Player Name:");
                    String position = JOptionPane.showInputDialog("Enter Position (GK, DF, MF, FW):");
                    Player player = new Player(playerName, position);
                    team.addPlayer(player);
                    displayLeagueTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Team not found!");
                }
            }
        });

        removePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Remove Player:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    String playerName = JOptionPane.showInputDialog("Enter Player Name to Remove:");
                    team.removePlayer(playerName);
                    displayLeagueTable();
                }
            }
        });

        setFormationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Set Formation:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    String formation = JOptionPane.showInputDialog("Enter Formation (e.g., 4-4-2):");
                    team.setFormation(formation);
                    JOptionPane.showMessageDialog(null, "Formation Set!");
                }
            }
        });

        addManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Add Manager:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    String managerName = JOptionPane.showInputDialog("Enter Manager Name:");
                    Manager manager = new Manager(managerName);
                    team.setManager(manager);
                    JOptionPane.showMessageDialog(null, "Manager Added!");
                }
            }
        });

        removeManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Enter Team Name to Remove Manager:");
                Team team = getTeamByName(teamName);
                if (team != null) {
                    team.setManager(null);
                    JOptionPane.showMessageDialog(null, "Manager Removed!");
                }
            }
        });

        addRefereeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matchWeek = JOptionPane.showInputDialog("Enter Match Week to Add Referee:");
                String refereeName = JOptionPane.showInputDialog("Enter Referee Name:");
                Referee referee = new Referee(refereeName);
                JOptionPane.showMessageDialog(null, "Referee Added!");
            }
        });

        removeRefereeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matchWeek = JOptionPane.showInputDialog("Enter Match Week to Remove Referee:");
                String refereeName = JOptionPane.showInputDialog("Enter Referee Name:");
                JOptionPane.showMessageDialog(null, "Referee Removed!");
            }
        });

        setLayout(new FlowLayout());
        add(addTeamButton);
        add(removeTeamButton);
        add(addPlayerButton);
        add(removePlayerButton);
        add(setFormationButton);
        add(addManagerButton);
        add(removeManagerButton);
        add(addRefereeButton);
        add(removeRefereeButton);
        add(saveButton);
        add(loadButton);
        add(new JScrollPane(leagueTableArea));

        setTitle("JumpersForGoalposts");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayLeagueTable() {
        StringBuilder table = new StringBuilder();
        for (Team team : league.getTeams()) {
            table.append(team.getName()).append(" - Points: ").append(team.getPoints()).append("\n");
        }
        leagueTableArea.setText(table.toString());
    }

    private Team getTeamByName(String name) {
        for (Team team : league.getTeams()) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new GUI();
    }
}
