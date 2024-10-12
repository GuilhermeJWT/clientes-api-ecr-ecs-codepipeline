<H2>Pipeline Ci/Cd - AWS: ECR, ECS, Code Build, Deploy e Pipeline</H2>
<p>Criação de um fluxo de entrega continua e deploy continuo, utilizando Spring Boot e AWS.</p>
<p>Principal objetivo do projeto foi criar um processo de entrega da imagem do projeto, configurando o arquivo <strong>buildspec.yml</strong> para montar o ambiente de execução no AWS CodeBuild e ECR, após as configurações o processo de entrega começa com a execução do CodePipeline para unir todas as etapas e realizar o deploy da nova imagem(docker) do projeto, diretamente no ECS, gerando uma <strong>Task Definition</strong> para novas versões da imagem.</p>
<br/>
