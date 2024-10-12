<H2>Pipeline CI/CD - AWS: ECR, ECS, Code Build, Deploy e Pipeline</H2>
<p>Criação de um fluxo de entrega continua e deploy continuo, utilizando Spring Boot e AWS.</p>
<p>Principal objetivo do projeto foi criar um processo de entrega da imagem do projeto, configurando o arquivo <strong>buildspec.yml</strong> para montar o ambiente de execução no AWS CodeBuild e ECR, após as configurações o processo de entrega começa com a execução do CodePipeline para unir todas as etapas e realizar o deploy da nova imagem(docker) do projeto, diretamente no ECS, gerando uma <strong>Task Definition</strong> para novas versões da imagem.</p>
<h2>Pipeline do Projeto:</h2>
<img src="https://github.com/user-attachments/assets/1331f3ea-0b17-45ba-83ce-7dcca9555211"/>
<h2>Passos para a criação de todo o fluxo:</h2>
<ol>
    <li>Subir o projeto para o repositório</li>
    <li>Criar um repositório no ECR</li>
    <li>Criar o arquivo <strong>buildspec.yml</strong> na raiz do projeto</li>
    <li>Substituir a variável <strong>REPOSITORY_URI</strong> para a url do seu repositório do ECR</li>
    <li>Substituir a variável <strong>DOCKER_CONTAINER_NAME</strong> para o nome do seu repositório do ECR</li>
    <li>Criar um projeto no CodeBuild e se conectar ao repositório do projeto - utilizar um Token do Github</li>
    <li>Habilitar os logs do CloudWatch para acompanhar todo o processo de sucesso/erro</li>
    <li>Adicionar as permissões no IAM para a role do projeto: <strong>AmazonEc2ContainerRegistry</strong></li>
    <li>Criar um Cluster ECS - Farget ou EC2</li>
    <li>Criar uma Task Definition para o projeto, adicionar o nome e url do repositório ECR na Task</li>
    <li>Definir a Task no Cluster, configurar um Security Groupy para ele</li>
    <li>Criar um processo de CI/CD no CodePipeline, difinindo a branch</li>
    <li>Configurar para realizar do deploy no ECS</li>
    <li>Executar o CodePipeline, será executado automaticamente para cada push na branch selecionada</li>
    <li>Tutorial: https://www.youtube.com/watch?v=ARGmrYFfv44&t=126s</li>
</ol>
