###########################################
#
# Script para atualizar o Git Hub 
#
#
#
#
##########################################

clear 
readme=""
echo "Digite a inclusao do README ( Motivo da alteracao)  "
read readme 

echo "Digite a msg de commit "
read commit 


echo "# cadastro_Jtable" >> README.md
echo $readme >>README.md 
git init
if [ $? -ne 0 ] ; then 
   echo "Erro ao inicialiar o Git "
   sleep 2 
   exit 1 
fi 
#git add README.md
git add .  
if [ $? -ne 0 ] ; then 
   echo "Erro ao Adicionar ( Add ) README.md "
   sleep 2 
   exit 1 
fi 
git commit -m "Atualizacao em 11/11/2021"
if [ $? -ne 0 ] ; then 
   echo "Erro ao executar Commit  "
   sleep 2 
   exit 1 
fi 
git branch -M main
if [ $? -ne 0 ] ; then 
   echo "Erro ao executar Branch  "
   sleep 2 
   exit 1 
fi 
git remote add origin https://judney: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@github.com/judney/cadastro_Jtable.git

#git remote add origin https://github.com/judney/cadastro_Jtable.git
#git pull https://username:password@mygithost.com/my/repository
if [ $? -ne 0 ] ; then 
   echo "Erro ao adicionar URL [https://github.com/judney/cadastro_Jtable.git]"
   sleep 2 
#  exit 1 
fi 
git push -u origin main
if [ $? -ne 0 ] ; then 
   echo "Erro ao realizar o push em https://github.com/judney/cadastro_Jtable.git] "
   sleep 2 
   exit 1 
fi 









###Comandos de dia a dia 


#git remote add origin https://github.com/judney/cadastro_Jtable.git
#git branch -M main
#git push -u origin main
