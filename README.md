# Target Location Converter

As issue #1 mentioned, this small utility is developed to solve the following statement:

> Given the current capability to obtain the relative distance between the camera and the target, the system shall compute the target’s global position by transforming the relative pose using the robot’s known position and orientation (expressed as a quaternion).

## Basic Concept

Using homogeneous coordinates, we notated the robot's known position as $`
X= \begin{pmatrix}
a \\
b \\
c \\
1
\end{pmatrix}
`$
and the orientation as $
H= \begin{pmatrix}
x \\
y \\
z \\
w
\end{pmatrix}
$. 

### Rotation of known translation vector / matrix
Also assume that $T_l(v_x,v_y,v_z)$ is the local translation matrix from the camera (origin) to the target, which is 
$$
T_l(v_x,v_y,v_z)=
\begin{pmatrix}
1 & 0 & 0 & v_x \\
0 & 1 & 0 & v_y \\
0 & 0 & 1 & v_z \\
0 & 0 & 0 & 1
\end{pmatrix}
$$
, notated the corresponding local translation vector $\vec{t_l} = (v_x,v_y,v_z)$ as a pure quaternion, where
$$
t_l=
\begin{pmatrix}
v_x \\
v_y \\
v_z \\
0
\end{pmatrix}
$$

---
**Lemma 1**: A vector $\vec{p}$ can be rotated by a quaternion $q$. The result will be
$$
p'= q \cdot p \cdot q^*
$$
, where $p$ is the coresponding quaternion of $\vec{p}$.
---

As Lemma 1 mentioned, we can rotate the translation quaternion $t_l$ to $t_r$ like
$$
t_r=H \cdot t_l \cdot H^* 
$$

### Adding the local origin position

By $X$ and the rotated matrix $T_r$ (corresponding the quaternion $t_r$,) we can know the global translation matrix
$$
T_g = X + T_r
$$
, which corresponds the global position of the target.