package ListnersPak;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryL implements IRetryAnalyzer {
	int retrycount = 0;
	 int maxretyrcount =1;

	@Override
	public boolean retry(ITestResult result) {
	
	
		// TODO Auto-generated method stub
				if (retrycount<maxretyrcount){
	System.out.println("Retrying test _" + result.getName() + " _ with status _"
		     + getResultStatusName(result.getStatus()) + "_ for the _ " + (retrycount+1) + "_ time(s)._");
					retrycount++;
		            return true;
				}
				
				return false;
			}

			 public String getResultStatusName(int status) {
			    	String resultName = null;
			    	if(status==1)
			    		resultName = "SUCCESS";
			    	if(status==2)
			    		resultName = "FAILURE";
			    	if(status==3)
			    		resultName = "SKIP";
					return resultName;
			    }
	}


