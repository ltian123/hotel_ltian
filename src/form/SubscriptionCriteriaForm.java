package form;

import org.apache.struts.action.ActionForm;

import vo.SubscriptionCriteria;

public class SubscriptionCriteriaForm  extends ActionForm{

	private SubscriptionCriteria subscriptionCriteria = new SubscriptionCriteria();

	public SubscriptionCriteria getSubscriptionCriteria() {
		return subscriptionCriteria;
	}

	public void setSubscriptionCriteria(SubscriptionCriteria subscriptionCriteria) {
		this.subscriptionCriteria = subscriptionCriteria;
	}
	
	
}
