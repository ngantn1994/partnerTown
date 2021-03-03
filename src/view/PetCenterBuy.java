package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import model.PetCenterBuyModel;
import model.PetType;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PetCenterBuy extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue = Integer.parseInt( "2F1515", 16);
	private Color fgColor = new Color(fgValue);

	private static final String BGIMG = "images/petcenter/buybg.png";
	private static final String BACK1 = "images/buttons/back1.png";
	private static final String BACK2 = "images/buttons/back2.png";
	
	private static final String BUY1 = "images/petcenter/buypet1.png";
	private static final String BUY2 = "images/petcenter/buypet2.png";
	
	private static final String MONEYIMG = "images/petcenter/money.png";
	
	private static final String MONEY = "S\u1ED1 ti\u1EC1n hi\u1EC7n có: ";
	private static final String TITLE = "Mua m\u1EDBi";
	
	private static final String ID = "STT";
	private static final String DESCRIP = "Gi\u1EDBi thi\u1EC7u";
	private static final String LEVELS = "S\u1ED1 Level";
	private static final String PRICE = "Giá";
	private static final String LEVEL1 = "Level 1";
	
	private PatternProgressBar energyBar;
	private BufferedImageButton backButton;
	
	private BufferedImageButton buyButton;
	private JLabel moneyLabel;
	
	private JTable table;
	private MainTableModel tbmodel;
	private CellRenderer cellRenderer;
	
	public PetCenterBuy(PatternProgressBar bar, PetCenterBuyModel model){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel fixedLabel = new JPanel();
		fixedLabel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Energy", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		fixedLabel.setPreferredSize(new Dimension(550,100));
		fixedLabel.setOpaque(false);
		fixedLabel.setLayout(new FlowLayout());
		fixedLabel.setForeground(new Color(0, 0, 128));
		bgPanel.add(fixedLabel, BorderLayout.NORTH);
		
		energyBar = bar;
		fixedLabel.add(energyBar);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(1000, 100));
		
		ImagePanel moneyPanel = new ImagePanel(MONEYIMG);
		moneyPanel.setLayout(new FlowLayout());
		moneyPanel.setPreferredSize(new Dimension(370, 100));
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setOpaque(false);
		emptyLabel.setPreferredSize(new Dimension(370,10));
		moneyPanel.add(emptyLabel);
		
		moneyLabel = new JLabel(MONEY + "1000$", JLabel.CENTER);
		moneyLabel.setForeground(fgColor);
		moneyLabel.setFont(BIGGER_FONT);
		moneyLabel.setOpaque(false);
		moneyPanel.add(moneyLabel);
		
		buyButton = new BufferedImageButton(BUY1, BUY2, 300, 100);
		
		backButton = new BufferedImageButton(BACK1, BACK2, 300, 100);
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.insets = new Insets(0, 0, 0, 5);
		gbc_moneyLabel.gridx = 0;
		gbc_moneyLabel.gridy = 0;
		buttonPanel.add(moneyPanel, gbc_moneyLabel);
		
		GridBagConstraints gbc_buyButton = new GridBagConstraints();
		gbc_buyButton.insets = new Insets(0, 0, 0, 5);
		gbc_buyButton.gridx = 1;
		gbc_buyButton.gridy = 0;
		buttonPanel.add(buyButton, gbc_buyButton);
		
		GridBagConstraints gbc_mapButton = new GridBagConstraints();
		gbc_mapButton.gridx = 2;
		gbc_mapButton.gridy = 0;
		buttonPanel.add(backButton, gbc_mapButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		bgPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(SMALLER_FONT);
		table.setForeground(fgColor);
		table.setBackground(Color.WHITE);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		tbmodel = new MainTableModel();
		tbmodel.setPetTypes(model.getPetTypes());
		table.setModel(tbmodel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(630);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		table.setRowHeight(130);
		
		cellRenderer = new CellRenderer();
		
		for(int i=0;i<table.getRowCount();i++){
    		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
    	}
		
		setContentPane(bgPanel);
		
	}
	
	class MainTableModel extends DefaultTableModel {

		private static final long serialVersionUID = 2L;
		private List<PetType>	types;
		

		public MainTableModel () {
			super();
			types = new ArrayList<PetType>();
		}

		private final String[]	HEADER_NAME	= new String[] {ID, DESCRIP, LEVELS, PRICE, LEVEL1};

		@Override
		public String getColumnName(int column) {
			return column >= 0 && column < HEADER_NAME.length ? HEADER_NAME[column] : super.getColumnName(column);
		}


		@Override
		public int getColumnCount() {
			return HEADER_NAME.length;
		}

		@Override
		public int getRowCount() {
			return types != null ? types.size() : super.getRowCount();
		}

		@Override
		public Object getValueAt(int row, int column) {
			if (types != null && 0 <= row && row < types.size()) {
				PetType petType = types.get(row);
				if (petType != null) {
					switch (column) {
						case 0:
							return petType.getID() + "";
						case 1:
							return petType.getDescription();
						case 2:
							return petType.getLevels() + "";
						case 3:
							return petType.getPrice() + "$";
						case 4:
							return petType.getID() + "";
						default:
							return null;
					}
				}
			}
			return super.getValueAt(row, column);
		}
		
		public void setPetTypes(List<PetType> types) {
			this.types = types;
			fireTableDataChanged();
		}
		
		public PetType getPetType(int index) {
			if(types != null && 0 <= index && index <= types.size())
				return types.get(index);
			
			return null;
		}
	}
	
	class CellRenderer extends DefaultTableCellRenderer{

		private static final long serialVersionUID = 1L;

		private CellRenderer(){
	        setHorizontalAlignment(JLabel.CENTER);
	    }

	    @Override
	    public JComponent getTableCellRendererComponent(JTable table,
	            Object value, boolean isSelected, boolean hasFocus, int row,
	            int column){
	    	AnimatedIcon icon = View.getIcon(row);
	    	setIcon(icon);
	    	return this;
	    }
	}
	
	public void changeMoney(int money){
		moneyLabel.setText(MONEY + money + "$");
	}
	
	public void setBuyButtonListerner(ActionListener listerner){
		buyButton.addActionListener(listerner);
	}
	
	public void setBackButtonListerner(ActionListener listerner){
		backButton.addActionListener(listerner);
	}
	
	public PetType getSelectedPetType(){
		if(table != null) {
			int rowSelectedIndex = table.getSelectedRow();
			
			MainTableModel tableModel = (MainTableModel)table.getModel();
			return tableModel.getPetType(rowSelectedIndex);
		}
		return null;
	}
	
}
