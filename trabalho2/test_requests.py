from time import sleep
import requests

base_url = "http://localhost:8080"

def testReq(url):
    print(f"Testing '{url}'")
    print(requests.get(url).text)
    print()

while requests.get(f"{base_url}/").text != "Falae!":
    print("Waiting for server")
    sleep(1)

testReq(
    f"{base_url}/aluno/novo"
    "?nome=Daniel"
    "&email=daniel@email.com"
)
testReq(
    f"{base_url}/aluno/novo"
    "?nome=Daniel"
    "&email=daniel@email.com"
)
testReq(
    f"{base_url}/aluno/altera"
    "?id=2"
    "&nome=Jorge"
    "&email=jorge@email.com"
)
testReq(
    f"{base_url}/aluno/remove"
    "?id=2"
)

testReq(
    f"{base_url}/professor/novo"
    "?nome=Daniel"
    "&email=daniel@email.com"
)
testReq(
    f"{base_url}/professor/novo"
    "?nome=Daniel"
    "&email=daniel@email.com"
)
testReq(
    f"{base_url}/professor/altera"
    "?id=2"
    "&nome=Jorge"
    "&email=jorge@email.com"
)
testReq(
    f"{base_url}/professor/remove"
    "?id=2"
)

testReq(
    f"{base_url}/turma/novo"
    "?ano=2025"
    "&periodo=1"
    "&professorId=1"
)

testReq(
    f"{base_url}/inscricao/novo"
    "?alunoId=1"
    "&turmaId=1"
)
