# Enum Dialect Comparison
enum-dialect-comparison is a simple project to compare the behavior of PostgreSQL and MySQL when using enums.

## PostgreSQL Test Results
|                  | None | ENUM | NAMED_ENUM |
|------------------|------|------|------------|
| **contextLoads** | ✅    | ❌    | ✅          |
| **insert**       | ❌    | ❌    | ✅          |
| **select**       | ✅    | ❌    | ✅          |
| **update**       | ❌    | ❌    | ✅          |
| **delete**       | ✅    | ❌    | ✅          |

## MySQL Test Results
|                  | None | ENUM | NAMED_ENUM |
|------------------|------|------|------------|
| **contextLoads** | ✅    | ✅    | ❌          |
| **insert**       | ✅    | ✅    | ❌          |
| **select**       | ✅    | ✅    | ❌          |
| **update**       | ✅    | ✅    | ❌          |
| **delete**       | ✅    | ✅    | ❌          |