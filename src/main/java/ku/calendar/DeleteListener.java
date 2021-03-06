package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener{
	private MainView view;
	public DeleteListener(MainView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(view.getPanel2().getNoneRoutine().isSelected()){
				for(Date y:this.view.getPanel1().meeting){
					if((y.getDay().equals(this.view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(this.view.getPanel2().getChoiceMonth().getSelectedItem().toString()))&&(y.getYear()==this.view.getPanel1().getCurrentYear())
						&&(y.getStartTime().equals(this.view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(this.view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
						this.view.getPanel1().meeting.remove(y);
					}
				}

		}
			
		else if(view.getPanel2().getDailyRoutine().isSelected()){
			for(Date y:this.view.getPanel1().meeting){
				if((y.getStartTime().equals(this.view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(this.view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
					this.view.getPanel1().meeting.remove(y);
				}
			}
			
		}
		
		else if(view.getPanel2().getWeeklyRoutine().isSelected()){
			int totalMonth = 0;
			int month = (int) this.view.getPanel2().getChoiceMonth().getSelectedItem();
			for(int i = (int) this.view.getPanel2().getChoiceDay().getSelectedItem() ; month<13 ; i=i+7){
				if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
					totalMonth = 31;
				}
				else if((month==4)||(month==6)||(month==9)||(month==11)){
					totalMonth = 30;
				}
				else{
					if((this.view.getPanel1().currentYear%4==0)&&(this.view.getPanel1().currentYear%100==0)&&(this.view.getPanel1().currentYear%400==0)){
						totalMonth = 29;
					}
					else{
						totalMonth = 28;
					}
				}
				if(i>totalMonth){
					i = i-totalMonth;
					month++;
				}
				for(Date y:this.view.getPanel1().meeting){
					if((y.getDay().equals(Integer.toString(i)))&&(y.getMonth().equals(Integer.toString(month)))&&(y.getYear()==this.view.getPanel1().getCurrentYear())
						&&(y.getStartTime().equals(this.view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(this.view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
						this.view.getPanel1().meeting.remove(y);
					}
				}
			}
		}
		
		else if(view.getPanel2().getMonthlyRoutine().isSelected()){
			for(Date y:this.view.getPanel1().meeting){
				if((y.getDay().equals(this.view.getPanel2().getChoiceDay().getSelectedItem().toString()))
					&&(y.getStartTime().equals(this.view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(this.view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(this.view.getPanel2().getEvent().getText()))){
					this.view.getPanel1().meeting.remove(y);
				}
			}
		}
		
		
		
		this.view.getPanel2().getFrame().remove(this.view.getPanel2());
  		//this.view.getPanel2().getFrame().add(this.view.getPanel2());
  		this.view.getPanel2().getFrame().setVisible(false);
	}


}
