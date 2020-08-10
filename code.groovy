job('job1-deploy-web-server') {
    description('job to deploy web-server')
    steps {
        shell('sh /code/code.sh')
    }
}
job('job2-test_code') {
    description('job to test the code and sent notification to developer')
    triggers {
        scm('@daily')
        upstream {
            upstreamProjects('job1-deploy-web-server')
            threshold('SUCCESS')
        }
    }
    steps {
        shell('sh /code/test_code.sh')
    }
}
buildPipelineView('Task 6') {
    filterBuildQueue()
    filterExecutors()
    title('Project for deploy web-server')
    displayedBuilds(5)
    selectedJob('job1-deploy-web-server')
    alwaysAllowManualTrigger()
    showPipelineParameters()
    refreshFrequency(60)
}
