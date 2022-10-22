# Generic reactive webhook

Expects HTTP POST and dumps JSON payload and HTTP headers to application log.

Uses Basic Auth - you will need to define FAI_WEBHOOK_USER and FAI_WEBHOOK_PASSWORD as environment variables.

To publish to Azure run:

`mvn com.microsoft.azure:azure-webapp-maven-plugin:2.5.0:config`

followed by:

`mvn package azure-webapp:deploy`

