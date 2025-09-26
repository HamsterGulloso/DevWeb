from time import sleep
import requests

base_url = "http://localhost:8080"


def testReq(url, **params):
    if params is not None:
        params_str = [f"{k}={v}" for k, v in params.items()]
        params_str = "?" + "&".join(params_str)
        url = f"{url}{params_str}"

    print(
        f"Request: '{url}'\n"
        "Response: '" + requests.get(url).text + "'\n"
    )


while True:
    try:
        sleep(1)
        requests.get(f"{base_url}/")
        break
    except KeyboardInterrupt:
        exit(0)
    except Exception:
        print("Waiting for server")

testReq(
    f"{base_url}/aluno/novo",
    nome="Daniel",
    email="daniel@email.com"
)
testReq(
    f"{base_url}/aluno/novo",
    nome="Daniel",
    email="daniel@email.com",
)
testReq(
    f"{base_url}/aluno/altera",
    id=2,
    nome="Jorge",
    email="jorge@email.com",
)
for _ in range(2):
    testReq(
        f"{base_url}/aluno/remove",
        id=2,
    )

testReq(
    f"{base_url}/professor/novo",
    nome="Daniel",
    email="daniel@email.com",
)
testReq(
    f"{base_url}/professor/novo",
    nome="Daniel",
    email="daniel@email.com",
)
testReq(
    f"{base_url}/professor/altera",
    id=2,
    nome="Jorge",
    email="jorge@email.com",
)
for _ in range(2):
    testReq(
        f"{base_url}/professor/remove",
        id=2,
    )

for _ in range(2):
    testReq(
        f"{base_url}/turma/novo",
        ano=2025,
        periodo=1,
        professorId=1,
    )
for _ in range(2):
    testReq(
        f"{base_url}/turma/remove",
        id=2,
    )

for _ in range(2):
    testReq(
        f"{base_url}/inscricao/novo",
        alunoId=1,
        turmaId=1,
    )
for _ in range(2):
    testReq(
        f"{base_url}/inscricao/remove",
        id=1,
    )
