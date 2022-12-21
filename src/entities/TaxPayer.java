package entities;

public class TaxPayer {

	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double month = salaryIncome / 12.0;
		if (month < 3000.0) {
			return 0;
		}
		else if (month < 5000.0) {
			return salaryIncome * 0.1;
		}
		else {
			return salaryIncome * 0.2;
		}
	}
	
	public double servicesTax() {
		return serviceIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		
		double spendings = healthSpending + educationSpending;
		double max = 0.3 * grossTax();
		
		if (spendings > max) {
			return max;
		}
		else {
			return spendings;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
}