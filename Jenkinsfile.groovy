node {
   def myant
     stage('clone the code') {
	      git 'https://github.com/HaneesH1994/ant_proj.git'
		  myant = tool 'Ant'
	}
      stage('Build the code') {
	     withEnv(["usrant=$myant"]) {
		       sh "$usrant/bin/ant"
		}
	}
	 stage('Deploy the code') {
	    sh '''
		ls -l
		'''
	}
}	
